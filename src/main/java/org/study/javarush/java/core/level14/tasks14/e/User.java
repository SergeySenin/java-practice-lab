package org.study.javarush.java.core.level14.tasks14.e;

public class User {
    String userName;
    int userAge;

    public User(String userName) {
        this.userName = userName;
        this.userAge = 0;
    }

    public User() {
        this("Unknown");
    }
}
