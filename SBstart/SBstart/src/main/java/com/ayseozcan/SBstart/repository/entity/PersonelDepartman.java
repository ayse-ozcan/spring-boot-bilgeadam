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
@Table(name = "tblpersoneldepartman")
public class PersonelDepartman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long departmanid;
    Long personelid;
}
