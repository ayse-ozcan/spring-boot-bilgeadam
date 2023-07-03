package com.ayseozcan.service;

import com.ayseozcan.dto.request.RandevuSaveRequestDto;
import com.ayseozcan.dto.response.RandevuFindAllResponseDto;
import com.ayseozcan.dto.response.RandevuSaveResponseDto;
import com.ayseozcan.exception.ErrorType;
import com.ayseozcan.exception.MaratonException;
import com.ayseozcan.repository.IRandevuRepository;
import com.ayseozcan.repository.entity.Randevu;
import com.ayseozcan.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RandevuService extends ServiceManager<Randevu,Long> {
    private final IRandevuRepository randevuRepository;
    public RandevuService(IRandevuRepository randevuRepository){
        super(randevuRepository);
        this.randevuRepository = randevuRepository;
    }
    public RandevuSaveResponseDto save(RandevuSaveRequestDto dto){
        Randevu randevu = Randevu.builder()
                .ad(dto.getAd())
                .soyad(dto.getSoyad())
                .email(dto.getEmail())
                .randevuTarih(dto.convertDate())
                .randevuDurum(true)
                .build();
        Optional<Randevu> tarih = randevuRepository.findOptionalByRandevuTarih(dto.convertDate());
        if (tarih.isPresent()){
            throw new MaratonException(ErrorType.GECERSIZ_RANDEVU_TARIHI);
        }else{
            randevuRepository.save(randevu);
        }
        return RandevuSaveResponseDto.builder()
                .email(randevu.getEmail())
                .randevuTarih(randevu.getRandevuTarih())
                .randevuDurum(randevu.isRandevuDurum())
                .build();
    }
    public List<RandevuFindAllResponseDto> findAllDto(){
       return randevuRepository.findAll().stream()
               .map(x-> RandevuFindAllResponseDto.builder().ad(x.getAd()).soyad(x.getSoyad())
                       .email(x.getEmail()).randevuTarih(x.getRandevuTarih()).radevuDurum(x.isRandevuDurum())
                       .build()).toList();
    }
    public Optional<Randevu> findOptionalByRandevuDurumFalse(){
        return randevuRepository.findOptionalByRandevuDurumFalse();
    }
    public void updateDurum(boolean durum, String email){
         randevuRepository.updateDurum(durum,email);
    }
}
