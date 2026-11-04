package org.study.javarush.java.core.level20.tasks20.b.temp1;

public class Solution372 {
    public static void main(String[] args) {
        Person person = new Person();
        person.greet();
    }
}

interface Greetable {
    void greet();
}

class Person implements Greetable {
    @Override
    public void greet() {
        System.out.println("Hello!");
    }
}
