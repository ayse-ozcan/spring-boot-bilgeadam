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
@Table(name = "tbldepartman")
public class Departman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    Long yoneticiid;
    String konum;
    Long createdat;
    Long updatedat;
    /**
     * kaydin aktif olup olamdigini belirtir.
     * DIKKAT!! veritabanindan kayit silinmez. Sadece bu alan true ya da false olur.
     */
    Boolean isacvtive;
}
