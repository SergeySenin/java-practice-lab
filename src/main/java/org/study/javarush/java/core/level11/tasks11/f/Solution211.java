package org.study.javarush.java.core.level11.tasks11.f;

public class Solution211 {
    public static void main(String[] args) {

        processInitialRequest();
    }

    public static void processInitialRequest() {

        handleIntermediateStep();
    }

    public static void handleIntermediateStep() {

        executeFinalAction();
    }

    public static void executeFinalAction() {

        int[] temporaryData = new int[2];

        System.out.println(temporaryData[10]);
    }
}
