package org.study.javarush.java.core.level22.tasks22.b.temp3;

public class Solution414 {
    public static void main(String[] args) {

        City first = new City("Прага", 1300000);
        City second = new City("Прага", 1300000);

        System.out.println(first.equals(second));
    }
}

record City(String name, int population) {
}
