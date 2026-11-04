package org.study.javarush.java.core.level21.tasks21.f.temp2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution409 {
    public static void main(String[] args) {

        List<City> cities = new ArrayList<>();
        cities.add(new City("Нью-Йорк", 8_400_000));
        cities.add(new City("Лондон", 8_900_000));
        cities.add(new City("Париж", 2_100_000));

        Collections.sort(cities);

        for (City city : cities) {
            System.out.println(city);
        }
    }
}
