package com.codedemonbr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixTest {

    @Test
    public void testDeterminant1x1() {
        int[][] matrix = {{1}};
        int expected = 1;
        String message = "Determinant of a 1 x 1 matrix yields the value of the one element";
        assertEquals(expected, Matrix.determinant(matrix), message);
    }

    @Test
    public void testDeterminant2x2() {
        int[][] matrix = {{1, 3}, {2, 5}};
        int expected = -1; // 1*5 - 3*2 = -1
        String message = "Should return 1 * 5 - 3 * 2 == -1";
        assertEquals(expected, Matrix.determinant(matrix), message);
    }

    @Test
    public void testDeterminant3x3() {
        int[][] matrix = {{2, 5, 3}, {1, -2, -1}, {1, 3, 4}};
        int expected = -20;
        String message = "Determinant of the given 3x3 matrix should be -20";
        assertEquals(expected, Matrix.determinant(matrix), message);
    }

    @Test
    @DisplayName("Matrizes 5x5")
    void test5x5() {
        // Teste simples com identidade
        int[][] identidade5 = new int[5][5];
        for (int i = 0; i < 5; i++) identidade5[i][i] = 1;
        assertEquals(1, Matrix.determinant(identidade5), "Identidade 5x5");

        // Matriz triangular superior
        int[][] triangular = {
                {2, 1, 1, 1, 1},
                {0, 3, 1, 1, 1},
                {0, 0, 5, 1, 1},
                {0, 0, 0, 7, 1},
                {0, 0, 0, 0, 11}
        };
        assertEquals(2*3*5*7*11, Matrix.determinant(triangular), "Triangular 5x5");
    }

    @Test
    @DisplayName("Casos especiais")
    void testCasosEspeciais() {
        assertAll("Casos especiais",
                () -> assertEquals(0, Matrix.determinant(new int[][]{{0}}), "Matriz 1x1 com zero"),
                () -> assertEquals(0, Matrix.determinant(new int[][]{{0, 0}, {0, 0}}), "Matriz 2x2 nula"),
                () -> assertEquals(0, Matrix.determinant(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}}), "Matriz 3x3 conhecida por ter det 0"),
                () -> assertEquals(-2, Matrix.determinant(new int[][]{
                        {0, 1},
                        {2, 3}}), "Matriz 2x2 com zero no canto")
        );
    }

    @Test
    @DisplayName("Matrizes 4x4")
    void test4x4() {
        assertAll("4x4",
                // Identidade
                () -> assertEquals(1, Matrix.determinant(new int[][]{
                        {1, 0, 0, 0},
                        {0, 1, 0, 0},
                        {0, 0, 1, 0},
                        {0, 0, 0, 1}}), "Identidade 4x4"),

                // Matriz diagonal
                () -> assertEquals(2 * 3 * 4 * 5, Matrix.determinant(new int[][]{
                        {2, 0, 0, 0},
                        {0, 3, 0, 0},
                        {0, 0, 4, 0},
                        {0, 0, 0, 5}}), "Diagonal 4x4"),

                // Matriz que exige expansão completa
                () -> assertEquals(0, Matrix.determinant(new int[][]{
                        {1, 2, 3, 4},
                        {2, 4, 6, 8},
                        {3, 5, 7, 9},
                        {0, 1, 2, 3}}), "Primeiras duas linhas proporcionais"),

                // Matriz com muitos zeros (facilita verificar se sinais estão corretos)
                () -> assertEquals(24, Matrix.determinant(new int[][]{
                        {1, 0, 0, 0},
                        {0, 2, 0, 0},
                        {0, 0, 3, 0},
                        {0, 0, 0, 4}}), "Produto da diagonal")
        );
    }

    @Test
    @DisplayName("Matrizes 3x3")
    void test3x3() {
        assertAll("3x3",
                // Exemplo do kata
                () -> assertEquals(-20, Matrix.determinant(new int[][]{
                        {2, 5, 3},
                        {1, -2, -1},
                        {1, 3, 4}}), "Exemplo do kata"),

                // Matriz identidade
                () -> assertEquals(1, Matrix.determinant(new int[][]{
                        {1, 0, 0},
                        {0, 1, 0},
                        {0, 0, 1}}), "Identidade 3x3"),

                // Matriz diagonal
                () -> assertEquals(2 * 3 * 4, Matrix.determinant(new int[][]{
                        {2, 0, 0},
                        {0, 3, 0},
                        {0, 0, 4}}), "Matriz diagonal"),

                // Matriz singular (determinante zero)
                () -> assertEquals(0, Matrix.determinant(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}}), "Matriz com linhas LD (a terceira é soma das duas primeiras?)"),

                // Matriz triangular superior
                () -> assertEquals(1 * 5 * 9, Matrix.determinant(new int[][]{
                        {1, 2, 3},
                        {0, 5, 6},
                        {0, 0, 9}}), "Triangular superior"),

                // Matriz com números negativos
                () -> assertEquals(-1 * 1 * 1, Matrix.determinant(new int[][]{
                        {-1, 0, 0},
                        {0, 1, 0},
                        {0, 0, 1}}), "Sinal negativo na diagonal")
        );
    }

    @Test
    @DisplayName("Matrizes 2x2")
    void test2x2() {
        assertAll("2x2",
                () -> assertEquals(1*4 - 2*3, Matrix.determinant(new int[][]{{1, 2}, {3, 4}}), "Matriz comum"),
                () -> assertEquals(0, Matrix.determinant(new int[][]{{2, 4}, {1, 2}}), "Linhas proporcionais (determinante zero)"),
                () -> assertEquals(0, Matrix.determinant(new int[][]{{0, 0}, {0, 0}}), "Matriz nula"),
                () -> assertEquals(6, Matrix.determinant(new int[][]{{2, 0}, {0, 3}}), "Matriz diagonal"),
                () -> assertEquals(-1, Matrix.determinant(new int[][]{{1, 3}, {2, 5}}), "Exemplo do kata"),
                () -> assertEquals(10, Matrix.determinant(new int[][]{{5, 0}, {0, 2}}), "Produto da diagonal")
        );
    }

    @Test
    @DisplayName("Matrizes 1x1")
    void test1x1() {
        assertAll("1x1",
                () -> assertEquals(5, Matrix.determinant(new int[][]{{5}}), "Único elemento positivo"),
                () -> assertEquals(-3, Matrix.determinant(new int[][]{{-3}}), "Único elemento negativo"),
                () -> assertEquals(0, Matrix.determinant(new int[][]{{0}}), "Único elemento zero")
        );
    }
}