package org.study.javarush.java.core.level22.tasks22.c.temp2;

public class Solution417 {
    public static void main(String[] args) {

        HistoricalPerson person = new HistoricalPerson("Леонардо да Винчи", 67);

        System.out.println(person.name());
        System.out.println(person.age());

        // person.name = "Другое имя";    // Ошибка компиляции: компонент record является private final.
        // person.setName("Другое имя");  // Ошибка компиляции: сеттер не объявлен.
    }
}

record HistoricalPerson(String name, int age) {
}
