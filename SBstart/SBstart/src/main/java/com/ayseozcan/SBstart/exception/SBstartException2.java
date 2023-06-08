package com.ayseozcan.SBstart.exception;

import lombok.Getter;

/**
 * bu kisimda uygulamaniz icinde olusabilecek tum hatalari kapsayan bir kapsayiciya
 * ihtiyaciniz var. yani hata tiplerinin listesini iceren bir Enum sinifi olusturabilirsiniz.
 */
@Getter
public class SBstartException2 extends RuntimeException{
    private final ErrorType errorType;
    public SBstartException2(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }
    public SBstartException2(ErrorType errorType,String message){
        super(message);
        this.errorType = errorType;
    }
}
