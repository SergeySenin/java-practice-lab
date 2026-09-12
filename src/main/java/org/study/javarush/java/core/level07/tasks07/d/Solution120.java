package org.study.javarush.java.core.level07.tasks07.d;

public class Solution120 {
    public static void main(String[] args) {

        int[][] theaterSeating = new int[2][3];
        int seatNumber = 1;

        for (int rowIndex = 0; rowIndex < theaterSeating.length; rowIndex++) {
            for (int seatIndex = 0; seatIndex < theaterSeating[rowIndex].length; seatIndex++) {
                theaterSeating[rowIndex][seatIndex] = seatNumber;
                seatNumber++;
            }
        }

        System.out.println(theaterSeating[1][0]);
    }
}
