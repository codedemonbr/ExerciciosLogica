package com.codedemonbr;

import java.util.Arrays;
import java.util.Comparator;

public class Interval {
    public static int sumIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }

        int[][] sorted = intervals.clone();
        Arrays.sort(sorted, Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(a -> a[1]));
        int acc = sorted[0][1] - sorted[0][0];

        for (int current = 1; current < sorted.length; current++) {
            int previous = current - 1;
            if(sorted[current][0] < sorted[previous][1]){
                acc -= (sorted[previous][1] - sorted[current][0]);
            }
            acc += (sorted[current][1] - sorted[current][0]);
        }
        return acc;
    }

}