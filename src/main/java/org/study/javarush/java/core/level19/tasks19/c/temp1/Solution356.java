package org.study.javarush.java.core.level19.tasks19.c.temp1;

public class Solution356 {
    public static void main(String[] args) {

        UpperCaseCipher cipher = new UpperCaseCipher();
        String result = cipher.encode("secret message");
        System.out.println(result);
    }
}

abstract class Cipher {
    public abstract String encode(String text);
}

class UpperCaseCipher extends Cipher {
    @Override
    public String encode(String text) {
        return text.toUpperCase();
    }
}
