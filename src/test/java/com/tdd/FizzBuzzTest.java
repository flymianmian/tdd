package com.tdd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {
    @ParameterizedTest(name = "should return {0} given {1}")
    @CsvSource(value = {
            "1,'1'",
            "3,'Fizz'",
            "5,'Buzz'",
            "31,'Fizz'",
            "52,'Buzz'",
            "15,'FizzBuzz'",
            "35,'FizzBuzz'",
            "53,'FizzBuzz'",
            "51,'FizzBuzz',"
    })
    void test(int input, String words) {
        assertThat(FizzBuzz.of(input)).isEqualTo(words);
    }
}
