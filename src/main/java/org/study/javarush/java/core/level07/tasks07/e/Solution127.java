package org.study.javarush.java.core.level07.tasks07.e;

public class Solution127 {
    public static void main(String[] args) {

        int[][] zoneTemperatures = new int[][] {
                new int[] {22, 25, 20},
                new int[] {25, 25},
                new int[] {22, 20, 22, 20}
        };
        int x = zoneTemperatures[0][0];
        for (int i = 0; i < zoneTemperatures.length; i++) {
            for (int j = 0; j < zoneTemperatures[i].length; j++) {
                if (x < zoneTemperatures[i][j]) {
                    x = zoneTemperatures[i][j];
                }
            }
        }
        System.out.println(x);
    }
}
