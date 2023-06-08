package com.ayseozcan.SBstart.controller;

import com.ayseozcan.SBstart.dto.request.SavePersonelRequestDto;
import com.ayseozcan.SBstart.dto.response.FindAllVwUserResponseDto;
import com.ayseozcan.SBstart.mapper.IPersonelMapper;
import com.ayseozcan.SBstart.repository.entity.Personel;
import com.ayseozcan.SBstart.service.PersonelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
     * burasi son ullanicinin programimiz ile iletisime gectigi kisimdir.
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
    public void savePersonel(String ad, String adres, Integer yas, String telefon) {
        Personel personel = Personel.builder()
                .ad(ad)
                .adres(adres)
                .yas(yas)
                .telefon(telefon)
                .build();
        personelService.save(personel);
    }

    /**
     * POST --> get ve post ya da digerleri birbirlerinin yerine kullanilabilir.
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
    public void savePersonel(String ad, String adres, Integer yas, String telefon, Integer type) {
        Personel personel = Personel.builder()
                .ad(ad)
                .adres(adres)
                .yas(yas)
                .telefon(telefon)
                .type(type)
                .build();
        personelService.save(personel);
    }

    /**
     * DIKKAT!!
     * Eger DTO icinde validasyon yapiyorsaniz mutlaka @Valid anatayonunu kullanin.
     * Bu anatasyon olmaz ise validasyon kontrolu saglanamaz. DTO icin onune @Valid
     * anatasyonu eklenmelidir.
     */

    @PostMapping(SAVEDTO)
    public ResponseEntity<Boolean> savePersonelDto(@RequestBody @Valid SavePersonelRequestDto dto) {
        Personel personel = Personel.builder()
                .ad(dto.getAd())
                .adres(dto.getAdres())
                .telefon(dto.getTelefon())
                .acildurumkisisi(dto.getAcildurumkisisi())
                .acildurumtelefon(dto.getAcildurumtelefon())
                .build();
        personelService.save(personel);
        return ResponseEntity.ok(true);
    }

    @PostMapping(SAVEDTOMAPPER)
    public ResponseEntity<Boolean> savePersonelMapperDto(@RequestBody SavePersonelRequestDto dto) {
        Personel personel = IPersonelMapper.INSTANCE.fromDtoToPersonel(dto);
        personelService.save(personel);
        return ResponseEntity.ok(true);
    }

    /**
     * DIKKAT!!
     * CONTROLLER KATMANI --> kullanici ile iletisime gecerek gerekli bilgilerin dogru bir sekilde service
     * katmanina iletilmesinden sorumludur.
     * bu nedenle; bu katmanda donusum, nesne yaratma, farkli servisler ile birlestirilerek islem
     * yapma gibi islemlerden olabildiginde kacinmak gerekir.
     */
    @PostMapping(SAVEDTOMAPPER2)
    public ResponseEntity<Boolean> savePersonelMapperDto2(@RequestBody @Valid  SavePersonelRequestDto dto) {
        /**
         * kullanicinin yetkinligi kontrol edilebilir.
         * Sisteme giris yapip yapamayacagi kontrol edilebilir.
         * Gecerli bir oturumu olup olmadigi kontrol edilebilir.
         */
        return ResponseEntity.ok(personelService.saveFromDto(dto));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<Personel>> findAll() {
        return ResponseEntity.ok(personelService.findAll());
    }

    /**
     * client ve server arasindaki iletisimede performansi oncelemek istiyorsaniz
     * ve ayrica maliyetlerinin artmamasinin istiyorsaniz iki bilesen arasindaki veri transferini
     * minimuma indirmek icin DTO(Data Transfer Object) kullanmalisiniz.
     */
    @GetMapping(FINDALLVWUSER)
    public ResponseEntity<?> getAllVwPersonel() {
        List<Personel> personelList = personelService.findAll();
        List<FindAllVwUserResponseDto> result = new ArrayList<>();
        personelList.forEach(p -> {
            FindAllVwUserResponseDto dto = FindAllVwUserResponseDto.builder()
                    .id(p.getId())
                    .photo(p.getPhoto())
                    .ad(p.getAd())
                    .build();
            result.add(dto);
        });
        return ResponseEntity.ok(result);
    }

    @PostMapping(FINDALLVWUSERMAPPER)
    public ResponseEntity<?> getAllVwPersonelMapper() {
        List<Personel> personelList = personelService.findAll();
        List<FindAllVwUserResponseDto> result = new ArrayList<>();
        personelList.forEach(p -> {
            //  FindAllVwUserResponseDto dto = IPersonelMapper.INSTANCE.fromPersonelToDto(p);
            // result.add(dto);
            result.add(IPersonelMapper.INSTANCE.fromPersonelToDto(p));
        });
        return ResponseEntity.ok(result);
    }


    @GetMapping("/getUpperCaseName")
    public ResponseEntity<String> getUpperCaseName(String ad) {
        String upperCaseName = ad.toUpperCase();
        return ResponseEntity.ok(upperCaseName);
    }

    @PostMapping("/postUpperCaseName")
    public ResponseEntity<String> postUpperCaseName(String ad) {
        String upperCaseName = ad.toUpperCase();
        return ResponseEntity.ok(upperCaseName);
    }

    @PutMapping("/putUpperCaseName")
    public ResponseEntity<String> putUpperCaseName(String ad) {
        String upperCaseName = ad.toUpperCase();
        return ResponseEntity.ok(upperCaseName);
    }

    @DeleteMapping("/postUpperCaseName")
    public ResponseEntity<String> deleteUpperCaseName(String ad) {
        String upperCaseName = ad.toUpperCase();
        return ResponseEntity.ok(upperCaseName);
    }

    @PatchMapping("/postUpperCaseName")
    public ResponseEntity<String> patchUpperCaseName(String ad) {
        String upperCaseName = ad.toUpperCase();
        return ResponseEntity.ok(upperCaseName);
    }

}
