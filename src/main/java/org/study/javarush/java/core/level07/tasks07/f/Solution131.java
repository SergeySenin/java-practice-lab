package org.study.javarush.java.core.level07.tasks07.f;

import java.util.Arrays;

public class Solution131 {
    public static void main(String[] args) {

        int[] mainCode = {3, 6, 9, 12};
        int[] backupCode = {3, 6, 9, 12};

        boolean codesMatch = Arrays.equals(mainCode, backupCode);

        System.out.println(codesMatch);
    }
}
