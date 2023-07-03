package com.ayseozcan.exception;

import lombok.Getter;
@Getter
public class MaratonException extends RuntimeException{
    private final ErrorType errorType;
    public MaratonException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }
    public MaratonException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }
}
