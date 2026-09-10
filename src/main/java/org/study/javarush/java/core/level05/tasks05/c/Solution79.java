package org.study.javarush.java.core.level05.tasks05.c;

import java.util.Scanner;

public class Solution79 {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String treasureAmount = console.nextLine().trim();

        int signLength = treasureAmount.startsWith("+") || treasureAmount.startsWith("-") ? 1 : 0;
        int digitCount = treasureAmount.length() - signLength;

        System.out.println(digitCount);
    }
}
