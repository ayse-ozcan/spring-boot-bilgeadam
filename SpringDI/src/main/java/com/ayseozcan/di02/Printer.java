package com.ayseozcan.di02;

public class Printer {
    public void print(PrintType printType){
        switch (printType){
            case ERROR -> System.err.println("HELLO");
            case STANDARD -> System.out.println("HELLO");
            default -> System.out.println("HELLO default");
        }
    }
}
