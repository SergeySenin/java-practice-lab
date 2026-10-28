package org.study.javarush.java.core.level15.tasks15.f;

public class Solution291 {
    public static void main(String[] args) {

        UserProfile firstUser = new UserProfile();
        UserProfile secondUser = new UserProfile("Дарья");
    }
}

class UserProfile {
    private String userIdentifier;

    {
        userIdentifier = "DEFAULT_REG_ID";
        System.out.println("Временный ID пользователя присвоен.");
    }

    public UserProfile() {
        System.out.println("Создан профиль без имени.");
    }

    public UserProfile(String initialName) {
        System.out.println("Создан профиль с именем: " + initialName);
    }
}
