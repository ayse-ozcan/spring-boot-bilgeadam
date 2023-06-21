package com.ayseozcan.repository;

import com.ayseozcan.dto.response.DoktorResponseDto;
import com.ayseozcan.repository.entity.Doktor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDoktorRepository extends JpaRepository<Doktor,Long> {
    List<Doktor> findAllByAd(String ad);
    List<Doktor> findAllByAdContaining(String ad);
    Optional<Doktor> findOptionalByTelefon(String telefon);
    Optional<Doktor> findOptionalByBransid(Long bransid);


}
