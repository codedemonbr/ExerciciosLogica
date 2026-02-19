package com.codedemonbr;

import java.util.ArrayList;
import java.util.List;

public class PrimeDecomp {
    public static String factors(int n) {
        if (n <= 1) return "";

        StringBuilder sb = new StringBuilder();

        // Fator 2 (único par)
        int count = 0;
        while (n % 2 == 0) {
            count++;
            n /= 2;
        }
        if (count > 0) append(sb, 2, count);

        // Só números ímpares até sqrt(n)
        for (int i = 3; i * i <= n; i += 2) {
            count = 0;
            while (n % i == 0) {
                count++;
                n /= i;
            }
            if (count > 0) append(sb, i, count);
        }

        // Se sobrou um primo grande
        if (n > 1) append(sb, n, 1);

        return sb.toString();
    }

    private static void append(StringBuilder sb, int p, int e) {
        sb.append('(').append(p);
        if (e > 1) sb.append("**").append(e);
        sb.append(')');
    }


}
