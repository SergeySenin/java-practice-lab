package org.study.javarush.java.core.level22.tasks22.d.temp3;

public class Solution422 {
    public static void main(String[] args) {

        UserProfile profile = new UserProfile("Анна", 25);

        System.out.println(profile);
    }
}

record UserProfile(String name, int age) {
    @Override
    public String toString() {
        return "Пользователь: " + name + " (" + age + " лет)";
    }
}
