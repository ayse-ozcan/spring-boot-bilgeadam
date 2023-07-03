package com.ayseozcan.repository;

import com.ayseozcan.repository.entity.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface IRandevuRepository extends JpaRepository<Randevu,Long> {
    Optional<Randevu> findOptionalByRandevuTarih(LocalDateTime time);
    Optional<Randevu> findOptionalByRandevuDurumFalse();
    @Modifying
    @Transactional
    @Query(value = "update Randevu r set r.randevuDurum= ?1 where r.email =?2")
    void updateDurum(boolean durum, String email);
}
