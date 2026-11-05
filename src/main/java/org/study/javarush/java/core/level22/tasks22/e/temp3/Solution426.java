package org.study.javarush.java.core.level22.tasks22.e.temp3;

public class Solution426 {
    public static void main(String[] args) {

        Person person = new Person("Иван", 25);

        System.out.println(person.greeting());
    }
}

record Person(String name, int age) {
    public static final String SPECIES = "Homo sapiens";

    public String greeting() {
        return "Привет, меня зовут " + name + ", мне " + age + " лет. Я — " + SPECIES;
    }
}
