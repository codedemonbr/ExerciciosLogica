package com.codedemonbr;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountDuplicatesTest {

    @Test
    @DisplayName("Testes básicos de duplicatas")
    public void basicTests() {
        assertAll(
                () -> assertEquals(0, CountingDuplicates.duplicateCount(""),
                        "String vazia deve retornar 0"),
                () -> assertEquals(0, CountingDuplicates.duplicateCount("abcde"),
                        "'abcde' deve retornar 0"),
                () -> assertEquals(1, CountingDuplicates.duplicateCount("abcdeaa"),
                        "'abcdeaa' deve retornar 1"),
                () -> assertEquals(2, CountingDuplicates.duplicateCount("abcdeaB"),
                        "'abcdeaB' deve retornar 2"));
    }

    @Test
    @DisplayName("Testes com palavras complexas")
    public void complexWordTests() {
        assertAll(
                () -> assertEquals(2, CountingDuplicates.duplicateCount("Indivisibilities"),
                        "'Indivisibilities' deve retornar 2"),
                () -> assertEquals(0, CountingDuplicates.duplicateCount("abcdefghijklmnopqrstuvwxyz"),
                        "Alfabeto completo deve retornar 0"),
                () -> assertEquals(2, CountingDuplicates.duplicateCount("abcdefghijklmnopqrstuvwxyzaaAb"),
                        "Alfabeto com extras deve retornar 2"));
    }

    @Test
    @DisplayName("Testes com alfabetos duplicados")
    public void duplicatedAlphabetTests() {
        assertAll(
                () -> assertEquals(26, CountingDuplicates.duplicateCount(
                        "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"),
                        "Alfabeto duplicado deve retornar 26"),
                () -> assertEquals(26, CountingDuplicates.duplicateCount(
                        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"),
                        "Alfabeto misto deve retornar 26"));
    }

    @Test
    @DisplayName("Testes edge cases")
    public void edgeCaseTests() {
        assertAll(
                () -> assertEquals(0, CountingDuplicates.duplicateCount(null),
                        "null deve retornar 0"),
                () -> assertEquals(0, CountingDuplicates.duplicateCount("a"),
                        "String com um caractere deve retornar 0"),
                () -> assertEquals(1, CountingDuplicates.duplicateCount("aa"),
                        "'aa' deve retornar 1"),
                () -> assertEquals(1, CountingDuplicates.duplicateCount("aA"),
                        "'aA' deve retornar 1 (case-insensitive)"));
    }
}