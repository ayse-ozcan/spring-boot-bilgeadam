package com.ayseozcan.SBstart.repository;

import com.ayseozcan.SBstart.repository.entity.Personel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonelRepository extends JpaRepository<Personel,Long> {
}
