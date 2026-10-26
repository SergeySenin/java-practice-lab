package org.study.javarush.java.core.level15.tasks15.b.temp3;

public class Solution274 {
    public static void main(String[] args) {

        Person person = new Person("Иван", 25);

        person.setMemberAge(-5);
        System.out.println("Текущий возраст: " + person.getMemberAge());

        person.setMemberAge(35);
        System.out.println("Текущий возраст: " + person.getMemberAge());
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

    public void setMemberName(String newName) {
        this.memberName = newName;
    }

    public void setMemberAge(int newAge) {
        if (newAge < 0) {
            System.out.println("Ошибка: Возраст не может быть отрицательным. Значение не изменено.");
            return;
        }

        this.memberAge = newAge;
    }
}
