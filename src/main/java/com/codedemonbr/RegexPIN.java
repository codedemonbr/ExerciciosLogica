package com.codedemonbr;

import java.util.regex.Pattern;

public class RegexPIN {
    public static boolean validatePin(String pin) {
        if(pin == null || pin.isEmpty()) return false;
        if(pin.length() != 6 && pin.length() != 4) return false;

        return Pattern.matches("\\d+", pin);

    }
}
