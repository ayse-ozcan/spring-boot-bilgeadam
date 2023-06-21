package com.ayseozcan.mapper;

import com.ayseozcan.dto.request.DoktorSaveRequestDto;
import com.ayseozcan.dto.response.DoktorResponseDto;
import com.ayseozcan.repository.entity.Doktor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IDoktorMapper {
    IDoktorMapper INSTANCE = Mappers.getMapper(IDoktorMapper.class);
    Doktor fromSaveDto(final DoktorSaveRequestDto dto);
    DoktorResponseDto fromDoktor(final Doktor doktor);
}
