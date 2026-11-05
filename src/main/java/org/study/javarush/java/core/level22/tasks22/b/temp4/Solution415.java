package org.study.javarush.java.core.level22.tasks22.b.temp4;

import java.util.HashMap;
import java.util.Map;

public class Solution415 {
    public static void main(String[] args) {

        Map<User, String> userRoles = new HashMap<>();
        userRoles.put(new User("Анна", 1), "администратор");
        userRoles.put(new User("Иван", 2), "гость");

        User searchedUser = new User("Анна", 1);

        System.out.println(userRoles.get(searchedUser));
    }
}

record User(String name, int id) {
}
