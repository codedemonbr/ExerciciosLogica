package com.codedemonbr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RunesTest {

    @Test
    @DisplayName("1+1=?")
    void test1() {
        assertEquals(2, Runes.solveExpression("1+1=?"));
    }

    @Test
    @DisplayName("123*45?=5?088")
    void test2() {
        assertEquals(6, Runes.solveExpression("123*45?=5?088"));
    }

    @Test
    @DisplayName("-5?*-1=5?")
    void test3() {
        assertEquals(0, Runes.solveExpression("-5?*-1=5?"));
    }

    @Test
    @DisplayName("19--45=5?")
    void test4() {
        assertEquals(-1, Runes.solveExpression("19--45=5?"));
    }

    @Test
    @DisplayName("??*??=302?")
    void test5() {
        assertEquals(5, Runes.solveExpression("??*??=302?"));
    }

    @Test
    @DisplayName("?*11=??")
    void test6() {
        assertEquals(2, Runes.solveExpression("?*11=??"));
    }

    @Test
    @DisplayName("??*1=??")
    void test7() {
        assertEquals(2, Runes.solveExpression("??*1=??"));
    }

    @Test
    @DisplayName("??+??=??")
    void test8() {
        assertEquals(-1, Runes.solveExpression("??+??=??"));
    }

    // ==================== TESTES EXTRAS (bons para cobrir edge cases) ====================

    @Test
    @DisplayName("0+0=?")
    void testZero() {
        assertEquals(-1, Runes.solveExpression("0+0=?"));
    }

    @Test
    @DisplayName("-1+1=?")
    void testNegative() {
        assertEquals(0, Runes.solveExpression("-1+1=?"));
    }

    @Test
    @DisplayName("?*?=1")
    void testSmallProduct() {
        assertEquals(1, Runes.solveExpression("?*?=1"));
    }

    @Test
    @DisplayName("??+??=??")
    void testAllQuestionMarksSum() {
        assertEquals(-1, Runes.solveExpression("??+??=??"));
    }

    @Test
    @DisplayName("5?+5?=1?0")
    void testCarryOver() {
        assertEquals(0, Runes.solveExpression("5?+5?=1?0"));
    }
}