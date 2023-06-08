package com.ayseozcan.SBstart.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tblpersonel")
public class Personel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    String adres;
    String telefon;
    String photo;
    Integer yas;
    String acildurumtelefon;
    String acildurumkisisi;
    Long girisTarihi;
    /**
     * 0-onaysiz
     * 1-personel
     * 2-yonetici
     * 3-admin
     */
    Integer type;
}
