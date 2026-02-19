package com.codedemonbr;

import java.util.Map;

public class RomanNumerals {

    private static Map<String, Integer> dePara = Map.of(
            "I", 1,
            "V", 5,
            "X", 10,
            "L", 50,
            "C", 100,
            "D", 500,
            "M", 1000

    );

    private static String getR(int n, String r){
        String res = "";
        for (int i = 0; i < n; i++) {
            res = res.concat(r);
        }
        return res;
    }
    private static String toRomansGeneric(int n, char middle, char end, String romanSmall){
        if(n >= 1 && n <= 3){
            return getR(n, romanSmall);
        } else if (n > 3 && n < 9) {
            if(n > 4){
                return middle + getR(n % 5, romanSmall);
            }
            return getR(1, romanSmall) + middle;
        }else if(n == 9){
            return getR(1, romanSmall) + end;
        }
        return "";
    }
    private static String unitsToRomans(int n){
        return toRomansGeneric(n, 'V', 'X', "I");
    }
    private static String tensToRomans(int n){
        return toRomansGeneric(n, 'L', 'C', "X");
    }
    private static String hundredsToRomans(int n){
        return toRomansGeneric(n, 'D', 'M', "C");
    }
    private static String thousandsToRoman(int n){
        return getR(n, "M");
    }
    private static String decomporNum(int n){
        int thousands =  n / 1000;
        int hundreds = (n % 1000) / 100;
        int tens = (n % 100) / 10;
        int units = n % 10;
        return thousandsToRoman(thousands) + hundredsToRomans(hundreds) + tensToRomans(tens) + unitsToRomans(units);
    }

    public static String toRoman(int n) {
        return decomporNum(n);
    }

    public static int fromRoman(String romanNumeral) {
        int res = 0;
        for (int i = 0; i < romanNumeral.length(); i++) {
            int actualValue = dePara.get(String.valueOf(romanNumeral.charAt(i)));
            int nextValue = -1;
            if((i + 1) < romanNumeral.length()){
                nextValue = dePara.get(String.valueOf(romanNumeral.charAt(i + 1)));
            }
            if((nextValue > 0) && (nextValue > actualValue)){
                res = res + nextValue - actualValue;
                i++;
            }else{
                res += dePara.get(String.valueOf(romanNumeral.charAt(i)));
            }
        }
        return  res;
    }
}