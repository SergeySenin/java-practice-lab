package org.study.javarush.java.core.level15.tasks15.g;

public class InitializationProbe {

    private        int initializationStage = 1;
    private static int createdProbeCount;

    public static final String DEFAULT_LANGUAGE;

    static {
        DEFAULT_LANGUAGE = "en";
        System.out.println("TRACE STATIC 1");
    }

    static {
        System.out.println("TRACE STATIC 2");
    }

    {
        System.out.println("TRACE INSTANCE A:  " + initializationStage);
        initializationStage = 2;
    }

    {
        System.out.println("TRACE INSTANCE B:  " + initializationStage);
    }

    public InitializationProbe() {
        createdProbeCount++;
        System.out.println("TRACE CONSTRUCTOR: " + initializationStage);
    }

    public static int getCreatedProbeCount() {
        return createdProbeCount;
    }
}
