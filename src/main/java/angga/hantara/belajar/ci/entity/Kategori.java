/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package angga.hantara.belajar.ci.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Angga Hantara
 */
@Entity
@Table(name = "m_kategori")
public class Kategori {
    @Id
    @GeneratedValue
    private Integer kategori_id;
    
    @NotNull @NotEmpty @Size(min = 3, max = 10)
    @Column(nullable = false, unique = true)
    private String kode_kategori;
    
    @NotNull @NotEmpty @Size(min = 3, max = 255)
    @Column(nullable = false)
    private String nama_kategori;

    /**
     * @return the kategori_id
     */
    public Integer getKategori_id() {
        return kategori_id;
    }

    /**
     * @param kategori_id the kategori_id to set
     */
    public void setKategori_id(Integer kategori_id) {
        this.kategori_id = kategori_id;
    }

    /**
     * @return the kode_kategori
     */
    public String getKode_kategori() {
        return kode_kategori;
    }

    /**
     * @param kode_kategori the kode_kategori to set
     */
    public void setKode_kategori(String kode_kategori) {
        this.kode_kategori = kode_kategori;
    }

    /**
     * @return the nama_kategori
     */
    public String getNama_kategori() {
        return nama_kategori;
    }

    /**
     * @param nama_kategori the nama_kategori to set
     */
    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }
    
}
