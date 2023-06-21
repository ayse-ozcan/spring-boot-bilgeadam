package com.ayseozcan.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.*;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RandevuSaveRequestDto {
    @NotNull
    Long doktorid;
    @NotNull
    Long hastaid;

    Integer gun;
    Integer ay;
    Integer yil;
    Integer saat;
    Integer dakika;

    public Date convertDate() {
        LocalDate localDate = LocalDate.of(getYil(),getAy(),getGun());
        LocalTime localTime = LocalTime.of(getSaat(),getDakika());
        LocalDateTime localDateTime = LocalDateTime.of(localDate,localTime);
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        long tarih = instant.toEpochMilli();
        Date date = new Date(tarih);
        return date;
    }
}
