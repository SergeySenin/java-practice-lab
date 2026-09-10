package org.study.javarush.java.core.level05.tasks05.c;

import java.util.Scanner;

public class Solution78 {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String ancientRiddle = console.nextLine();

        int[] riddleCodePoints = ancientRiddle.codePoints().toArray();
        boolean isPalindrome = true;

        for (int leftIndex = 0; leftIndex < riddleCodePoints.length / 2; leftIndex++) {
            int rightIndex = riddleCodePoints.length - 1 - leftIndex;

            if (riddleCodePoints[leftIndex] != riddleCodePoints[rightIndex]) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome ? "YES" : "NO");
    }
}
