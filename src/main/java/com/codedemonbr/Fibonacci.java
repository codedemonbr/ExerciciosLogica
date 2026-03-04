package com.codedemonbr;

import java.math.BigInteger;
import java.util.Arrays;

public class Fibonacci {


    public static BigInteger fib(BigInteger n) {
        boolean isOdd = n.and(BigInteger.ONE).equals(BigInteger.ZERO);
        boolean isNegative = n.signum() < 0;
        n = n.abs();
        if (n.compareTo(BigInteger.valueOf(2)) < 0)
            return new BigInteger(String.valueOf(n));
        BigInteger[][] baseMatrix = {
                { BigInteger.ZERO, BigInteger.ONE },
                { BigInteger.ONE, BigInteger.ONE } };
        BigInteger[][] result = powMatrix(baseMatrix, n);
        return isNegative ? (isOdd ? result[0][1].negate() : result[0][1]) : result[0][1];
    }

    private static void PrintMatrix(long[][] matrix){
        System.out.println(Arrays.deepToString(matrix));
    }

//    O(log(n))
    public static BigInteger[][] powMatrix(BigInteger[][]a, BigInteger n){
        BigInteger[][] p = {
                {BigInteger.ONE, BigInteger.ZERO},
                {BigInteger.ZERO, BigInteger.ONE}};
        int limiteMaximo = 2_000_000;
        try{
            int valorInt = n.intValueExact();
            if(valorInt < limiteMaximo){
                while(valorInt > 0){
                    if((valorInt & 1) == 1){
                        p = multiplyMatrix(p, a);
                    }
                    a = multiplyMatrix(a, a);
                    valorInt >>= 1;
                }
            }
        } catch (ArithmeticException e) {
            System.out.println("Erro: valor não cabe em um int (fora da faixa de -2.147.483.648 a 2.147.483.647)");
        }
        return p;
    }




    //O(n)
//    private static long[][] powMatrix(long[][] a, int n) {
//        long[][] p = { { 1, 0 }, { 0, 1 } };
//    int acc = 0;
//        for (int i = 0; i < n; i++) {
//            p = multiplyMatrix(p, a);
//                acc++;
//            System.out.println("iterações " + acc);
//        }
//        return p;
//    }

    private static BigInteger[][] multiplyMatrix(BigInteger[][] firstMatrix, BigInteger[][] secondMatrix) {
        BigInteger[][] res = new BigInteger[2][2];

        res[0][0] = firstMatrix[0][0].multiply(secondMatrix[0][0]).add(firstMatrix[0][1].multiply(secondMatrix[1][0]));
        res[0][1] = firstMatrix[0][0].multiply(secondMatrix[0][1]).add(firstMatrix[0][1].multiply(secondMatrix[1][1]));
        res[1][0] = firstMatrix[1][0].multiply(secondMatrix[0][0]).add(firstMatrix[1][1].multiply(secondMatrix[1][0]));
        res[1][1] = firstMatrix[1][0].multiply(secondMatrix[0][1]).add(firstMatrix[1][1].multiply(secondMatrix[1][1]));

        return res;
    }
}
