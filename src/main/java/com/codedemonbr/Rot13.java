package com.codedemonbr;

public class Rot13 {
    private static char shiftChar(char ch){
        if((ch >= 'n' && ch <= 'z') || (ch >= 'N' && ch <= 'Z')){
            return (char) (ch - 13);
        }else if((ch >= 'A' && ch <= 'M') || (ch >= 'a' && ch <= 'm')){
            return (char) (ch + 13);
        }
        return ch;
    }

    public static String rot13(String str) {
        char[] arr = str.toCharArray();
        for(int i = 0; i < arr.length; i++){
            arr[i] = shiftChar(arr[i]);
        }
        return String.valueOf(arr);
    }
}
