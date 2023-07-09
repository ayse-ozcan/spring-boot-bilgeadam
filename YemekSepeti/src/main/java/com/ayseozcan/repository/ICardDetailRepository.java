package com.ayseozcan.repository;

import com.ayseozcan.repository.entity.CardDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICardDetailRepository extends JpaRepository<CardDetail,Long> {
}
