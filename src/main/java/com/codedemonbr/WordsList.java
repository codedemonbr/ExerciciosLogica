package com.codedemonbr;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class WordsList {
    public static int findShort(String s) {
        if(s == null || s.isEmpty()) return 0;

        List<String> words = Arrays.stream(s.split(" ")).toList();

        if(words.isEmpty()) return 0;
        AtomicInteger tamanho = new AtomicInteger(words.getFirst().length());
        words.forEach(word -> {if(tamanho.get() > word.length()) {
            tamanho.set(word.length());
        }});
        return tamanho.get();
    }
}
