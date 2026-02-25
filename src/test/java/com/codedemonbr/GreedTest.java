package com.codedemonbr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreedTest {

    // Cenários sem pontuação
    @Test
    void noScoreWhenNoOnesNoFivesNoTriplets() {
        assertEquals(0, Greed.greedy(new int[]{2, 3, 4, 6, 2}));
    }

    @Test
    void noScoreWithAllNonScoringNumbers() {
        assertEquals(0, Greed.greedy(new int[]{2, 2, 3, 4, 6}));
    }

    // Pontuação de unidades isoladas
    @Test
    void singleOneScores100() {
        assertEquals(100, Greed.greedy(new int[]{1, 2, 3, 4, 6}));
    }

    @Test
    void singleFiveScores50() {
        assertEquals(50, Greed.greedy(new int[]{5, 2, 3, 4, 6}));
    }

    @Test
    void twoOnesScore200() {
        assertEquals(200, Greed.greedy(new int[]{1, 1, 2, 3, 4}));
    }

    @Test
    void twoFivesScore100() {
        assertEquals(100, Greed.greedy(new int[]{5, 5, 2, 3, 4}));
    }

    @Test
    void oneOneAndOneFiveScore150() {
        assertEquals(150, Greed.greedy(new int[]{1, 5, 2, 3, 4}));
    }

    // Triplos de cada número
    @Test
    void threeOnesScore1000() {
        assertEquals(1000, Greed.greedy(new int[]{1, 1, 1, 2, 3}));
    }

    @Test
    void threeTwosScore200() {
        assertEquals(200, Greed.greedy(new int[]{2, 2, 2, 3, 4}));
    }

    @Test
    void threeThreesScore350() {
        assertEquals(350, Greed.greedy(new int[]{3, 3, 3, 4, 5}));
    }

    @Test
    void threeFoursScore400() {
        assertEquals(450, Greed.greedy(new int[]{4, 4, 4, 5, 6}));
    }

    @Test
    void threeFivesScore500() {
        assertEquals(500, Greed.greedy(new int[]{5, 5, 5, 2, 3}));
    }

    @Test
    void threeSixesScore600() {
        assertEquals(600, Greed.greedy(new int[]{6, 6, 6, 1, 2}));
    }

    // Combinações de triplos com unidades
    @Test
    void threeOnesAndOneFiveScore1050() {
        assertEquals(1050, Greed.greedy(new int[]{1, 1, 1, 5, 2}));
    }

    @Test
    void threeFivesAndOneOneScore600() {
        assertEquals(600, Greed.greedy(new int[]{5, 5, 5, 1, 2}));
    }

    @Test
    void threeFoursAndOneFiveScore450() {
        assertEquals(450, Greed.greedy(new int[]{4, 4, 4, 5, 2}));
    }

    // Múltiplos de um mesmo número além do triplo
    @Test
    void fourOnesScore1100() {  // 1000 (triplo) + 100 (extra)
        assertEquals(1100, Greed.greedy(new int[]{1, 1, 1, 1, 2}));
    }

    @Test
    void fourFivesScore600() {   // 500 (triplo) + 100 (dois extras? na verdade dois 5 extras dariam 100, mas só temos um extra além do triplo)
        // Quatro 5's: três formam 500, o quarto vale 50 -> total 550? Vamos corrigir: 5,5,5,5,2 -> triplo 500 + 1 extra 50 = 550
        assertEquals(550, Greed.greedy(new int[]{5, 5, 5, 5, 2}));
    }

    @Test
    void fourTwosScore200() {    // três 2's = 200, o quarto 2 não vale nada
        assertEquals(200, Greed.greedy(new int[]{2, 2, 2, 2, 3}));
    }

    @Test
    void fiveOnesScore1200() {   // três 1's = 1000 + dois 1's = 200
        assertEquals(1200, Greed.greedy(new int[]{1, 1, 1, 1, 1}));
    }

    @Test
    void fiveFivesScore600() {   // três 5's = 500 + dois 5's = 100
        assertEquals(600, Greed.greedy(new int[]{5, 5, 5, 5, 5}));
    }

    // Misturas complexas
    @Test
    void twoOnesAndTwoFivesAndASixScore300() {
        assertEquals(300, Greed.greedy(new int[]{1, 1, 5, 5, 6}));
    }

    @Test
    void threeOnesAndTwoFivesScore1100() {
        assertEquals(1100, Greed.greedy(new int[]{1, 1, 1, 5, 5}));
    }

    @Test
    void threeFivesAndTwoOnesScore700() {
        assertEquals(700, Greed.greedy(new int[]{5, 5, 5, 1, 1}));
    }

    // Exemplos clássicos
    @Test
    void exampleFromStatement_shouldBeWorthless() {
        assertEquals(0, Greed.greedy(new int[]{2, 3, 4, 6, 2}));
    }

    @Test
    void exampleFromStatement_shouldValueTriplets() {
        assertEquals(400, Greed.greedy(new int[]{4, 4, 4, 3, 3}));
    }

    @Test
    void exampleFromStatement_shouldValueMixedSets() {
        assertEquals(450, Greed.greedy(new int[]{2, 4, 4, 5, 4}));
    }
}