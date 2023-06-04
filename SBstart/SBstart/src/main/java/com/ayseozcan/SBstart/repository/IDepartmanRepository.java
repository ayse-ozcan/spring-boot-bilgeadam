package com.ayseozcan.SBstart.repository;

import com.ayseozcan.SBstart.repository.entity.Departman;
import com.ayseozcan.SBstart.repository.view.VwDepartmanList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDepartmanRepository extends JpaRepository<Departman,Long> {

    /**
     * Spring data JPA belli keyword ler ile sorgulari method isimlerine gore otomatik olusturur.
     * --ornegin: yonetici id sinden yoneticinin bagli bulundugu departman listesini bul.
     * ---Spring keywordler ile sorgu methodu olusturmak
     * 1-find ile basliyoruz
     * 2-By ile devam ediyoruz. (Istisnalar var, bazen arasina keywordler girebilir)
     * 3-Entity icinde var olan bir property adini ekliyoruz.
     * DIKKAT!!! burada yazilacak degisken adi mutlaka buyuk harfle baslar ve degisken yazim sekline gore devam eder.
     * 4-bu method icin ek ozellikler varsa eklenir.
     * 5-methodun talep ettigi deger parametre olarak eklenir.
     * 6-geri donus tipi yazilan methodun basina getirilir.// List<Departman>
     */
    List<Departman> findByYoneticiid(Long yoneticiid);
    List<Departman> findAllByKonum(String konumadi); // select * from tbldepartman where konum = ?

    /**
     * bu kisimda arama yaparken ayni ad ile kayit edilmis kayit varsa ilk buldugu kaydi doner
     */
    Departman findByAd(String ad);
    /**
     * eger gerekli oldugunda aranan bilginin varligini kontrolu saglanacaksa
     * burada gelen bilginin null olmasi durumunda hata alinacagi icin optional kullanilir.
     * Optional kullanirken dikkat!! istenilen bilginin ya hic olmamasi ya da bir tane olmali
     * eger birden fazla kayit donuyorsa hata aliriz.
     */
    Optional<Departman> findOptionalByAd(String ad);
    /**
     * aradigim kelime departman adi icinde var ise bunlarin listesini getirsin.
     * select * from tbldepartman where ad like %?%
     * Eger like kullaniliyorsak ozel karakterleri bizim belirlememiz gerekiyor.
     * NOT -> aradigim kelime disindaki kayitlari getir
     */
    List<Departman> findByAdLike(String searchKey);
    List<Departman> findByAdNotLike(String searchKey);
    /**
     * aradigimiz kelime adin icinde geciyor mu?
     */
    List<Departman> findByAdContaining(String searchKey);
    /**
     * aradigimiz kelime ile baslayan kayitlari listelemek icin
     * muh% -> muh ile baslayan kayitlar
     */
    List<Departman> findByAdStartingWith(String searchKey);
    /**
     * birden fazla kriter uzerinden arama yapmak istiyorsak
     * AND key kullaniriz
     * birden fazla kriter uzerinden herhangi birisini saglayan kayitlar icin -> OR
     */
    List<Departman> findAllByYoneticiidAndKonum(Long yoneticiid, String konum);
    List<Departman> findAllByYoneticiidOrKonum(Long yoneticiid, String konum);
    /**
     * select * from tbldepartman where yoneticiid=? or like konum %kk%
     * StartingWith -> k%
     * Containing -> %k%
     */
    List<Departman> findAllByYoneticiidOrKonumStartingWith(Long yoneticiid, String konum);
    List<Departman> findAllByYoneticiidOrKonumLike(Long yoneticiid, String konum);
    List<Departman> findAllByYoneticiidOrKonumContaining(Long yoneticiid, String konum);
    /**
     * kayitlari belli bir kritere gore siralamak icin -> OrderBy -ASC -DESC
     * select * from tbldepartman
     */
    List<Departman> findAllByOrderByKonum(); //ASC
    List<Departman> findAllByOrderByKonumDesc();
    /**
     * belli bir kritere gore kissitlayip sonrasinda siralama yapmak icin;
     */
    List<Departman> findAllByKonumOrderByKonum(String konum);
    /**
     * satis platformu -> en cok satan urunleri listelemek istiyoruz
     * ve bu urunlerin en cok satilan 5 urunu listele
     * TOP - LIMIT
     * select * from tblurun orderby adet desc limit 5
     */
    List<Departman> findTop3AllByOrderByKonum();
    List<Departman> findTop50ByKonumContaining(String konum);
    /**
     * bir kitapcida en cok satilan kitabi bulmak istiyoruz.
     */
    Departman findTopByOrderByKonum();
    /**
     * durumun aktif oldugu kayitlari getirmek ya da true/false olan
     * alanlara gore listeleme yapmak icin kullanilacak methodlar
     */
    List<Departman> findAllByIsacvtive(Boolean isactive);
    // asagidaki gibi yazilmasi daha dogrudur.
    List<Departman> findAllByIsacvtiveTrue();
    List<Departman> findAllByIsacvtiveFalse();
    /**
     * belli bir string alanda arama yaparken kullanicilarin yazim sekillerine
     * dikkat etmediklerinde yani; ayse, AYSE, aYSE vb. yazimlar olabilir.
     * boyle durumlarda;
     */
    List<Departman> findAllByKonumIgnoreCase(String konum);
    /**
     * DIKKAT!!!
     * ornegin elinizde uygulamanizda en cok urun satin alan kisilerin satis
     * islemlerine ulasmak istiyorsunuz fakat bu bilgilere ulasmak icin once satislari cekmeniz
     * ve ardindan bu kisilerinn listesini ayiklamaniz gerekir, ya da join kullanarakl tum tablolari
     * birlestirip arama yapmaniz gerekir. Iki durum da yuksek islem hacmi tuketecegi icin sorunludur.
     * DOGRU YONTEM:
     * Once kisiler bulunur ve bu kisilerin id bilgisi bir List<Long> icine atilir, bu liste satis
     * tablosunda sorgulanarak sadece bu kisilere ait satislarin listesinin cekilmesi saglanir ve
     * performans iyilesir.
     * select * from tblsatis where musteriid in(1,2,3,4,5)
     */
    List<Departman> findAllByYoneticiidIn(List<Long> yoneticiidList);
    /**
     * gunluk challenge yapilan bir sistemde aktif olan challenge lari listelemek icin
     * bulundugumuz tarihten bitis tarihinin buyuk olmasi durumlari
     * select * from tblchallenge where enddate > ?
     */
    List<Departman> findAllByCreatedatGreaterThan(Long time);
    List<Departman> findAllByCreatedatLessThan(Long time);
    List<Departman> findAllByCreatedatGreaterThanEqual(Long time);
    List<Departman> findAllByCreatedatLessThanEqual(Long time);
    /**
     * eger bellirli bir tarih araligindaki kayitlari istiyorsak
     * updatedat >= start and updatedat <= end
     */
    List<Departman> findAllByUpdatedatBetween(Long start, Long end);
    /**
     * ihtiyac duydugumuz datalar bazen anahtar kelimelerle elde edilemez.
     * Bu durumlarda ozel sorgular yazmak ve sorgulari calistirmak gerekebilir.
     */
    @Query("select d from Departman d where d.ad = ?1")
    // select * from tbldepartman where ad = ?
    Departman senBulDepartmaniAdinaGore(String ad);
    @Query("select d from Departman d where d.yoneticiid = ?1 and d.konum = ?2")
    List<Departman> yoneticiidVeKonumaGoreBul(Long yoneticiid, String konum);
    @Query(value = "select * from tbldepartman where konum like %?1%", nativeQuery = true)
    List<Departman> konumaGoreGetir(String konum);
    @Query("select d from Departman d where d.ad = :departmanadi")
    Departman bulParametreIle(@Param("departmanadi") String ad);

    /**
     * DIKKAT!!!
     */
    @Query("select count(d) > 0 from Departman d where d.konum like %?1% and d.ad ilike %?2%")
    Boolean boyleBirKayitVarMiOla(String konum, String ad);

    /**
     * ONEMLI!!!
     */
    @Query("select new com.ayseozcan.SBstart.repository.view.VwDepartmanList(d.id,d.ad) from Departman d")
    List<VwDepartmanList> findAllVwDepartman();
}
