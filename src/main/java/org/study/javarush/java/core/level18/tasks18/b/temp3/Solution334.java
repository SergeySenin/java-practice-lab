package org.study.javarush.java.core.level18.tasks18.b.temp3;

public class Solution334 {
    public static void main(String[] args) {

        Employee employee = new Developer();

        employee.work();
    }
}

class Employee {
    void work() {
        System.out.println("Сотрудник работает.");
    }
}

class Developer extends Employee {
    @Override
    void work() {
        System.out.println("Разработчик пишет код.");
    }
}
