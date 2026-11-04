package org.study.javarush.java.core.level19.tasks19.d.temp3;

public class Solution362 {
    public static void main(String[] args) {

        Manager manager = new Manager("Ivan", 50000);

        System.out.println(manager.getName());
        System.out.println(manager.getSalary());
    }
}

abstract class Employee {
    private final String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getSalary();
}

class Manager extends Employee {
    private final double salary;

    public Manager(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
