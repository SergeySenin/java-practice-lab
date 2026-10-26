package org.study.javarush.java.core.level15.tasks15.b.temp1;

public class Solution272 {
    public static void main(String[] args) {

        Person person = new Person();

        /*
        Эти обращения вызовут ошибки компиляции:
        System.out.println(person.memberName);
        System.out.println(person.memberAge);
        */
    }
}

class Person {
    private String memberName;
    private int memberAge;
}
