package com.codedemonbr;

public class Finonacci {
    public static long fibo(int n) {
        if (n < 2)
            return n;
        long[][] baseMatrix = { { 0, 1 }, { 1, 1 } };
        long[][] result = powMatrix(baseMatrix, n);
        return result[0][1];
    }

    private static long[][] powMatrix(long[][] a, int n) {
        long[][] p = { { 1, 0 }, { 0, 1 } };
        for (int i = 0; i < n; i++) {
            p = multiplyMatrix(p, a);
        }
        return p;
    }

    private static long[][] multiplyMatrix(long[][] a, long[][] b) {
        return new long[][] { { a[0][0] * b[0][0] + a[0][1] * b[1][0], a[0][0] * b[0][1] + a[0][1] * b[1][1] },
                { a[1][0] * b[0][0] + a[1][1] * b[1][0], a[1][0] * b[0][1] + a[1][1] * b[1][1] } };
    }
}
