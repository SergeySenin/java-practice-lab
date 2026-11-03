package org.study.javarush.java.core.level18.tasks18.c.temp3;

public class Solution338 {
    public static void main(String[] args) {

        Greetings greetings = new Greetings();
        greetings.sayHello("Алекс");
        greetings.sayHello("Джон", "Доу");
    }
}

class Greetings {
    void sayHello(String firstName) {
        System.out.println("Hello, " + firstName + "!");
    }

    void sayHello(String firstName, String lastName) {
        System.out.println("Hello, " + firstName + " " + lastName + "!");
    }
}
