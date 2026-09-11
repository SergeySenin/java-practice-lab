package org.study.javarush.java.core.level07.tasks07.f;

import java.util.Arrays;

public class Solution130 {
    public static void main(String[] args) {

        int[] dailyTemperatures = {10, 20, 30, 40, 50, 60, 70};
        int[] x = Arrays.copyOfRange(dailyTemperatures, 2, 5);
        System.out.println(Arrays.toString(x));
    }
}
