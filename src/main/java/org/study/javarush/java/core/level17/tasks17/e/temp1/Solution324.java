package org.study.javarush.java.core.level17.tasks17.e.temp1;

public class Solution324 {
    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.petName = "Бобик";
        dog.eat();
    }
}

class Animal {
    String petName;

    void eat() {
        System.out.println(petName + " ест.");
    }
}

class Dog extends Animal {
}
