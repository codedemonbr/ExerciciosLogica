package com.codedemonbr;

import java.util.stream.IntStream;

public class Kata {

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