import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    @Test
    void test() {
        assertEquals("1", FizzBuzz.of(1));
        assertEquals("Fizz", FizzBuzz.of(3));
        assertEquals("Buzz", FizzBuzz.of(5));
        assertEquals("FizzBuzz", FizzBuzz.of(15));
    }
}