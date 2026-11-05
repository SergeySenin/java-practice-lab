package org.study.javarush.java.core.level22.tasks22.f.temp4;

public class Solution431 {
    public static void main(String[] args) {

        MutableProfile mutableProfile = new MutableProfile("Анна", 20);

        System.out.println(mutableProfile.getName() + ", " + mutableProfile.getAge());

        mutableProfile.setName("Мария");
        mutableProfile.setAge(21);

        System.out.println(mutableProfile.getName() + ", " + mutableProfile.getAge());

        FixedProfile fixedProfile = new FixedProfile("Иван", 30);

        System.out.println(fixedProfile.name() + ", " + fixedProfile.age());

        // fixedProfile.name = "Пётр";    // Ошибка компиляции: компонент record является private final.
        // fixedProfile.setName("Пётр");  // Ошибка компиляции: сеттер не объявлен.
    }
}

class MutableProfile {
    private String name;
    private int age;

    public MutableProfile(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

record FixedProfile(String name, int age) {
}
