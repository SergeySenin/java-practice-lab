package org.study.javarush.java.core.level22.tasks22.e.temp1;

public class Solution424 {
    public static void main(String[] args) {

        Temperature temperature = Temperature.fromFahrenheit(212);

        System.out.println(temperature.celsius());
    }
}

record Temperature(double celsius) {
    public static Temperature fromFahrenheit(double fahrenheit) {
        return new Temperature((fahrenheit - 32) * 5.0 / 9.0);
    }
}
