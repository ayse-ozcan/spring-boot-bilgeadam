package com.ayseozcan.SBstart.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SavePersonelRequestDto {
    @NotBlank(message = "Ad alani bos birakilamaz")
    @Size(min = 3, max = 50)
    String ad;
    @NotNull
    String adres;
    @NotNull
    @Email
    String email;
    @NotNull
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
    @Size(min = 8, max = 64)
    String password;
    String telefon;
    String acildurumtelefon;
    String acildurumkisisi;
    Long memberdate;
}
