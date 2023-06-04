package com.ayseozcan.di05;

import java.io.FileInputStream;
import java.util.Properties;

public class FactoryBuilder implements IFactory{
    private IProvider provider;
    private IPrinter printer;
    private static FactoryBuilder instance;
    static {
        if(instance == null){
            instance = new FactoryBuilder();
        }
    }
    public static FactoryBuilder getInstance(){
        return instance;
    }

    private Properties properties;

    {
       properties = new Properties();
       try {
           properties.load(new FileInputStream("C:\\Spring_mali\\SpringDI\\src\\main\\java\\com\\ayseozcan\\di05\\application.properties"));
           String providerClass = properties.getProperty("provider");
           String printerClass = properties.getProperty("printer");
           provider = (IProvider) Class.forName(providerClass).getDeclaredConstructor().newInstance();
           printer = (IPrinter) Class.forName(printerClass).getDeclaredConstructor().newInstance();
       }catch (Exception e){
           System.out.println("beklenmeyen hata: " + e.getMessage());
       }
    }
    @Override
    public IProvider getProvider() {
        return this.provider;
    }
    @Override
    public IPrinter getPrinter() {
        return this.printer;
    }
}
