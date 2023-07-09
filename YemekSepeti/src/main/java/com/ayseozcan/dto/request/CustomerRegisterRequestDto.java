package com.ayseozcan.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRegisterRequestDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @NotEmpty
    @Email(message = "Please enter a valid email address.")
    private String email;
    @NotEmpty
    @Pattern(
            message = "The password must contain at least one digit,one lowercase letter,one uppercase letter," +
                    "one special character,no whitespace,and be between 8 and 20 characters in length.",
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*!])(?=\\S+$).{8,20}$")
    private String password;
}
