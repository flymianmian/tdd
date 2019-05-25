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

    private static Boolean isFizz(int input) {
        return fizzOrBuzz(input, 3);
    }


    private static Boolean isBuzz(int input) {
        return fizzOrBuzz(input, 5);
    }

    private static boolean fizzOrBuzz(int input, int arg) {
        return input % arg == 0 || String.valueOf(input).contains(String.valueOf(arg));
    }
}
