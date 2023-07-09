package com.ayseozcan.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderSaveRequestDto {
    @NotNull
    private Long customerid;
    @NotNull
    private Long restaurantid;
    @NotNull
    private Long productid;;
    private LocalDateTime dateTime;
}
