package org.study.javarush.java.core.level17.tasks17.c.temp3;

public class Solution318 {
    public static void main(String[] args) {

        Parent person = new Child();

        person.greet();
    }
}

class Parent {
    public void greet() {
        System.out.println("Hello from Parent");
    }
}

class Child extends Parent {
    @Override
    public void greet() {
        System.out.println("Hello from Child");
    }
}
