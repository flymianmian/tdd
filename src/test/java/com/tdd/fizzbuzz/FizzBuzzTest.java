package com.tdd.fizzbuzz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {
    @ParameterizedTest(name = "should return {1} given {0}")
    @CsvSource({
            "1,'1'",
            "3,'Fizz'",
            "5,'Buzz'",
            "15,'com.tdd.FizzBuzz'",
            "13,'Fizz'",
            "52,'Buzz'",
            "35,'com.tdd.FizzBuzz'",
            "53,'com.tdd.FizzBuzz'",
    })
    void test(int num, String text) {
        assertThat(FizzBuzz.of(num)).isEqualTo(text);
    }
}
