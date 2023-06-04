package com.ayseozcan.di05;

import com.ayseozcan.di04.IPrinter;
import com.ayseozcan.di04.IProvider;

public class StandardPrinter implements IPrinter {
    private com.ayseozcan.di04.IProvider provider;
    @Override
    public void setProvider(IProvider provider) {
        this.provider = provider;
    }
    @Override
    public void print() {
        System.out.println(provider.getMessage());
    }
}
