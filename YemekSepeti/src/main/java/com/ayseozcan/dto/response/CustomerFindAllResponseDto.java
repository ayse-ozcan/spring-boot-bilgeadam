package com.ayseozcan.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerFindAllResponseDto {
    private String name;
    private String surname;
    private String email;
    private String address;
    private String phoneNumber;
}
