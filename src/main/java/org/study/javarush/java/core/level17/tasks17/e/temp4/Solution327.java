package org.study.javarush.java.core.level17.tasks17.e.temp4;

public class Solution327 {
    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.animalName = "Мурка";

        cat.eat();
        cat.feedMilk();
        cat.purr();
    }
}

class Animal {
    String animalName;

    void eat() {
        System.out.println(animalName + " ест.");
    }
}

class Mammal extends Animal {
    void feedMilk() {
        System.out.println(animalName + " кормит детёнышей молоком.");
    }
}

class Cat extends Mammal {
    @Override
    void eat() {
        System.out.println(animalName + " ест рыбу.");
    }

    void purr() {
        System.out.println(animalName + " мурлычет.");
    }
}
