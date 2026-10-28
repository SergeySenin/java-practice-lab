package org.study.javarush.java.core.level15.tasks15.c;

public class Solution276 {
    public static void main(String[] args) {

        UserCard userCard = new UserCard("Элис");

        System.out.println(userCard.getUserName());
    }
}

class UserCard {
    private String userName;

    public UserCard(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
