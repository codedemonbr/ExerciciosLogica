package com.codedemonbr;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 1005; i++) {
            System.out.println("Fibo >> i = " + i);
            System.out.println(Finonacci.fibo(i));
        }
    }
}