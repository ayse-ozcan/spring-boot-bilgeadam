package com.ayseozcan.repository.entity;

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
@Table(name = "tblcarddetail")
public class CardDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long customerid;
    @Column(nullable = false)
    private String cardName;
    @Column(length = 16,nullable = false)
    private String cardNumber;
    @Column(length = 3,nullable = false)
    private String cvv;
    @Column(length = 7,nullable = false)
    private String cardExpiration;
    private double balance;
}
