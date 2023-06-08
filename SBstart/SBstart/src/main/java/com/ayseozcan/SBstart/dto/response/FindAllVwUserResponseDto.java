package com.ayseozcan.SBstart.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindAllVwUserResponseDto {
    Long id;
    String ad;
    String photo;
    String acildurumkisisi;
}
