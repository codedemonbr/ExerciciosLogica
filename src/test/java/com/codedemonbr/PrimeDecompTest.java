import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimeDecompTest {

    @Test
    @DisplayName("n = 2 (smallest prime)")
    void testPrimeDecompOf2() {
        int n = 2;
        String expected = "(2)";
        assertEquals(expected, PrimeDecomp.factors(n));
    }

    @Test
    @DisplayName("n = 3 (prime)")
    void testPrimeDecompOf3() {
        int n = 3;
        String expected = "(3)";
        assertEquals(expected, PrimeDecomp.factors(n));
    }

    @Test
    @DisplayName("n = 4 (square of prime)")
    void testPrimeDecompOf4() {
        int n = 4;
        String expected = "(2**2)";
        assertEquals(expected, PrimeDecomp.factors(n));
    }

    @Test
    @DisplayName("n = 6 (product of two distinct primes)")
    void testPrimeDecompOf6() {
        int n = 6;
        String expected = "(2)(3)";
        assertEquals(expected, PrimeDecomp.factors(n));
    }

    @Test
    @DisplayName("n = 8 (cube of 2)")
    void testPrimeDecompOf8() {
        int n = 8;
        String expected = "(2**3)";
        assertEquals(expected, PrimeDecomp.factors(n));
    }

    @Test
    @DisplayName("n = 12 (2² * 3)")
    void testPrimeDecompOf12() {
        int n = 12;
        String expected = "(2**2)(3)";
        assertEquals(expected, PrimeDecomp.factors(n));
    }

    @Test
    @DisplayName("n = 17 (prime)")
    void testPrimeDecompOf17() {
        int n = 17;
        String expected = "(17)";
        assertEquals(expected, PrimeDecomp.factors(n));
    }

    @Test
    @DisplayName("n = 27 (3³)")
    void testPrimeDecompOf27() {
        int n = 27;
        String expected = "(3**3)";
        assertEquals(expected, PrimeDecomp.factors(n));
    }

    @Test
    @DisplayName("n = 86240 (example from description)")
    void testPrimeDecompOf86240() {
        int n = 86240;
        String expected = "(2**5)(5)(7**2)(11)";
        assertEquals(expected, PrimeDecomp.factors(n));
    }

    @Test
    @DisplayName("n = 7775460 (given test case)")
    void testPrimeDecompOf7775460() {
        int n = 7775460;
        String expected = "(2**2)(3**3)(5)(7)(11**2)(17)";
        assertEquals(expected, PrimeDecomp.factors(n));
    }

    @Test
    @DisplayName("n = 100 (2² * 5²)")
    void testPrimeDecompOf100() {
        int n = 100;
        String expected = "(2**2)(5**2)";
        assertEquals(expected, PrimeDecomp.factors(n));
    }

    @Test
    @DisplayName("n = 2310 (product of first primes)")
    void testPrimeDecompOf2310() {
        int n = 2310;
        String expected = "(2)(3)(5)(7)(11)";
        assertEquals(expected, PrimeDecomp.factors(n));
    }

    @Test
    @DisplayName("n = 10800 (2⁴ * 3³ * 5²)")
    void testPrimeDecompOf10800() {
        int n = 10800;
        String expected = "(2**4)(3**3)(5**2)";
        assertEquals(expected, PrimeDecomp.factors(n));
    }

    @Test
    @DisplayName("n = 65536 (power of two)")
    void testPrimeDecompOf65536() {
        int n = 65536;
        String expected = "(2**16)";
        assertEquals(expected, PrimeDecomp.factors(n));
    }

    @Test
    @DisplayName("n = 99991 (large prime)")
    void testPrimeDecompOf99991() {
        int n = 99991; // 99991 is prime
        String expected = "(99991)";
        assertEquals(expected, PrimeDecomp.factors(n));
    }

    @Test
    @DisplayName("n = 2147483647 (largest int prime)")
    void testPrimeDecompOfMaxIntPrime() {
        int n = 2147483647; // 2^31-1, a Mersenne prime
        String expected = "(2147483647)";
        assertEquals(expected, PrimeDecomp.factors(n));
    }
}
