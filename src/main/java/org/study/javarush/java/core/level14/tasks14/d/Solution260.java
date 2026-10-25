package org.study.javarush.java.core.level14.tasks14.d;

public class Solution260 {
    public static void main(String[] args) {

        Cat myCat = new Cat();

        myCat.catName = "Барсик";
        myCat.catAge = 3;

        System.out.println("Имя: " + myCat.catName + ", возраст: " + myCat.catAge);
    }
}

class Cat {
    String catName;
    int catAge;
}
