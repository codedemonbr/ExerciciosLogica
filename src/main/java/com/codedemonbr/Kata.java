package com.codedemonbr;

import java.util.stream.IntStream;

public class Kata {
    public static String add(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int digitA = 0;
            int digitB = 0;
            if (i >= 0) {
                digitA = (a.charAt(i) - '0');
                i--;
            }
            if (j >= 0) {
                digitB = (b.charAt(j) - '0');
                j--;
            }
            int soma = digitB + digitA + carry;
            carry = soma / 10;
            sb.append(soma % 10);
        }
        return sb.reverse().toString().replaceFirst("^0+(?!$)", "");
    }

    public static String createPhoneNumber(int[] numbers) {
        // Your code here!
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if(i == 0){
                sb.append("(");
            }
            if(i == 3){
                sb.append(") ");
            }
            if(i == 6){
                sb.append("-");
            }
            sb.append(numbers[i]);
        }
        return sb.toString();
    }

    private static int sumLeft(int[] arr, int pos){
//        int acc = 0;
//        for(int i = pos - 1; i >= 0; i--){
//            acc += arr[i];
//        }
//        return acc;
        return IntStream.iterate(pos - 1,  // 1. Valor inicial: pos - 1
                        i -> i >= 0,       // 2. Condição de continuação: i >= 0
                        i -> i - 1)        // 3. Função de iteração: decrementa 1
                .map(i -> arr[i])  // 4. Mapeia índice para valor
                .sum();
    }


    private static int sumRight(int[] arr, int pos){
        int acc = 0;
        for(int i = pos + 1; i < arr.length; i++){
            acc += arr[i];
        }
        return acc;
    }
    public static int findEvenIndex(int[] arr) {
        // your code
        int pos = -1;
        for(int i = 1; i < arr.length; i++){
            if(sumRight(arr, i) == sumLeft(arr, i)){
                pos = i;
            }
        }
        return pos;
    }
}