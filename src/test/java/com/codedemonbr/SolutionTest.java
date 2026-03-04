package com.codedemonbr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    void add_1_and_1() {
        assertEquals("2", Kata.add("1", "1"));
    }

    @Test
    void add_123_and_456() {
        assertEquals("579", Kata.add("123", "456"));
    }

    @Test
    void add_888_and_222() {
        assertEquals("1110", Kata.add("888", "222"));
    }

    @Test
    void add_1372_and_69() {
        assertEquals("1441", Kata.add("1372", "69"));
    }

    @Test
    void add_12_and_456() {
        assertEquals("468", Kata.add("12", "456"));
    }

    @Test
    void add_100_and_101() {
        assertEquals("201", Kata.add("100", "101"));
    }

    @Test
    void add_4257320_and_08225407835956495595538753798225() {
        String a = "4257320";
        String b = "08225407835956495595538753798225";
        String expected = "8225407835956495595538758055545";
        String actual = Kata.add(a, b);
        assertEquals(expected, actual,
                "Falha na soma: " + a + " + " + b + " deveria ser " + expected + " mas foi " + actual);
    }

    @Test
    void add_two_very_large_numbers() {
        String a = "63829983432984289347293874";
        String b = "90938498237058927340892374089";
        String expected = "91002328220491911630239667963";
        assertEquals(expected, Kata.add(a, b));
    }
}


