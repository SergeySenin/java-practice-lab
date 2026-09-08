package org.study.javarush.java.core.level06.tasks06.f;

public class Solution109 {
    public static void main(String[] args) {

        char secretAgentLetter = 'G';

        int numericCode = (int) secretAgentLetter;
        System.out.println(numericCode);

        char decodedAgentLetter = (char) numericCode;
        System.out.println(decodedAgentLetter);
    }
}
