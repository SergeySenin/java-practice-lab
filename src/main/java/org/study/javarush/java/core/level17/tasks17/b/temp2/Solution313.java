package org.study.javarush.java.core.level17.tasks17.b.temp2;

public class Solution313 {
    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.petName = "Шарик";

        dog.sleep();
        dog.bark();
    }
}

class Animal {
    String petName;

    void sleep() {
        System.out.println(petName + " спит.");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println(petName + " говорит: Гав!");
    }
}
