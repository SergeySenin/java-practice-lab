package org.study.javarush.java.core.level15.tasks15.f.temp1;

public class ApplicationModule {
    static String moduleStatusMessage;

    static {
        moduleStatusMessage = "Приложение: Главный модуль готов к работе!";
        System.out.println(moduleStatusMessage);
    }
}
