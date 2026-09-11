package org.study.javarush.java.core.level07.tasks07.d;

public class Solution120 {
    public static void main(String[] args) {

        int[][] theaterSeating = new int[2][3];
        int value = 1;
        for (int i = 0; i < theaterSeating.length; i++) {
            for (int j = 0; j < theaterSeating[i].length; j++) {
                theaterSeating[i][j] = value;
                value++;
            }
        }
        System.out.println(theaterSeating[1][0]);
    }
}
