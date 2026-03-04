package com.codedemonbr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountIPAddressesTest {

    @Test
    void ipsBetween_10_0_0_0_to_10_0_0_50() {
        long expected = 50;
        String start = "10.0.0.0";
        String end = "10.0.0.50";
        long actual = CountIPAddresses.ipsBetween(start, end);
        String message = String.format("for start = \"%s\" and end = \"%s\"", start, end);
        assertEquals(expected, actual, message);
    }

    @Test
    void ipsBetween_20_0_0_10_to_20_0_1_0() {
        long expected = 246;
        String start = "20.0.0.10";
        String end = "20.0.1.0";
        long actual = CountIPAddresses.ipsBetween(start, end);
        String message = String.format("for start = \"%s\" and end = \"%s\"", start, end);
        assertEquals(expected, actual, message);
    }

    @Test
    void ipsBetween_0_0_0_0_to_255_255_255_255() {
        long expected = (1L << 32L) - 1L; // 4294967295L
        String start = "0.0.0.0";
        String end = "255.255.255.255";
        long actual = CountIPAddresses.ipsBetween(start, end);
        String message = String.format("for start = \"%s\" and end = \"%s\"", start, end);
        assertEquals(expected, actual, message);
    }

    @Test
    void ipsBetween_150_0_0_0_to_150_0_0_1() {
        long expected = 1;
        String start = "150.0.0.0";
        String end = "150.0.0.1";
        long actual = CountIPAddresses.ipsBetween(start, end);
        String message = String.format("for start = \"%s\" and end = \"%s\"", start, end);
        assertEquals(expected, actual, message);
    }
}