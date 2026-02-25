package com.codedemonbr;

public class RangeExtraction {
    private static String rangeBuilder(int start, int end){
        if(end - start >= 2){
            return (start + "-" + end );
        }else{
            return (start + "," + end );
        }
    }
    public static String rangeExtraction(int[] arr) {
        int openRange = arr[0];
        int endRange = arr[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] - arr[i - 1] == 1){
                endRange = arr[i];
            }else if(arr[i] - arr[i - 1] > 1){
                //montar string
                //abrir novo
                if(openRange == endRange){
                    sb.append(openRange + ",");
                }else{
                    sb.append(rangeBuilder(openRange, endRange) + ",");
                }
                openRange = arr[i];
                endRange = openRange;
            }
            if(i == arr.length - 1){
                //fechar ultimo range
                if(openRange == endRange){
                    sb.append(openRange);
                }else{
                    sb.append(rangeBuilder(openRange, endRange));
                }
            }

        }
        return sb.toString();
    }
}
