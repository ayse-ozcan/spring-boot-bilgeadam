package com.ayseozcan.di03;

public class A {
    private String message = "Hello";

    /**
     * eger yazilan metod deprecated olursa;
     * bu metodu kullanan siniflar da bu durumdan etkilenir
     * Bu yuzden kod yazarken siniflar arasi ya da sinif ici bagimliligi azaltmak gerekiyor.
     */
    @Deprecated
    public String getMessage(){
        return message;
    }
    public String getStandardMessage(){
        return "Standard" + message;
    }
    public String getErrorMessage(){
        return "Error" + message;
    }
}
