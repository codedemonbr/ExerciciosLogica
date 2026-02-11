package com.codedemonbr;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Rot13Test {

    @Test
    void testBasic() {
        assertEquals("grfg", Rot13.rot13("test"), "Input: \"test\"");
        assertEquals("Grfg", Rot13.rot13("Test"), "Input: \"Test\"");
    }

    @Test
    void testRot13IsItsOwnInverse() {
        String original = "Hello World!";
        String encoded = Rot13.rot13(original);
        String decoded = Rot13.rot13(encoded);
        assertEquals(original, decoded, "ROT13 should be its own inverse");
    }

    @Test
    void testWithNumbersAndSpecialChars() {
        assertEquals("Uryyb Jbeyq! 123 @#", Rot13.rot13("Hello World! 123 @#"),
                "Numbers and special characters should remain unchanged");
    }

    @Test
    void testAlphabetWrapAround() {
        assertEquals("nopqrstuvwxyzabcdefghijklm",
                Rot13.rot13("abcdefghijklmnopqrstuvwxyz"),
                "Lowercase alphabet should wrap around correctly");

        assertEquals("NOPQRSTUVWXYZABCDEFGHIJKLM",
                Rot13.rot13("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
                "Uppercase alphabet should wrap around correctly");
    }

    @Test
    void testEmptyString() {
        assertEquals("", Rot13.rot13(""), "Empty string should return empty string");
    }

    @Test
    void testMixedCase() {
        assertEquals("Ubj pna lbh gryy na rkgebireg sebz na vagebireg ng AFN?",
                Rot13.rot13("How can you tell an extrovert from an introvert at NSA?"),
                "Mixed case and punctuation should work correctly");

        assertEquals("In the elevators, the extrovert looks at the OTHER guy's shoes.",
                Rot13.rot13("Va gur ryringbef, gur rkgebireg ybbxf ng gur BGURE thl'f fubrf."),
                "Complex sentence with apostrophe and mixed case");
    }

    @Test
    void testEdgeCases() {
        assertEquals("M", Rot13.rot13("Z"), "Z should wrap to M");
        assertEquals("m", Rot13.rot13("z"), "z should wrap to m");
        assertEquals("N", Rot13.rot13("A"), "A should wrap to N");
        assertEquals("n", Rot13.rot13("a"), "a should wrap to n");
    }

    @Test
    void testNonLatinCharacters() {
        assertEquals("Привет 123", Rot13.rot13("Привет 123"),
                "Non-latin characters should remain unchanged");
        assertEquals("こんにちは", Rot13.rot13("こんにちは"),
                "Japanese characters should remain unchanged");
    }
}