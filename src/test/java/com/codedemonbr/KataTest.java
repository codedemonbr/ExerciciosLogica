package com.codedemonbr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KataTest {

    @Test
    void testArraySimetrico() {
        assertEquals(3, Kata.findEvenIndex(new int[] {1,2,3,4,3,2,1}));
    }

    @Test
    void testArrayComNegativos() {
        assertEquals(1, Kata.findEvenIndex(new int[] {1,100,50,-51,1,1}));
    }

    @Test
    void testArraySemPontoEquilibrio() {
        assertEquals(-1, Kata.findEvenIndex(new int[] {1,2,3,4,5,6}));
    }

    @Test
    void testArrayComElementosRepetidos() {
        assertEquals(3, Kata.findEvenIndex(new int[] {20,10,30,10,10,15,35}));
    }

    @Test
    void testArrayComTodosNegativos() {
        assertEquals(-1, Kata.findEvenIndex(new int[] {-8505, -5130, 1926, -9026}));
    }

    @Test
    void testArrayComGrandesVariacoes() {
        assertEquals(1, Kata.findEvenIndex(new int[] {2824, 1774, -1490, -9084, -9696, 23094}));
    }

    @Test
    void testArrayPalindromoImpar() {
        assertEquals(6, Kata.findEvenIndex(new int[] {4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));
    }
}