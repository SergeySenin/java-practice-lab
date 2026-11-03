package org.study.javarush.java.core.level19.tasks19.c.temp4;

public class Solution359 {
    public static void main(String[] args) {

        Employee[] employees = {
                new Manager("Анна", 100000),
                new Developer("Иван", 500, 160)
        };

        for (Employee employee : employees) {
            System.out.println("Имя: " + employee.getName()
                    + ", зарплата: " + employee.getSalary());
        }
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
    private final double baseSalary;

    public Manager(String name, double baseSalary) {
        super(name);
        this.baseSalary = baseSalary;
    }

    @Override
    public double getSalary() {
        return baseSalary;
    }
}

class Developer extends Employee {
    private final double hourlyRate;
    private final int hoursWorked;

    public Developer(String name, double hourlyRate, int hoursWorked) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double getSalary() {
        return hourlyRate * hoursWorked;
    }
}
