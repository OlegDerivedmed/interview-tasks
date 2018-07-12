package com.derivedmed.interview.stringReverse;

public class StringReverse {

    public static void main(String[] args) {
        System.out.println(reverse("Hello world"));
    }

    public static String reverse(String s) {
        char c;
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < Math.floor(length/2); i++) {
            c = chars[i];
            chars[i] = chars[length - i - 1];
            chars[length - i - 1] = c;
        }
        return String.valueOf(chars);
    }
}
