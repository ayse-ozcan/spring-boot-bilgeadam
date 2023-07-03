package com.ayseozcan.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RandevuFindAllResponseDto {
    private String ad;
    private String soyad;
    private String email;
    private LocalDateTime randevuTarih;
    private boolean radevuDurum;
}
