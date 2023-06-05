package com.ayseozcan.SBstart.controller;

import com.ayseozcan.SBstart.repository.entity.Personel;
import com.ayseozcan.SBstart.service.PersonelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import static com.ayseozcan.SBstart.constants.RestApiList.*;

/**
 * 1-MVC yapisinda Controller katmani @Controller anatasyonu ile isaretlenir
 * 2-RestAPI yapisinda Controller katmani @RestController anatasyonu ile isaretlenir
 */
@RestController
/**
 * path kisminda gelen isteklerin handle edildigi kisimdir. Burada bir URL adresinden gelen isteklerin
 * uygulamamizda nerede yakalanmasi gerektigi bilgisi iletilir.
 * Bir uygulamanin Root dizini "/" ile ifade edilir.
 * ornegin uygulamaniz 9090 portunda calisiyor olsun;
 * Local de calisiyorsaniz: http://localhost:9090/
 * bir internet adresiniz varsa: http://www.ayseozcan.com/
 * ---------
 * http://localhost:9090/personel
 */
@RequestMapping(PERSONEL)
@RequiredArgsConstructor
public class PersonelController {
    private final PersonelService personelService;

    /**
     *burasi son ullanicinin programimiz ile iletisime gectigi kisimdir.
     * farkli sekillerde iletisim kurabilir.
     * GET,POST,PUT,DELETE vs.
     * Kullanicinin Request gondermesi.
     * ---> isteklerin Degerlendirilmesi
     * GET --> genellikle get istekleri bir sayfanin acilmasi ya da belirli bir datanin talep edilmesi
     * durumlarinda gecerlidir.
     * http://localhost:9090/personel/save
     * eger istek sizden parametre talep ediyorsa bunlarin eklenmesi gerekir.
     * http://localhost:9090/personel/save?ad=Ayse&adres=Ankara&yas=27&telefon=5555
     * ? parametre girilecegini belirtir.
     * key = value seklinde parametreler girilir.
     * & ile bir sonraki parametreye gecilir.
     * DIKKAT!!! girdiginiz anahtar kelimeler methodun parametre isimleri ile ayni olmalidir.
     */
    @GetMapping(SAVE)
    public void savePersonel(String ad, String adres, int yas, String telefon){
        Personel personel = Personel.builder()
                .ad(ad)
                .adres(adres)
                .yas(yas)
                .telefon(telefon)
                .build();
        personelService.save(personel);
    }

    /**
     *POST --> get ve post ya da digerleri birbirlerinin yerine kullanilabilir.
     * Ancak onemli olan konu sudur;
     * GET isteklerinde parametreler URL uzerinden gonderilir.
     * ornegin bitr uygulamaya giris yapmak istiyoruz.Kullanici adi ve sifre girmemiz gerekiyor.
     * Bu bilgileri GET ile gonderirsek tum bilgilerimiz baslik icersinde iletilir. Ornegin;
     * http://localhost:9090/login?username=ayse&password=5555
     * bu islem oldukca tehlikelidir ve bilgileriniz calinir.
     * POST isleminde ise isler daha karmasiktir ve bilgileriniz korunur.
     * GET ile bilgiler header da gider.
     * POST ile bilgiler body de.
     */
    @PostMapping(SAVE)
    public void savePersonel(String ad, String adres, int yas, String telefon,int type){
        Personel personel = Personel.builder()
                .ad(ad)
                .adres(adres)
                .yas(yas)
                .telefon(telefon)
                .type(type)
                .build();
        personelService.save(personel);
    }
    @GetMapping(FINDALL)
    public ResponseEntity<List<Personel>> findAll(){
        return ResponseEntity.ok(personelService.findAll());
    }
}
