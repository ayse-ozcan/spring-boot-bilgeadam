package com.ayseozcan.di06;

import com.ayseozcan.di06.IProvider;

public class MyFramework {
    private static MyFramework instance;
    public static MyFramework getInstance(){
        if (instance == null)
            instance = new MyFramework();
        return instance;
    }
    public IPrinter getPrinterInstance(String printerClassName, String providerClassName){
        IPrinter printer = null;
        try {
            IProvider provider = (IProvider) Class.forName(providerClassName).getDeclaredConstructor().newInstance();
            printer = (IPrinter) Class.forName(printerClassName).getDeclaredConstructor().newInstance();
            printer.setProvider(provider);
        }catch (Exception e){
            System.out.println("hata" + e.toString());
        }
        return printer;
    }
}
