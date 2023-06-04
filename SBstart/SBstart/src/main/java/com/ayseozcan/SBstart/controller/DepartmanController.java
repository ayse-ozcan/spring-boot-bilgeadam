package com.ayseozcan.SBstart.controller;

import com.ayseozcan.SBstart.repository.entity.Departman;
import com.ayseozcan.SBstart.service.DepartmanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller katmaninda web icin 2 kullanim sekli var
 * 1- @Controller -> MVC odakli programlama
 * 2- @RestController -> RestFul web servisler
 */
@RestController
// http://localhost:9090/departman
@RequestMapping("/departman")
public class DepartmanController {

   private final DepartmanService departmanService;
   public DepartmanController(DepartmanService departmanService){
       this.departmanService = departmanService;
   }

    /**
     * @GetMapping -> sadece get isteklerini karsilar
     */
    // http://localhost:9090/departman/getAll
    @GetMapping("/getAll")
    public List<Departman> getAll(){
        return departmanService.findAll();
    }

    /**
     * http://localhost:9090/departman/save?ad=IT&konum=Istanbul
     */
    @GetMapping("/save")
    public void save(String ad, String konum){
        Departman departman = Departman.builder().ad(ad).konum(konum).build();
        departmanService.save(departman);
    }

    // http://localhost:9090/departman/delete?id=2
    @GetMapping("/delete")
    public void delete(Long id){
        departmanService.delete(id);
    }

    @GetMapping("/findkonum")
    public List<Departman> findByKonum(String ad){
        return departmanService.findAllKonumAdi(ad);
    }
}
