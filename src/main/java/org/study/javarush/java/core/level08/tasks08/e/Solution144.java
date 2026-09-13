package org.study.javarush.java.core.level08.tasks08.e;

public class Solution144 {
    public static void main(String[] args) {

        int[] initialPath = {3, 4, 5};

        resetRobotStart(initialPath);

        System.out.println(initialPath[0]);
    }

    public static void resetRobotStart(int[] trajectoryPath) {
        trajectoryPath[0] = 0;
    }
}
