package org.study.javarush.java.core.level06.tasks06.b;

public class Solution95 {
    public static void main(String[] args) {

        int secretSpellCode = 8364;
        char revealedSymbol = (char) secretSpellCode;

        System.out.println("Символ с кодом 8364: " + revealedSymbol);

        char enigmaticLetter = 'Ж';
        int numericEssenceOfLetter = (int) enigmaticLetter;

        System.out.println("Код символа 'Ж': " + numericEssenceOfLetter);
    }
}
