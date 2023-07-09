package com.ayseozcan.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    INTERNAL_SERVER_ERROR(1000,"something has gone wrong on the website's server",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(1001,"the server cannot or will not process the request",HttpStatus.BAD_REQUEST),
    CUSTOMER_ALREADY_EXIST(1002,"this email address is already exist",HttpStatus.BAD_REQUEST),
    CUSTOMER_NOT_FOUND(1002,"please check your info or activate your account",HttpStatus.BAD_REQUEST),
    INVALID_ACTIVATION_CODE(1005,"invalid activation-code",HttpStatus.BAD_REQUEST),
    INVALID_TOKEN(1005,"invalid token",HttpStatus.BAD_REQUEST);
    int code;
    String message;
    HttpStatus httpStatus;
}
