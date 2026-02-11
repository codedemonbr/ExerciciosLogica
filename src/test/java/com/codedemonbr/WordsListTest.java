package com.codedemonbr;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

class WordsListTest {

    // Testes originais do exemplo
    @Test
    @DisplayName("Teste 1: 'bitcoin take over the world maybe who knows perhaps'")
    void findShortTest1() {
        String input = "bitcoin take over the world maybe who knows perhaps";
        int expected = 3;
        int actual = WordsList.findShort(input);
        assertEquals(expected, actual,
                () -> String.format("Para '%s' esperado %d mas obteve %d", input, expected, actual));
    }

    @Test
    @DisplayName("Teste 2: 'turns out random test cases are easier than writing out basic ones'")
    void findShortTest2() {
        String input = "turns out random test cases are easier than writing out basic ones";
        int expected = 3;
        int actual = WordsList.findShort(input);
        assertEquals(expected, actual,
                () -> String.format("Para '%s' esperado %d mas obteve %d", input, expected, actual));
    }

    @Test
    @DisplayName("Teste 3: 'Let's travel abroad shall we'")
    void findShortTest3() {
        String input = "Let's travel abroad shall we";
        int expected = 2;
        int actual = WordsList.findShort(input);
        assertEquals(expected, actual,
                () -> String.format("Para '%s' esperado %d mas obteve %d", input, expected, actual));
    }

    // Testes adicionais
    @Test
    @DisplayName("Teste 4: String vazia")
    void findShortEmptyString() {
        String input = "";
        int expected = 0;
        int actual = WordsList.findShort(input);
        assertEquals(expected, actual,
                () -> String.format("Para string vazia esperado %d mas obteve %d", expected, actual));
    }

    @Test
    @DisplayName("Teste 5: Apenas espaços")
    void findShortOnlySpaces() {
        String input = "     ";
        int expected = 0;
        int actual = WordsList.findShort(input);
        assertEquals(expected, actual,
                () -> String.format("Para apenas espaços esperado %d mas obteve %d", expected, actual));
    }

    @Test
    @DisplayName("Teste 6: Uma palavra")
    void findShortSingleWord() {
        String input = "hello";
        int expected = 5;
        int actual = WordsList.findShort(input);
        assertEquals(expected, actual,
                () -> String.format("Para '%s' esperado %d mas obteve %d", input, expected, actual));
    }

    @Test
    @DisplayName("Teste 7: Palavras com tamanhos diferentes")
    void findShortDifferentLengths() {
        String input = "a bb ccc dddd eeeee";
        int expected = 1;
        int actual = WordsList.findShort(input);
        assertEquals(expected, actual,
                () -> String.format("Para '%s' esperado %d mas obteve %d", input, expected, actual));
    }

    @Test
    @DisplayName("Teste 8: Múltiplos espaços entre palavras")
    void findShortMultipleSpaces() {
        String input = "bitcoin   take    over     the      world";
        int expected = 3;
        int actual = WordsList.findShort(input);
        assertEquals(expected, actual,
                () -> String.format("Para '%s' esperado %d mas obteve %d", input, expected, actual));
    }

    @Test
    @DisplayName("Teste 9: String com null")
    void findShortNullString() {
        String input = null;
        int expected = 0;
        int actual = WordsList.findShort(input);
        assertEquals(expected, actual,
                () -> String.format("Para null esperado %d mas obteve %d", expected, actual));
    }

    @Test
    @DisplayName("Teste 10: Palavras com caracteres especiais")
    void findShortSpecialCharacters() {
        String input = "a! b@c #def $%ghi";
        int expected = 1;
        int actual = WordsList.findShort(input);
        assertEquals(expected, actual,
                () -> String.format("Para '%s' esperado %d mas obteve %d", input, expected, actual));
    }

    @Test
    @DisplayName("Teste 11: Todas as palavras do mesmo tamanho")
    void findShortAllSameLength() {
        String input = "cat dog pig fox";
        int expected = 3;
        int actual = WordsList.findShort(input);
        assertEquals(expected, actual,
                () -> String.format("Para '%s' esperado %d mas obteve %d", input, expected, actual));
    }

    @Test
    @DisplayName("Teste 12: Palavra mais curta no início")
    void findShortShortestAtBeginning() {
        String input = "a longerword anotherword";
        int expected = 1;
        int actual = WordsList.findShort(input);
        assertEquals(expected, actual,
                () -> String.format("Para '%s' esperado %d mas obteve %d", input, expected, actual));
    }

    @Test
    @DisplayName("Teste 13: Palavra mais curta no final")
    void findShortShortestAtEnd() {
        String input = "longerword anotherword z";
        int expected = 1;
        int actual = WordsList.findShort(input);
        assertEquals(expected, actual,
                () -> String.format("Para '%s' esperado %d mas obteve %d", input, expected, actual));
    }

    @Test
    @DisplayName("Teste 14: Palavra mais curta no meio")
    void findShortShortestInMiddle() {
        String input = "longword x anotherlongword";
        int expected = 1;
        int actual = WordsList.findShort(input);
        assertEquals(expected, actual,
                () -> String.format("Para '%s' esperado %d mas obteve %d", input, expected, actual));
    }

    @Test
    @DisplayName("Teste 15: String com números")
    void findShortWithNumbers() {
        String input = "bitcoin 1 22 333 take 4444";
        int expected = 1;
        int actual = WordsList.findShort(input);
        assertEquals(expected, actual,
                () -> String.format("Para '%s' esperado %d mas obteve %d", input, expected, actual));
    }
}