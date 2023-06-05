package com.ayseozcan.SBstart.utility;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class ServiceManager<T, ID> implements IService<T, ID> {
    private final JpaRepository<T, ID> repository;

    public ServiceManager(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    /**
     * guncelleme ve kaydetme islemleri repository de save(T entity) seklinde tanimlanir.
     * peki guncellemeyi kaydetmeden nasil ayirt ediyoruz?
     * bir ORM araci kayitlari varliklarla eslestirirken ID yi kullanir.
     * Yani varlik-tablo iliskisini ID ile yapar.
     * bu nedenle eger kayit ettiginiz entity icinde id bilgisi null ise save methodu kayit islemi yapar.
     * eger id bilgisi null degil ise guncelleme islemi yapar.
     */

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> entityList) {
        return repository.saveAll(entityList);
    }

    @Override
    public T update(T entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public List<T> findAllByIds(List<ID> ids) {
        return repository.findAllById(ids);
    }
}
