/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package angga.hantara.belajar.ci.dao;

/**
 *
 * @author Angga Hantara
 */
import angga.hantara.belajar.ci.dao.KategoriDAO;
import angga.hantara.belajar.DemoApplication;
import angga.hantara.belajar.ci.entity.Kategori;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author Angga Hantara
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@Transactional
@Sql(scripts = {"/mysql/delete-data.sql", "/mysql/sample-kategori.sql"})
public class KategoriDAOTest {
    
    @Autowired private KategoriDAO kategoridao;
    
    @Test 
    public void testFindById(){
             
        Kategori p = kategoridao.findOne(1);
        Assert.assertNotNull(p);
        Assert.assertEquals("KTO2", p.getKode_kategori());
        Assert.assertEquals("IPA", p.getNama_kategori());
        
        Assert.assertNull(kategoridao.findOne(-1));
    }
    
    @Test
    public void testSave(){
        Kategori p = new Kategori();
        
        p.setKode_kategori("KS03");
        p.setNama_kategori("Test Kategori 001");
        
        Assert.assertNull(p.getKategori_id());
        kategoridao.save(p);
        Assert.assertNotNull(p.getKategori_id());
    }
    
    @Test
    public void testCount(){
        double ps = kategoridao.count();
        
        Assert.assertEquals(2, ps, 0.2);
    }
    
    
}
