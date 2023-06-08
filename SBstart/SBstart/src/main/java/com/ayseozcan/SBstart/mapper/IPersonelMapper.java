package com.ayseozcan.SBstart.mapper;

import com.ayseozcan.SBstart.dto.request.SavePersonelRequestDto;
import com.ayseozcan.SBstart.dto.response.FindAllVwUserResponseDto;
import com.ayseozcan.SBstart.repository.entity.Personel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * Bir interface in mapper islemi yapabilmesi icin @Mapper annotation i kullanilmalidir.
 * burada tanimlama yaparken kullanilan componentModel = "spring" ile spring tarafindan
 * yonetilen bean yapisinin entegre edilecegini belirtiyoruz.
 * Ikinci onemli kisim ise mapping isleminde kaynak ile hedefin uyusmayan alanlarinin nasil davranacagini
 * belirtiyoruz. Iki alan birebiri birbirine karsilik gelmeyebilir. Bu nedenle uyusmayan alanlar hata
 * firlatacaktir. Bu nedenle uyusmazlikklari ignore ediyoruz. Boylece hata firlatmadan islemi
 * gerceklestirebilir.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPersonelMapper {
    /**
     * Burasi bizim interface imizden bir nesne yaratilarak referansinin atanmasini sagliyor.
     * boylece biz de bu nesneyi kullanarak mapping islemlerini gerceklestiriyoruz.
     */
    IPersonelMapper INSTANCE = Mappers.getMapper(IPersonelMapper.class);

    /**
     * Artik buradan itibaren gerekli kurulumlar bittiginden dolayi donusum icin gerekli method
     * tanimlamalari yapilir.
     */
    /**
     * geri donus tipi olarak sinifi veriyoruz
     * method adini istediginiz gibi yazabilirsiniz. Amaca hizmet etsin, anlasilsin yeter
     * parametre olarak dto muzu veriyoruz
     * [Referans Data Type] [method name] [Parameter]
     *    target                            source
     */
    @Mapping(source = "memberdate", target = "girisTarihi")
    Personel fromDtoToPersonel(final SavePersonelRequestDto dto);
    FindAllVwUserResponseDto fromPersonelToDto(final Personel personel);
}
