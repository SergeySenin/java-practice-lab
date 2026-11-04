package org.study.javarush.java.core.level21.tasks21.f.temp2;

public class City implements Comparable<City> {
    private final String name;
    private final int population;

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    @Override
    public int compareTo(City other) {
        return Integer.compare(this.population, other.population);
    }

    @Override
    public String toString() {
        return name + ": " + population;
    }
}
