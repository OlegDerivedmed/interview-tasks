package com.derivedmed.interview.sumOfDigits;

public class SumOfDigits {

    public static void main(String[] args) {
        System.out.println(getSumOfDigits(121));
    }

    public static int getSumOfDigits(int number) {
        if (number < 0) {
            number = -number;
        }
        if (number < 10) {
            return number;
        }
        return number%10 + getSumOfDigits(number/10);
    }
}
