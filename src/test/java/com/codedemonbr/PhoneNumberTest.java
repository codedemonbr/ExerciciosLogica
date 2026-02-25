package com.codedemonbr;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneNumberTest {

    @Test
    @DisplayName("Deve formatar corretamente o exemplo fornecido")
    void testExample() {
        assertEquals("(123) 456-7890",
                Kata.createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }

    @Test
    @DisplayName("Deve formatar corretamente quando todos os números são zero")
    void testAllZeros() {
        assertEquals("(000) 000-0000",
                Kata.createPhoneNumber(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }

    @Test
    @DisplayName("Deve formatar corretamente quando todos os números são nove")
    void testAllNines() {
        assertEquals("(999) 999-9999",
                Kata.createPhoneNumber(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}));
    }

    @Test
    @DisplayName("Deve preservar zeros à esquerda")
    void testLeadingZeros() {
        assertEquals("(012) 345-6789",
                Kata.createPhoneNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

    @Test
    @DisplayName("Deve formatar corretamente com padrões repetidos")
    void testRepeatedPattern() {
        assertEquals("(111) 222-3333",
                Kata.createPhoneNumber(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 3}));
    }

    @Test
    @DisplayName("Deve formatar corretamente uma sequência decrescente")
    void testDescendingSequence() {
        assertEquals("(987) 654-3210",
                Kata.createPhoneNumber(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));
    }

    @Test
    @DisplayName("Deve formatar corretamente uma sequência alternada")
    void testAlternatingSequence() {
        assertEquals("(101) 010-1010",
                Kata.createPhoneNumber(new int[]{1, 0, 1, 0, 1, 0, 1, 0, 1, 0}));
    }
}