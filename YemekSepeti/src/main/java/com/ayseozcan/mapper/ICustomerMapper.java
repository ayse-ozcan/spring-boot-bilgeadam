package com.ayseozcan.mapper;

import com.ayseozcan.dto.request.CardDetailsSaveRequestDto;
import com.ayseozcan.dto.request.CustomerRegisterRequestDto;
import com.ayseozcan.repository.entity.CardDetail;
import com.ayseozcan.repository.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICustomerMapper {
    ICustomerMapper INSTANCE = Mappers.getMapper(ICustomerMapper.class);
    Customer fromRegisterDto(final CustomerRegisterRequestDto dto);
}
