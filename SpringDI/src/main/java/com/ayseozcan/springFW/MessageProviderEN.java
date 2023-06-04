package com.ayseozcan.springFW;

public class MessageProviderEN implements IProvider {
    @Override
    public String getMessage() {
        return "I'm giving a message in Turkish";
    }
}
