package com.ayseozcan.di01;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("cikti turu: .... [E/S]");
        if (scanner.nextLine().equals("E")){
            System.err.println("merhaba arkadaslar");
        }else{
            System.out.println("merhaba arkadaslar");
        }
    }
}
