package com.ayseozcan.repository;

import com.ayseozcan.repository.entity.Brans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBransRepository extends JpaRepository<Brans,Long> {
    /**
     * bu deger varsa ise nesne gelecek yok ise null donecek
     * bunun yerine ne kullanilabilir?
     * Optional<>
     */
    Optional<Brans> findOptionalByAdIgnoreCase(String ad);

}
