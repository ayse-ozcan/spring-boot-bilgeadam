package com.ayseozcan.model;

import com.ayseozcan.repository.entity.Doktor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModelDoktorSearch {
    List<Doktor> doktorList;
}
