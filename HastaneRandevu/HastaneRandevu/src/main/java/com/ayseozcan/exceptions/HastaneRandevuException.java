package com.ayseozcan.exceptions;

import lombok.Getter;
@Getter
public class HastaneRandevuException extends RuntimeException{
    private final ErrorType errorType;
    public HastaneRandevuException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }
    public HastaneRandevuException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }
}
