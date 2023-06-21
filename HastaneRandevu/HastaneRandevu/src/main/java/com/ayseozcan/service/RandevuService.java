package com.ayseozcan.service;

import com.ayseozcan.dto.request.RandevuSaveRequestDto;
import com.ayseozcan.exceptions.ErrorType;
import com.ayseozcan.exceptions.HastaneRandevuException;
import com.ayseozcan.repository.IRandevuRepository;
import com.ayseozcan.repository.entity.Doktor;
import com.ayseozcan.repository.entity.Randevu;
import com.ayseozcan.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class RandevuService extends ServiceManager<Randevu, Long> {
    private final IRandevuRepository randevuRepository;
    /**
     * TODO: Bir servisin icinde baska bir sevisi kullanmak dogru mudur?
     * çagirim yapacaginiz servis icinde ozellestirilmis methodlar ve islemler olabilir.
     * bu ozel methodlar datayi manipule ederken farkli islemler yapabilir. islemleri
     * soyutlama nedeniyle ilgili serviste yapilan islemleri bilemeyecegimiz icin
     * direkt Repository e erismek sakincali olacaktir.
     * <p>
     * TODO: Ancak servisler birbirlerini cagirarak loop yaratmamalidir.
     */
    // private final IDoktorRepository doktorRepository;
    private final DoktorService doktorService;
    private final HastaService hastaService;

    public RandevuService(IRandevuRepository randevuRepository,
                          DoktorService doktorService,
                          HastaService hastaService) {
        super(randevuRepository);
        this.randevuRepository = randevuRepository;
        this.doktorService = doktorService;
        this.hastaService = hastaService;
    }

    public Randevu save(RandevuSaveRequestDto dto) {
        /**
         * TODO: Doktor id kontrol edelim yok ise hata dondurelim
         * TODO: Hasta id kontrol edelim yok ise hata dondurelim
         * TODO: Tarih kontrol edelim mevcut zamandan once ise hata dondurelim
         */
        if (doktorService.findById(dto.getDoktorid()).isEmpty()) // dto icinden gelen doktor id doktor tablosunda yok ise, hata firlat
            throw new HastaneRandevuException(ErrorType.DOKTOR_BULUNAMADI);
        else if (hastaService.findById(dto.getHastaid()).isEmpty())
            throw new HastaneRandevuException(ErrorType.HASTA_BULUNAMADI);

        Randevu randevu = Randevu.builder()
                .hastaid(dto.getHastaid())
                .doktorid(dto.getDoktorid())
                .randevuTarih(dto.convertDate())
                .build();

        /**
         * TODO: odev Randevu tarihleri Long olarak geldigi icin kontrol edilmesi kolay olacaktir.
         * eger tarihler soyle iletilseydi nasil yapilabilirdi?
         * Yil,Ay,Gun,Saat,Dakika
         */

        return randevuRepository.save(randevu);
    }

    public List<Randevu> mostFrequent(){
        return randevuRepository.findMostFrequent();
    }

}
