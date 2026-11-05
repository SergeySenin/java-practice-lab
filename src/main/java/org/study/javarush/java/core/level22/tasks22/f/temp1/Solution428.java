package org.study.javarush.java.core.level22.tasks22.f.temp1;

public class Solution428 {
    public static void main(String[] args) {

        Address address = new Address("Ривертон", "Центральная, 1");
        Company company = new Company("JavaRush", address);

        System.out.println("Компания: " + company.name());
        System.out.println("Город: " + company.address().city());
        System.out.println("Улица: " + company.address().street());
    }
}

record Address(String city, String street) {
}

record Company(String name, Address address) {
}
