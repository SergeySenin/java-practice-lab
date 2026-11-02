package org.study.javarush.java.core.level17.tasks17.d.temp3;

public class Solution322 {
    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.printNames();
    }
}

class Animal {
    String name = "Животное";
}

class Cat extends Animal {
    String name = "Кошка";

    void printNames() {
        System.out.println("Имя из Cat: " + this.name);
        System.out.println("Имя из Animal: " + super.name);
    }
}
