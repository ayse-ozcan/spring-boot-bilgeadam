package com.ayseozcan.di04;

public class Runner {
    public static void main(String[] args) {
        /**
         * System.out.println("hello");
         * - printer type
         * - message
         * --------------------------
         * - Interface PrinterType
         * - Interface Message
         * --------------------------
         * NOT: yazdrima islemi icin 2 bilesen gerekli
         * 1-mesaj, 2-yazdirma turu
         * - IPrinter
         * - IProvider
         */
        IProvider provider = null;
        IPrinter printer = null;
        provider = new MessageProviderDE();
        printer = new ErrorPrinter();

        printer.setProvider(provider);
        printer.print();
    }
}
