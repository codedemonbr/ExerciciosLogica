package com.codedemonbr;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        String test = "123*45?=5?088";
//        String test = "19--45=5?";
        String test = "-5?*-1=5?";

        int res = Runes.solveExpression(test);

        System.out.println(res);
    }
}