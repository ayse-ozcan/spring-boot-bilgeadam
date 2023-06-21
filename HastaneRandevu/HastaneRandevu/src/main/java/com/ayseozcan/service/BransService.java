package com.ayseozcan.service;

import com.ayseozcan.dto.request.BransSaveRequestDto;
import com.ayseozcan.exceptions.ErrorType;
import com.ayseozcan.exceptions.HastaneRandevuException;
import com.ayseozcan.repository.IBransRepository;
import com.ayseozcan.repository.entity.Brans;
import com.ayseozcan.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BransService extends ServiceManager<Brans, Long> {
    private final IBransRepository bransRepository;

    public BransService(IBransRepository bransRepository) {
        super(bransRepository);
        this.bransRepository = bransRepository;
    }

    public Brans save(BransSaveRequestDto dto) {
        /**
         * dikkat!! eger ayni isimde bir brans varsa kayit once kontrol edilmeli
         * sonra kayit yapilmalidir.
         */
        String bransAdi = dto.getAd().trim();
        /**
         * 1. Yöntem
         *    Optional<Brans> optionalBrans = repository.findOptionalByAdIgnoreCase(bransAdi);
         *           if(optionalBrans.isEmpty())
         *           // Burada kayit yapilmali
         *            ;
         *            else
         *            // Burada hata dondurulmeli
         *            ;
         * 2. Yöntem
         *      repository.findOptionalByAdIgnoreCase(bransAdi)
         *            .ifPresentOrElse(
         *                brans -> {
         *                throw new RuntimeException("Bu isimde bir brans zaten var");
         *                },
         *                () -> {
         *                   Brans brans = Brans.builder().ad(bransAdi).build();
         *                   repository.save(brans);
         *                  }
         *              );
         */
        Optional<Brans> optionalBrans = bransRepository.findOptionalByAdIgnoreCase(bransAdi);
        if (optionalBrans.isPresent())//eger boyle bir kayit var ise burada akisi bitir.
            throw new HastaneRandevuException(ErrorType.BRANS_ZATEN_KAYITLI);
        //Brans brans = Brans.builder().ad(bransAdi).build();
        //return bransRepository.save(brans);
        return bransRepository.save(Brans.builder().ad(bransAdi).build());
    }
}
