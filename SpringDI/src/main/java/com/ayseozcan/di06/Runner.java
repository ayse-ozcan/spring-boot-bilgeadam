package com.ayseozcan.di06;

public class Runner {
    public static void main(String[] args) {
        IPrinter printer = MyFramework.getInstance().getPrinterInstance(
                "com.ayseozcan.di06.ErrorPrinter",
                "com.ayseozcan.di06.MessageProviderTR"
        );
        printer.print();
    }
}
