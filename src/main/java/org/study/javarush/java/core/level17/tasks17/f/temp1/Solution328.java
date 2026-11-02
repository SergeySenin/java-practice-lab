package org.study.javarush.java.core.level17.tasks17.f.temp1;

public class Solution328 {
    public static void main(String[] args) {

        Dog dog = new Dog();
    }
}

class Animal {
}

class Robot {
}

class Dog extends Animal {
}

// НАМЕРЕННАЯ ОШИБКА: убрать //, чтобы проверить запрет множественного наследования.
// class RoboDog extends Animal, Robot {
// }
