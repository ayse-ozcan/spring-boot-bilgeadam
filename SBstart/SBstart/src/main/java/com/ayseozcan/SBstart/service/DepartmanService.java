package com.ayseozcan.SBstart.service;

import com.ayseozcan.SBstart.repository.IDepartmanRepository;
import com.ayseozcan.SBstart.repository.entity.Departman;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmanService {

    /**
     * spring de bir sinifa ya da interface e referans atamanin yani new
     * islemi yaparak bir nesne olusturmanin 2 yolu vardir.
     * 1- @Autowired annotation ile
     * 2- Constructor injection ile -> spring boot contexxt icinde yarattigi nesnelerin
     * referanslarini ihtiyaci olan siniflara parametre olarak gonderir.
     */

    private final IDepartmanRepository departmanRepository;
    public DepartmanService(IDepartmanRepository departmanRepository){
        this.departmanRepository = departmanRepository;
    }
    public void save(Departman departman){
        departmanRepository.save(departman);
    }
    public List<Departman> findAll(){
        return departmanRepository.findAll();
    }
    public void delete(Long id){
        departmanRepository.deleteById(id);
    }
    public void test(){
    }
    /**
     * bir yomneticinin bakmakta oldugu departmanlar?
     */
    public List<Departman> findByYoneticiId(Long id){
        return null;
    }
    public List<Departman> findAllKonumAdi(String konumad){
        return departmanRepository.findAllByKonum(konumad);
    }
}
