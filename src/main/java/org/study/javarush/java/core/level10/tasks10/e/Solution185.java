package org.study.javarush.java.core.level10.tasks10.e;

public class Solution185 {
    public static void main(String[] args) {

        Season season = Season.SUMMER;

        switch (season) {
            case WINTER:
                System.out.println("Пора кататься на лыжах!");
                break;
            case SPRING:
                System.out.println("Весна — время пробуждения!");
                break;
            case SUMMER:
                System.out.println("Лето — время отпусков!");
                break;
            case AUTUMN:
                System.out.println("Осень — время листопада!");
                break;
        }
    }
}

enum Season {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN
}
