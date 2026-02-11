package com.codedemonbr;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class RegexPINTest {

    // Testes para PINs válidos
    @Test
    void validPins() {
        assertAll(
                () -> assertTrue(RegexPIN.validatePin("1234")),
                () -> assertTrue(RegexPIN.validatePin("0000")),
                () -> assertTrue(RegexPIN.validatePin("1111")),
                () -> assertTrue(RegexPIN.validatePin("123456")),
                () -> assertTrue(RegexPIN.validatePin("098765")),
                () -> assertTrue(RegexPIN.validatePin("000000")),
                () -> assertTrue(RegexPIN.validatePin("090909"))
        );
    }

    // Testes para caracteres não numéricos (versão com ParameterizedTest)
    @ParameterizedTest
    @ValueSource(strings = {"a234", ".234", "12.34", "12345a", "abc123", " 1234", "1234 "})
    void nonDigitCharacters(String pin) {
        assertFalse(RegexPIN.validatePin(pin));
    }

    // Testes para comprimentos inválidos (versão com ParameterizedTest)
    @ParameterizedTest
    @ValueSource(strings = {
            "1", "12", "123", "12345", "1234567",
            "-1234", "1.234", "00000000", "", " "
    })
    void invalidLengths(String pin) {
        assertFalse(RegexPIN.validatePin(pin));
    }

    // Testes adicionais para casos de borda
    @Test
    void edgeCases() {
        assertAll(
                // Strings nulas ou vazias
                () -> assertFalse(RegexPIN.validatePin(null)),
                () -> assertFalse(RegexPIN.validatePin("")),

                // PINs com sinais
                () -> assertFalse(RegexPIN.validatePin("-1234")),
                () -> assertFalse(RegexPIN.validatePin("+1234")),

                // Espaços em branco
                () -> assertFalse(RegexPIN.validatePin("12 34")),
                () -> assertFalse(RegexPIN.validatePin("123 456")),

                // Caracteres especiais
                () -> assertFalse(RegexPIN.validatePin("12#34")),
                () -> assertFalse(RegexPIN.validatePin("1234%"))
        );
    }

    // Testes parametrizados para PINs válidos (opcional)
    @ParameterizedTest
    @ValueSource(strings = {
            "1234", "0000", "1111", "5678",
            "123456", "000000", "111111", "987654"
    })
    void validPinsParameterized(String pin) {
        assertTrue(RegexPIN.validatePin(pin));
    }
}
