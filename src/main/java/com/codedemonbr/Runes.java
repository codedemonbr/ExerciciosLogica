package com.codedemonbr;

public class Runes {

    public static int solveExpression( final String expression ) {

        int missingDigit = -1;
        char[] operators = {'*', '+', '-' };
        int posOperator = -1;
        int i;
        for ( i = 0; i < operators.length; i++) {
            posOperator = expression.indexOf(operators[i]);
            if(posOperator != -1 && posOperator != 0){
                break;
            }
        }
        int posEquals = -1;
        posEquals = expression.lastIndexOf('=');

        for (int j = 1; j < 10; j++) {
            String number0 = expression.substring(0, posOperator).replaceAll("\\?", (j+""));
            String number1 = expression.substring((posOperator + 1), posEquals).replaceAll("\\?", (j+""));
            String result = expression.substring((posEquals + 1)).replaceAll("\\?", (j+""));
            try {
                Integer a = Integer.valueOf(number0);
                Integer b = Integer.valueOf(number1);
                Integer res = Integer.valueOf(result);
                if(operators[i] == '+'){
                    //soma
                    if(a + b == res){
                        return j;
                    }
                }
                if(operators[i] == '*'){
                    //multiplica
                    if(a * b == res){
                        return j;
                    }
                }
                if(operators[i] == '-'){
                    //subtrai
                    if(a - b == res){
                        return j;
                    }
                }
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }


        }





        return missingDigit;
    }
}
