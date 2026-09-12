package org.study.javarush.java.core.level07.tasks07.d;

public class Solution122 {
    public static void main(String[] args) {

        int[][] warehouseInventory = new int[3][4];
        int inventoryNumber = 1;

        for (int rowIndex = 0; rowIndex < warehouseInventory.length; rowIndex++) {
            for (int columnIndex = 0;
                 columnIndex < warehouseInventory[rowIndex].length;
                 columnIndex++) {

                warehouseInventory[rowIndex][columnIndex] = inventoryNumber;
                inventoryNumber++;
            }
        }

        System.out.println(warehouseInventory[1][2]);
    }
}
