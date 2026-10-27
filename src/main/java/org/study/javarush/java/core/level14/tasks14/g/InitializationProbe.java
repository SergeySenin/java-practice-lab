package org.study.javarush.java.core.level14.tasks14.g;

public class InitializationProbe {

    private int    defaultCounter;
    private String defaultLabel;
    private int    initializationStage = 1;

    {
        System.out.println("INIT BLOCK 1: stage = " + initializationStage);
        initializationStage = 5;
    }

    {
        System.out.println("INIT BLOCK 2: stage = " + initializationStage);
    }

    public InitializationProbe() {
        System.out.println("CONSTRUCTOR:  stage = " + initializationStage);
    }

    public int getDefaultCounter() {
        return defaultCounter;
    }

    public String getDefaultLabel() {
        return defaultLabel;
    }

    public int getInitializationStage() {
        return initializationStage;
    }
}
