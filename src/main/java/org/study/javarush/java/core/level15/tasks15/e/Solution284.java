package org.study.javarush.java.core.level15.tasks15.e;

public class Solution284 {
    public static void main(String[] args) {

        System.out.println(ApplicationMetrics.getActiveUserCount());
    }
}

class ApplicationMetrics {
    private static int activeUserCount = 10;

    public static int getActiveUserCount() {
        return activeUserCount;
    }
}
