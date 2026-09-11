package org.study.javarush.java.core.level07.tasks07.d;

public class Solution122 {
    public static void main(String[] args) {

        int[][] warehouseInventory = new int[3][4];
        int value = 1;
        for (int i = 0; i < warehouseInventory.length; i++) {
            for (int j = 0; j < warehouseInventory[i].length; j++) {
                warehouseInventory[i][j] = value;
                value++;
            }
        }
        System.out.println(warehouseInventory[1][2]);
    }
}
