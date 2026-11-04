package org.study.javarush.java.core.level20.tasks20.d.temp2;

import java.io.Serializable;

public class Solution381 {
    public static void main(String[] args) {

        User user = new User("Анна");

        System.out.println(user.getName());
    }
}

interface Nameable {
    String getName();
}

class User implements Nameable, Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
