package com.ayseozcan.SBstart.utility;

import java.util.List;
import java.util.Optional;

public interface IService <T,ID>{
    T save(T entity);
    //return yapmamiz gereken durumlar icin void save -> void yerine T (entity) kullanilmali.
    Iterable<T> saveAll(Iterable<T> entityList);
    T update(T entity);
    void delete(T entity);
    void deleteById(ID id);
    Optional<T> findById(ID id);
    List<T> findAll();
    List<T> findAllByIds(List<ID> ids);
}
