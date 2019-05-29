package com.tdd;

class FizzBuzz {

    static String of(int num) {
        if (isFizz(num) && isBuzz(num)) return "FizzBuzz";
        if (isFizz(num)) return "Fizz";
        if (isBuzz(num)) return "Buzz";
        return String.valueOf(num);
    }

    private static boolean isBuzz(int num) {
        int buzzNum = 5;
        return checkNum(num, buzzNum);
    }

    private static boolean isFizz(int num) {
        int fizzNum = 3;
        return checkNum(num, fizzNum);
    }

    private static boolean checkNum(int num, int flag) {
        return num % flag == 0 || String.valueOf(num).contains(String.valueOf(flag));
    }
}
