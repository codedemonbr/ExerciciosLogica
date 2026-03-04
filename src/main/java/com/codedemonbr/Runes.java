package com.codedemonbr;

import java.util.HashSet;
import java.util.Set;

public class Runes {

    private static boolean hasInvalidLeadingZero(String number){
        if(number.startsWith("-")){
            number = number.substring(1);
        }
        return number.length() > 1 && number.startsWith("0");
    }

    public static int solveExpression( final String expression ) {

        int missingDigit = -1;

        // === BUSCA DO OPERADOR CORRIGIDA (muda só isso!) ===
        // Ignora o sinal negativo inicial e pega o primeiro + / - / * que vier depois
        int posOperator = -1;
        char operador = ' ';   // vamos guardar qual operador foi encontrado
        for (int k = 1; k < expression.length(); k++) {   // começa em 1
            char c = expression.charAt(k);
            if (c == '+' || c == '-' || c == '*') {
                posOperator = k;
                operador = c;
                break;
            }
        }
        int posEquals = -1;
        posEquals = expression.lastIndexOf('=');
        String number0 = expression.substring(0, posOperator);
        String number1 = expression.substring((posOperator + 1), posEquals);
        String result = expression.substring(posEquals + 1);

        Set<Character> used = new HashSet<>();

        for (char c : expression.toCharArray()){
            used.add(c);
        }

        for (int j = 0; j < 10; j++) {
            if(used.contains(Character.forDigit(j, 10))) continue;
            String n0 = number0.replace('?', (char)('0' + j));
            String n1 = number1.replace('?', (char)('0' + j));
            String res = result.replace('?', (char)('0' + j));

            if(n0.isEmpty() || n1.isEmpty() || res.isEmpty()) continue;

            if(hasInvalidLeadingZero(n0) || hasInvalidLeadingZero(n1) || hasInvalidLeadingZero(res)) continue;

            try {
                long a = Long.parseLong(n0);
                long b = Long.parseLong(n1);
                long r = Long.parseLong(res);
                if(operador == '+'){
                    if(a + b == r) return j;
                }
                if(operador == '*'){
                    if(a * b == r) return j;
                }
                if(operador == '-'){
                    if(a - b == r) return j;
                }
            } catch (NumberFormatException e) {
                continue;
            }
        }

        return missingDigit;
    }
}