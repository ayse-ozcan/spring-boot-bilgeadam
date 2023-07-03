package com.ayseozcan.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tblrandevu")
public class Randevu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long musteriId;
    private String ad;
    private String soyad;
    @Column(unique = true)
    private String telefon;
    @Column(unique = true)
    private String email;
    private LocalDateTime randevuTarih;
    private boolean randevuDurum;

}
