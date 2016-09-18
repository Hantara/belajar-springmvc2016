/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package angga.hantara.belajar.ci.controller;

import angga.hantara.belajar.ci.dao.KategoriDAO;
import angga.hantara.belajar.ci.entity.Kategori;
import angga.hantara.belajar.ci.exception.DataNotFoundException;
import java.net.URI;
import org.springframework.transaction.annotation.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Angga Hantara
 */

@RestController
@RequestMapping("/kategori")
@Transactional(readOnly = true)
public class KategoriController {
    
    @Autowired KategoriDAO kategoridao;
    
    //Method untuk membuat Kategori
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @org.springframework.transaction.annotation.Transactional(readOnly = false)
    public ResponseEntity<Void> create(@RequestBody @Valid Kategori k, UriComponentsBuilder uriBuilder) {
        kategoridao.save(k);
        URI location = uriBuilder.path("kategori/{id}")
                .buildAndExpand(k.getKategori_id()).toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    
    
    //Method untuk menampilkan semua data katgori
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Page<Kategori> findAll(Pageable page) {
        return kategoridao.findAll(page);
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Kategori findById(@PathVariable("id") Kategori p) {
        if (p == null) {
          throw new DataNotFoundException("No data with the specified id");
        }

        return p;
    }
    
}
