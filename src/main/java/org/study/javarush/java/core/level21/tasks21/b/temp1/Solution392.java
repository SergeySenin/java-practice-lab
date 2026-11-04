package org.study.javarush.java.core.level21.tasks21.b.temp1;

public class Solution392 {
    public static void main(String[] args) {

        Runnable action = () -> System.out.println("Лямбда без параметров!");

        action.run();
    }
}
