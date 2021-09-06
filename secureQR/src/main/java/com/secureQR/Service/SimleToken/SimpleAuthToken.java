package com.secureQR.Service.SimleToken;

public class SimpleAuthToken {
    private static final String OUR_TOKEN = "SOTREE17_SERVER_REQUEST";

    public static boolean isOurToken(String input){
        return OUR_TOKEN.equals(input);
    }
}
