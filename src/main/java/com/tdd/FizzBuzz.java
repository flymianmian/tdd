package com.tdd;

class FizzBuzz {
    static String of(int num) {
        if (isFizz(num) && isBuzz(num)) return "FizzBuzz";
        if (isFizz(num)) return "Fizz";
        if (isBuzz(num)) return "Buzz";
        return String.valueOf(num);
    }

    private static boolean isBuzz(int num) {
        return num % 5 == 0 || String.valueOf(num).contains("5");
    }

    private static boolean isFizz(int num) {
        return num % 3 == 0 || String.valueOf(num).contains("3");
    }
}
