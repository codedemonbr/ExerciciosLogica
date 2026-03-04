package com.codedemonbr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RangeExtractionTest {

    @Test
    public void testRangeExtractionExample1() {
        int[] input = {-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20};
        String expected = "-6,-3-1,3-5,7-11,14,15,17-20";
        assertEquals(expected, RangeExtraction.rangeExtraction(input));
    }

    @Test
    public void testRangeExtractionExample2() {
        int[] input = {-3, -2, -1, 2, 10, 15, 16, 18, 19, 20};
        String expected = "-3--1,2,10,15,16,18-20";
        assertEquals(expected, RangeExtraction.rangeExtraction(input));
    }
}