package com.codedemonbr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralsTest {

    // Testes para toRoman() - Conversão de número inteiro para numeral romano

    @Test
    void toRoman_1() {
        assertEquals("I", RomanNumerals.toRoman(1));
    }

    @Test
    void toRoman_2() {
        assertEquals("II", RomanNumerals.toRoman(2));
    }

    @Test
    void toRoman_3() {
        assertEquals("III", RomanNumerals.toRoman(3));
    }

    @Test
    void toRoman_4() {
        assertEquals("IV", RomanNumerals.toRoman(4));
    }

    @Test
    void toRoman_5() {
        assertEquals("V", RomanNumerals.toRoman(5));
    }

    @Test
    void toRoman_6() {
        assertEquals("VI", RomanNumerals.toRoman(6));
    }

    @Test
    void toRoman_7() {
        assertEquals("VII", RomanNumerals.toRoman(7));
    }

    @Test
    void toRoman_8() {
        assertEquals("VIII", RomanNumerals.toRoman(8));
    }

    @Test
    void toRoman_9() {
        assertEquals("IX", RomanNumerals.toRoman(9));
    }

    @Test
    void toRoman_10() {
        assertEquals("X", RomanNumerals.toRoman(10));
    }

    @Test
    void toRoman_40() {
        assertEquals("XL", RomanNumerals.toRoman(40));
    }

    @Test
    void toRoman_50() {
        assertEquals("L", RomanNumerals.toRoman(50));
    }

    @Test
    void toRoman_90() {
        assertEquals("XC", RomanNumerals.toRoman(90));
    }

    @Test
    void toRoman_100() {
        assertEquals("C", RomanNumerals.toRoman(100));
    }

    @Test
    void toRoman_400() {
        assertEquals("CD", RomanNumerals.toRoman(400));
    }

    @Test
    void toRoman_500() {
        assertEquals("D", RomanNumerals.toRoman(500));
    }

    @Test
    void toRoman_900() {
        assertEquals("CM", RomanNumerals.toRoman(900));
    }

    @Test
    void toRoman_1000() {
        assertEquals("M", RomanNumerals.toRoman(1000));
    }

    @Test
    void toRoman_1666() {
        assertEquals("MDCLXVI", RomanNumerals.toRoman(1666));
    }

    @Test
    void toRoman_1987() {
        assertEquals("MCMLXXXVII", RomanNumerals.toRoman(1987));
    }

    @Test
    void toRoman_1990() {
        assertEquals("MCMXC", RomanNumerals.toRoman(1990));
    }

    @Test
    void toRoman_2008() {
        assertEquals("MMVIII", RomanNumerals.toRoman(2008));
    }

    @Test
    void toRoman_2019() {
        assertEquals("MMXIX", RomanNumerals.toRoman(2019));
    }

    @Test
    void toRoman_2021() {
        assertEquals("MMXXI", RomanNumerals.toRoman(2021));
    }

    @Test
    void toRoman_86() {
        assertEquals("LXXXVI", RomanNumerals.toRoman(86));
    }

    @Test
    void toRoman_99() {
        assertEquals("XCIX", RomanNumerals.toRoman(99));
    }

    @Test
    void toRoman_499() {
        assertEquals("CDXCIX", RomanNumerals.toRoman(499));
    }

    @Test
    void toRoman_999() {
        assertEquals("CMXCIX", RomanNumerals.toRoman(999));
    }

    @Test
    void toRoman_3999() {
        assertEquals("MMMCMXCIX", RomanNumerals.toRoman(3999));
    }

    // Testes para fromRoman() - Conversão de numeral romano para inteiro

    @Test
    void fromRoman_I() {
        assertEquals(1, RomanNumerals.fromRoman("I"));
    }

    @Test
    void fromRoman_II() {
        assertEquals(2, RomanNumerals.fromRoman("II"));
    }

    @Test
    void fromRoman_III() {
        assertEquals(3, RomanNumerals.fromRoman("III"));
    }

    @Test
    void fromRoman_IV() {
        assertEquals(4, RomanNumerals.fromRoman("IV"));
    }

    @Test
    void fromRoman_V() {
        assertEquals(5, RomanNumerals.fromRoman("V"));
    }

    @Test
    void fromRoman_VI() {
        assertEquals(6, RomanNumerals.fromRoman("VI"));
    }

    @Test
    void fromRoman_VII() {
        assertEquals(7, RomanNumerals.fromRoman("VII"));
    }

    @Test
    void fromRoman_VIII() {
        assertEquals(8, RomanNumerals.fromRoman("VIII"));
    }

    @Test
    void fromRoman_IX() {
        assertEquals(9, RomanNumerals.fromRoman("IX"));
    }

    @Test
    void fromRoman_X() {
        assertEquals(10, RomanNumerals.fromRoman("X"));
    }

    @Test
    void fromRoman_XL() {
        assertEquals(40, RomanNumerals.fromRoman("XL"));
    }

    @Test
    void fromRoman_L() {
        assertEquals(50, RomanNumerals.fromRoman("L"));
    }

    @Test
    void fromRoman_XC() {
        assertEquals(90, RomanNumerals.fromRoman("XC"));
    }

    @Test
    void fromRoman_C() {
        assertEquals(100, RomanNumerals.fromRoman("C"));
    }

    @Test
    void fromRoman_CD() {
        assertEquals(400, RomanNumerals.fromRoman("CD"));
    }

    @Test
    void fromRoman_D() {
        assertEquals(500, RomanNumerals.fromRoman("D"));
    }

    @Test
    void fromRoman_CM() {
        assertEquals(900, RomanNumerals.fromRoman("CM"));
    }

    @Test
    void fromRoman_M() {
        assertEquals(1000, RomanNumerals.fromRoman("M"));
    }

    @Test
    void fromRoman_MDCLXVI() {
        assertEquals(1666, RomanNumerals.fromRoman("MDCLXVI"));
    }

    @Test
    void fromRoman_MCMLXXXVII() {
        assertEquals(1987, RomanNumerals.fromRoman("MCMLXXXVII"));
    }

    @Test
    void fromRoman_MCMXC() {
        assertEquals(1990, RomanNumerals.fromRoman("MCMXC"));
    }

    @Test
    void fromRoman_MMVIII() {
        assertEquals(2008, RomanNumerals.fromRoman("MMVIII"));
    }

    @Test
    void fromRoman_MMXIX() {
        assertEquals(2019, RomanNumerals.fromRoman("MMXIX"));
    }

    @Test
    void fromRoman_MMXXI() {
        assertEquals(2021, RomanNumerals.fromRoman("MMXXI"));
    }

    @Test
    void fromRoman_LXXXVI() {
        assertEquals(86, RomanNumerals.fromRoman("LXXXVI"));
    }

    @Test
    void fromRoman_XCIX() {
        assertEquals(99, RomanNumerals.fromRoman("XCIX"));
    }

    @Test
    void fromRoman_CDXCIX() {
        assertEquals(499, RomanNumerals.fromRoman("CDXCIX"));
    }

    @Test
    void fromRoman_CMXCIX() {
        assertEquals(999, RomanNumerals.fromRoman("CMXCIX"));
    }

    @Test
    void fromRoman_MMMCMXCIX() {
        assertEquals(3999, RomanNumerals.fromRoman("MMMCMXCIX"));
    }
}