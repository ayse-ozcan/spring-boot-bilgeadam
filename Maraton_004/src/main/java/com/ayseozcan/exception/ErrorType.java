package com.ayseozcan.exception;

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
    GECERSIZ_RANDEVU_TARIHI(1002,"istenilen tarihe uygun randevu bulunamamamistir",HttpStatus.BAD_REQUEST),
    ID_NOT_FOUND(1004,"aradiginiz id ye ait kayit bulunamadi",HttpStatus.BAD_REQUEST),
    INVALID_TOKEN(1005,"gecersiz token",HttpStatus.BAD_REQUEST);
    int code;
    String message;
    HttpStatus httpStatus;
}
