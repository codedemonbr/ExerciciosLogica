package com.codedemonbr;

import java.math.BigInteger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        System.out.println(Fibonacci.fib(1_000_000));

        for (int i = 0; i > -10; i--) {
            System.out.println(Fibonacci.fib(BigInteger.valueOf(i)));

        }
    }
}