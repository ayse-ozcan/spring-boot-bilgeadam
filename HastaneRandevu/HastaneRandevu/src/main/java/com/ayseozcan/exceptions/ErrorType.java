package com.ayseozcan.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    INTERNAL_SERVER_ERROR(1000,"sunucuda bilinmeyen bir hata olustu",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(1001,"istek formati hatali",HttpStatus.BAD_REQUEST),
    REGISTER_KULLANICIADI_KAYITLI(1002,"kullanici adi kayitli",HttpStatus.BAD_REQUEST),
    NAME_IS_NULL(1003,"name alani bos birakilamaz",HttpStatus.BAD_REQUEST),
    DOKTOR_BULUNAMADI(3001,"doktor bulunamadi",HttpStatus.BAD_REQUEST),
    DOKTOR_TELEFON_ALREADY_EXIST(3002,"girdiginiz telefona sahip bir doktor zaten mevcut",HttpStatus.BAD_REQUEST),
    GECERSIZ_BRANSID(3003,"gecersiz brans id(null ya da boyle bir brans tipi yok)",HttpStatus.BAD_REQUEST),
    HASTA_BULUNAMADI(4001,"hasta bulunamadi",HttpStatus.BAD_REQUEST),
    ID_NOT_FOUND(1004,"aradiginiz id ye ait kayit bulunamadi",HttpStatus.BAD_REQUEST),
    BRANS_ZATEN_KAYITLI(2001,"Bu brans zaten kayitli",HttpStatus.BAD_REQUEST),
    INVALID_TOKEN(1005,"gecersiz token",HttpStatus.BAD_REQUEST);
    int code;
    String message;
    HttpStatus httpStatus;
}
