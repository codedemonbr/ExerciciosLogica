package com.codedemonbr;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSubarraySumTest {

    @Test
    @DisplayName("Deve retornar a soma máxima para o exemplo fornecido")
    void testExampleArray() {
        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int expected = 6; // Soma de [4, -1, 2, 1]
        assertEquals(expected, MaxSubarraySum.sequence(input));
    }

    @Test
    @DisplayName("Deve retornar 0 para array vazio")
    void testEmptyArray() {
        int[] input = {};
        int expected = 0;
        assertEquals(expected, MaxSubarraySum.sequence(input));
    }

    @Test
    @DisplayName("Deve retornar 0 para array com todos números negativos")
    void testAllNegativeNumbers() {
        int[] input = {-5, -3, -7, -1, -8};
        int expected = 0; // Regra do kata: retornar 0 para lista só de negativos
        assertEquals(expected, MaxSubarraySum.sequence(input));
    }

    @Test
    @DisplayName("Deve retornar a soma total para array com todos números positivos")
    void testAllPositiveNumbers() {
        int[] input = {1, 2, 3, 4, 5};
        int expected = 15; // Soma de todo o array
        assertEquals(expected, MaxSubarraySum.sequence(input));
    }

    @Test
    @DisplayName("Deve funcionar com array de um único elemento positivo")
    void testSinglePositiveElement() {
        int[] input = {7};
        int expected = 7;
        assertEquals(expected, MaxSubarraySum.sequence(input));
    }

    @Test
    @DisplayName("Deve retornar 0 para array de um único elemento negativo")
    void testSingleNegativeElement() {
        int[] input = {-4};
        int expected = 0;
        assertEquals(expected, MaxSubarraySum.sequence(input));
    }

    @Test
    @DisplayName("Deve funcionar quando o melhor subarray está no início")
    void testBestSubarrayAtBeginning() {
        int[] input = {5, 4, -1, 7, -8};
        int expected = 15; // Soma de [5, 4, -1, 7] = 15
        assertEquals(expected, MaxSubarraySum.sequence(input));
    }

    @Test
    @DisplayName("Deve funcionar quando o melhor subarray está no final")
    void testBestSubarrayAtEnd() {
        int[] input = {-1, -2, 3, 4, 5};
        int expected = 12; // Soma de [3, 4, 5] = 12
        assertEquals(expected, MaxSubarraySum.sequence(input));
    }

    @Test
    @DisplayName("Deve funcionar quando há zeros no array")
    void testArrayWithZeros() {
        int[] input = {0, -2, 5, -1, 0, 3, -2};
        int expected = 7; // Soma de [5, -1, 0, 3] = 7
        assertEquals(expected, MaxSubarraySum.sequence(input));
    }
}