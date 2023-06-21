package com.ayseozcan.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RandevuSaveResponseDto {
    Date randevuTarihi;
    Long doktorid;
    Long hastaid;
}
