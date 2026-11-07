package org.study.javarush.java.core.level22.tasks22.c.temp2;

public class Solution417 {
    public static void main(String[] args) {

        HistoricalPerson person = new HistoricalPerson("Леонардо да Винчи", 67);

        System.out.println(person.name());
        System.out.println(person.age());

        // person.name = "Другое имя";
        // person.setName("Другое имя");
    }
}

record HistoricalPerson(String name, int age) {
}
