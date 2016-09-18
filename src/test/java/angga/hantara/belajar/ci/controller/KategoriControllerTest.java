/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package angga.hantara.belajar.ci.controller;

import angga.hantara.belajar.DemoApplication;
import angga.hantara.belajar.ci.entity.Kategori;
import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import com.jayway.restassured.http.ContentType;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Angga Hantara
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@Sql(scripts = {"/mysql/delete-data.sql", "/mysql/sample-kategori.sql"})
@WebIntegrationTest(randomPort = true)
public class KategoriControllerTest {
    private static final String BASE_URL = "/kategori";
    
    @Value("${local.server.port}")
    int serverPort;

    @Before
    public void setup() {
        RestAssured.port = serverPort;
    }
    @Test
    public void testFindAll() {
        get(BASE_URL+"/")
          .then()
          .body("totalElements", equalTo(2))
          .body("content.kode_kategori", hasItems("KTO2"));
    }
    
    
    @Test
    public void testSave() throws Exception {

        Kategori k = new Kategori();
        k.setKode_kategori("PT-001");
        k.setNama_kategori("Kategori Test 001");
        

        given()
          .body(k)
          .contentType(ContentType.JSON)
          .when()
          .post(BASE_URL+"/")
          .then()
          .statusCode(201)
          .header("Location", containsString(BASE_URL+"/"))
          .log().headers();
        
        // nama tidak diisi
        Kategori px = new Kategori();
        px.setKode_kategori("PT-001");
        given()
                .body(px)
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_URL+"/")
                .then()
                .statusCode(400);

        // kode kurang dari 3 huruf
        Kategori px1 = new Kategori();
        px1.setKode_kategori("PT");
        given()
                .body(px1)
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_URL+"/")
                .then()
                .statusCode(400);
    }
    
    @Test
    public void testFindById() {
        get(BASE_URL+"/1")
          .then()
          .statusCode(200)
          .body("kode_kategori", equalTo("KTO2"))
          .body("nama_kategori", equalTo("IPA"));

        get(BASE_URL+"/990")
          .then()
          .statusCode(404);
    }
    
}
