package org.study.javarush.java.core.level15.tasks15.e;

public class Solution286 {
    public static void main(String[] args) {

        System.out.println(ApplicationConfiguration.APPLICATION_DEFAULT_LANGUAGE);
    }
}

class ApplicationConfiguration {
    public static final String APPLICATION_DEFAULT_LANGUAGE;

    static {
        String language = System.getenv("APP_LANG");

        if (language != null) {
            APPLICATION_DEFAULT_LANGUAGE = language;
        } else {
            APPLICATION_DEFAULT_LANGUAGE = "en";
        }
    }
}
