package com.ayseozcan.SBstart.repository;

import com.ayseozcan.SBstart.repository.entity.PersonelDepartman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonelDepartmanRepository extends JpaRepository<PersonelDepartman,Long> {
    List<PersonelDepartman> findByDepartmanid(Long id);
}
