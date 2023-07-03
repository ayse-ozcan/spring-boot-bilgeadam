package com.ayseozcan.mapper;

import com.ayseozcan.dto.request.RandevuSaveRequestDto;
import com.ayseozcan.dto.response.RandevuFindAllResponseDto;
import com.ayseozcan.dto.response.RandevuSaveResponseDto;
import com.ayseozcan.repository.entity.Randevu;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRandevuMapper {
    IRandevuMapper INSTANCE = Mappers.getMapper(IRandevuMapper.class);
    Randevu toRandevu(final RandevuSaveRequestDto dto);
    RandevuSaveResponseDto tRandevuSaveResponseDto(final Randevu randevu);
    RandevuFindAllResponseDto tRandevuFindAllResponseDto(final Randevu randevu);
}
