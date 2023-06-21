package com.ayseozcan.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tblrandevu")
public class Randevu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long doktorid;
    Long hastaid;
    Long tarih;
    Long zaman;
    Date randevuTarih;
    /**
     * 0: Beklemede
     * 1: Onaylandi
     * 2: Reddedildi
     * 3: Iptal edildi
     * 4: Tamamlandi
     */
    Long durum;
}
