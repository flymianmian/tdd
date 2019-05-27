package com.tdd;

class FizzBuzz {
    private static int fizzNum = 3;
    private static int buzzNum = 5;
    private static String fizz = "Fizz";
    private static String buzz = "Buzz";

    static String of(int num) {
        if (isFizz(num) && isBuzz(num)) return fizz + buzz;
        if (isFizz(num)) return fizz;
        if (isBuzz(num)) return buzz;
        return String.valueOf(num);
    }

    private static boolean isBuzz(int num) {
        return num % buzzNum == 0 || String.valueOf(num).contains(String.valueOf(buzzNum));
    }

    private static boolean isFizz(int num) {
        return num % fizzNum == 0 || String.valueOf(num).contains(String.valueOf(fizzNum));
    }
}
