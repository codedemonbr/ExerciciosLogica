package com.codedemonbr;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TopWords {

    public static List<String> top3(String s){
        s = s.toLowerCase();

        Pattern pattern = Pattern.compile("[a-z']+");
        Matcher matcher = pattern.matcher(s);
        String[] parts = s.split("\\s+");
        Map<String, Integer> freq = new HashMap<>();

        while(matcher.find()){
            String word = matcher.group();
            if (word.matches(".*[a-z].*")){
                freq.merge(word, 1, Integer::sum);
            }
        }
        return freq.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }
}
