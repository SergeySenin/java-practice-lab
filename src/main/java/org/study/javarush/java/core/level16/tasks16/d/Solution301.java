package org.study.javarush.java.core.level16.tasks16.d;

public class Solution301 {
    public static void main(String[] args) {

        Communicator communicator = new Communicator() {

            @Override
            public void greet() {
                System.out.println("Привет, мир!");
            }
        };

        communicator.greet();
    }
}

interface Communicator {
    void greet();
}
