package com.codedemonbr;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@DisplayName("Testes para Contador de Top 3 Palavras - JUnit 5 Nativo")
class TopWordsTest {

    @Test
    @DisplayName("Deve retornar as 3 palavras mais frequentes em ordem decrescente")
    void shouldReturnTop3WordsInOrder() {
        List<String> expected = List.of("e", "d", "a");
        assertEquals(expected, TopWords.top3("a a a  b  c c  d d d d  e e e e e"));
    }

    @Test
    @DisplayName("Deve ser insensível a maiúsculas/minúsculas")
    void shouldBeCaseInsensitive() {
        List<String> expected = List.of("e", "ddd", "aa");
        assertEquals(expected, TopWords.top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"));
    }

    @Test
    @DisplayName("Deve tratar apóstrofos como parte da palavra")
    void shouldHandleApostrophesInsideWords() {
        List<String> expected = List.of("won't", "wont");
        assertEquals(expected, TopWords.top3("  //wont won't won't "));
    }

    @Test
    @DisplayName("Deve ignorar pontuações e caracteres especiais isolados")
    void shouldIgnorePunctuationOnly() {
        assertEquals(List.of("e"), TopWords.top3("  , e  .. "));
        assertTrue(TopWords.top3("  ...  ").isEmpty());
    }

    @Test
    @DisplayName("Não deve aceitar apóstrofos sozinhos como palavras")
    void shouldNotCountApostrophesAsWords() {
        assertTrue(TopWords.top3("  '  ").isEmpty());
        assertTrue(TopWords.top3("  '''  ").isEmpty());
    }

    @Test
    @DisplayName("Deve lidar com múltiplas opções válidas em caso de empate")
    void shouldHandleTies() {
        List<String> actual = TopWords.top3("'a 'A 'a' a'A' a'a'!");
        List<List<String>> validOptions = List.of(
                List.of("'a", "a'a'", "'a'"),
                List.of("a'a'", "'a", "'a'"),
                List.of("'a'", "a'a'", "'a")
        );
        assertTrue(validOptions.contains(actual), "O resultado deve ser uma das combinações de empate válidas");
    }

    @Test
    @DisplayName("Deve processar corretamente um texto longo")
    void shouldHandleLargeParagraphs() {
        String text = """
            In a village of La Mancha, the name of which I have no desire to call to
            mind, there lived not long since one of those gentlemen that keep a lance
            in the lance-rack, an old buckler, a lean hack, and a greyhound for
            coursing. An olla of rather more beef than mutton, a salad on most
            nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra
            on Sundays, made away with three-quarters of his income.
            """;
        assertEquals(List.of("a", "of", "on"), TopWords.top3(text));
    }

    @Test
    @DisplayName("Deve retornar lista vazia para entrada vazia")
    void shouldReturnEmptyForEmptyInput() {
        assertTrue(TopWords.top3("").isEmpty());
        assertTrue(TopWords.top3("     ").isEmpty());
    }
}