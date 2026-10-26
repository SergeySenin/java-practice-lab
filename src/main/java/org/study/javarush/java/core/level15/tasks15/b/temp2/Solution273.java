package org.study.javarush.java.core.level15.tasks15.b.temp2;

public class Solution273 {
    public static void main(String[] args) {

        Person person = new Person("Анна", 30);

        System.out.println("Имя: " + person.getMemberName());
        System.out.println("Возраст: " + person.getMemberAge());
    }
}

class Person {
    private String memberName;
    private int memberAge;

    public Person(String memberName, int memberAge) {
        this.memberName = memberName;
        this.memberAge = memberAge;
    }

    public String getMemberName() {
        return memberName;
    }

    public int getMemberAge() {
        return memberAge;
    }
}
