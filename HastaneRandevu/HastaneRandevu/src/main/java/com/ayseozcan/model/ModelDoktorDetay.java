package com.ayseozcan.model;

import com.ayseozcan.repository.entity.Doktor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModelDoktorDetay {
    Doktor doktor;
}
