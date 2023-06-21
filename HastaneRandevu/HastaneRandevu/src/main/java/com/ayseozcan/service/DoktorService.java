package com.ayseozcan.service;

import com.ayseozcan.dto.request.DoktorSaveRequestDto;
import com.ayseozcan.dto.response.DoktorResponseDto;
import com.ayseozcan.exceptions.ErrorType;
import com.ayseozcan.exceptions.HastaneRandevuException;
import com.ayseozcan.mapper.IDoktorMapper;
import com.ayseozcan.repository.IDoktorRepository;
import com.ayseozcan.repository.entity.Doktor;
import com.ayseozcan.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoktorService extends ServiceManager<Doktor, Long> {
    private final IDoktorRepository doktorRepository;
    private final BransService bransService;

    public DoktorService(IDoktorRepository doktorRepository,BransService bransService) {
        super(doktorRepository);
        this.doktorRepository = doktorRepository;
        this.bransService = bransService;
    }

    public Doktor save(DoktorSaveRequestDto dto) {

        /**
         * TODO: odev++
         * 1-doktorlarin ozel olan bilgileri kontrol edilerek tekrar eden kayitlar onlenir.
         * 2-bransid benzesiz ve tutarli oldugu icin kontrol edilebilir.Bransid yok ise kayit islemi
         * sirasinda hata firlatilabilir.
         */
        Doktor doktor = IDoktorMapper.INSTANCE.fromSaveDto(dto);
        Optional<Doktor> telefon = doktorRepository.findOptionalByTelefon(dto.getTelefon());
        Optional<Doktor> bransid = doktorRepository.findOptionalByBransid(dto.getBransid());
        if (telefon.isPresent()) {
            throw new HastaneRandevuException(ErrorType.DOKTOR_TELEFON_ALREADY_EXIST);
        } else if (bransid == null) {
            throw new HastaneRandevuException(ErrorType.GECERSIZ_BRANSID);
        }
        return doktorRepository.save(doktor);
    }

    public List<Doktor> findByAd(String ad) {
        return doktorRepository.findAllByAdContaining(ad);
    }

    //TODO: Bransad
    public List<DoktorResponseDto> findAllResponse() {
        return doktorRepository.findAll().stream()
                .map(x -> DoktorResponseDto.builder()
                        .id(x.getId())
                        .ad(x.getAd())
                        .bransid(x.getBransid())
                        .bransad(bransService.findById(x.getBransid()).get().getAd())
                        .build()).toList();

    }
}
