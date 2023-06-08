package com.ayseozcan.SBstart.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    INTERNAL_SERVER_ERROR(1000,"sunucuda bilinmeyen bir hata olustu",HttpStatus.INTERNAL_SERVER_ERROR),
    NAME_IS_NULL(1001,"name alani bos birakilamaz",HttpStatus.BAD_REQUEST),
    ID_NOT_FOUND(1002,"aradiginiz id ye ait kayit bulunamadi",HttpStatus.BAD_REQUEST),
    INVALID_TOKEN(1003,"gecersiz token",HttpStatus.BAD_REQUEST);
    int code;
    String message;
    HttpStatus httpStatus;
}
