package com.ayseozcan.repository;

import com.ayseozcan.repository.entity.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IRandevuRepository extends JpaRepository<Randevu,Long> {
    //TODO: findmostfrequent
    //@Query("select new com.ayseozcan.repository.entity.Randevu(r.doktorid, count(r.doktorid)) from Randevu r group by r.doktorid order by count(r.doktorid) desc ")
    @Query(value = "select tr.doktorid, count(tr.doktorid) as mf from tblrandevu tr group by tr.doktorid order by count(tr.doktorid) desc",nativeQuery = true)
    List<Randevu> findMostFrequent();

}