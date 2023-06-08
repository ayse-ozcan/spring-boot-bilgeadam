package com.ayseozcan.SBstart.exception;


public class DepartmanNotFoundException extends RuntimeException{

    public DepartmanNotFoundException(String message){
        super(message);
    }
    public DepartmanNotFoundException(String message,Throwable cause){
        super(message, cause);
    }

}
