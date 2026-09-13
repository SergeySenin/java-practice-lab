package org.study.javarush.java.core.level08.tasks08.f;

public class Solution148 {
    public static void main(String[] args) {

        VillageResident newVillager = new VillageResident();

        newVillager.residentName = "Иван";

        System.out.println(newVillager.residentName);
    }
}

class VillageResident {
    public String residentName;
}
