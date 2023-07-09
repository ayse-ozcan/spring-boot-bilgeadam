package com.ayseozcan.dto.request;

import com.ayseozcan.repository.enums.ECategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductSaveRequestDto {
    private String name;
    private ECategory category;
    private double cost;
}
