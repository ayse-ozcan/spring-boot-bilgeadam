package com.ayseozcan.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RandevuSaveRequestDto {
    @NotEmpty
    private String ad;
    @NotEmpty
    private String soyad;
    @NotEmpty
    private String email;
    @NotNull
    private int gun;
    @NotNull
    private int ay;
    @NotNull
    private int yil;
    @NotNull
    private int saat;
    @NotNull
    private int dakika;
    private boolean radevuDurum;

    public LocalDateTime convertDate(){
        LocalDate localDate = LocalDate.of(getYil(),getAy(),getGun());
        LocalTime localTime = LocalTime.of(getSaat(),getDakika());
        LocalDateTime localDateTime = LocalDateTime.of(localDate,localTime);
        return localDateTime;
    }

}
