package com.codedemonbr;

import java.util.HashMap;
import java.util.Map;

public class Greed{
    public static int greedy(int[] dice){
        Map<Integer, Integer> freq = new HashMap<>();
        for (int value : dice) {
            freq.put(value, freq.getOrDefault(value, 0) + 1);
        }
        int score = 0;
        for (int i = 1; i < 7; i++) {
            int count = freq.getOrDefault(i, 0);
            if(count >= 3){
                switch (i){
                    case 1:
                        //        Three 1's => 1000 points
                        //        One   1   =>  100 points
                        score += 1000;
                        count = count - 3;
                        score += 100 * count;
                        break;
                    case 2:
                        //        Three 2's =>  200 points
                        score += 200;
                        break;
                    case 3:
                        //        Three 3's =>  300 points
                        score += 300;
                        break;
                    case 4:
                        //        Three 4's =>  400 points
                        score += 400;
                        break;
                    case 5:
                        //        Three 5's =>  500 points
                        //        One   5   =>   50 point
                        score += 500;
                        count = count - 3;
                        score += count * 50;
                        break;
                    case 6:
                        //        Three 6's =>  600 points
                        score += 600;
                        break;

                }
            }else{
                switch (i){
                    case 1:
                        //        One   1   =>  100 points
                        score += count * 100;
                        break;
                    case 5:
                        //        One   5   =>   50 point
                        score += count * 50;
                        break;
                }
            }

        }
        return score;
    }
}