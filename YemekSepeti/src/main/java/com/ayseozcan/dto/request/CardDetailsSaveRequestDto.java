package com.ayseozcan.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardDetailsSaveRequestDto {
    @NotNull
    private Long customerid;
    @NotEmpty
    private String cardName;
    @NotEmpty
    @Size(max = 16, min = 16)
    private String cardNumber;
    @NotEmpty
    @Size(max = 3, min = 3)
    private String cvv;
    @NotEmpty
    @Size(max = 7, min = 7)
    private String cardExpiration;
    private double balance;
}
