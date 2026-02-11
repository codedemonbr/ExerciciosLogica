package com.codedemonbr;

import java.util.Set;
import java.util.stream.Collectors;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        if(text == null || text.isEmpty()) return 0;
        String textLower = text.toLowerCase();
        Set<Character> conjunto = textLower
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        int acc = 0;
        for (int i = 0; i < conjunto.size(); i++) {
            Character letra = (Character) conjunto.toArray()[i];
            int accLetra = 0;
            for (int j = 0; j < textLower.length(); j++) {
                if (letra.equals(textLower.charAt(j))) {
                    accLetra++;
                }
            }
            if (accLetra > 1) {
                acc++;
            }
        }

        return acc;
    }
}
