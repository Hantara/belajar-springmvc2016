/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package angga.hantara.belajar.ci.dao;

import angga.hantara.belajar.ci.entity.Kategori;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Angga Hantara
 */
public interface KategoriDAO extends PagingAndSortingRepository<Kategori, Integer>{
    
}
