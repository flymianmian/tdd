package com.tdd;

class FizzBuzz {

    private FizzBuzz() {
    }

    static String of(int input) {
        if (isFizz(input) && isBuzz(input)) {
            return "FizzBuzz";
        }
        if (isFizz(input)) {
            return "Fizz";
        }
        if (isBuzz(input)) {
            return "Buzz";
        }
        return String.valueOf(input);
    }

    static Boolean isFizz(int input) {
        return input % 3 == 0 || String.valueOf(input).contains("3");
    }

    static Boolean isBuzz(int input) {
        return input % 5 == 0 || String.valueOf(input).contains("5");
    }
}
