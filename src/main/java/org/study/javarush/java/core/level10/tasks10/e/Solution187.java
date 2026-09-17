package org.study.javarush.java.core.level10.tasks10.e;

public class Solution187 {
    public static void main(String[] args) {

        CelestialBody currentPlanet = CelestialBody.MARS;

        System.out.println(currentPlanet.name());

        int planetOrdinal = currentPlanet.ordinal();
        System.out.println(planetOrdinal);

        String targetPlanetName = "JUPITER";
        CelestialBody targetPlanet = CelestialBody.valueOf(targetPlanetName);

        System.out.println(targetPlanet);
    }
}

enum CelestialBody {
    EARTH,
    MARS,
    JUPITER
}
