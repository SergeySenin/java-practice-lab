package org.study.javarush.java.core.level17.tasks17.b.temp1;

public class Solution312 {
    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.petName = "Барсик";

        cat.eat();
        cat.meow();
    }
}

class Animal {
    String petName;

    void eat() {
        System.out.println(petName + " ест.");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println(petName + " говорит: Мяу!");
    }
}
