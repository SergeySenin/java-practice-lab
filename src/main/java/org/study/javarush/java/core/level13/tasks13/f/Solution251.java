package org.study.javarush.java.core.level13.tasks13.f;

import java.time.LocalDate;
import java.time.Period;

public class Solution251 {
    public static void main(String[] args) {

        LocalDate constructionDate = LocalDate.of(2000, 3, 20);
        LocalDate today = LocalDate.now();

        Period buildingAgePeriod = Period.between(constructionDate, today);

        int years = buildingAgePeriod.getYears();
        int months = buildingAgePeriod.getMonths();
        int days = buildingAgePeriod.getDays();

        System.out.println("Возраст: " + years + " лет, " + months + " месяцев, " + days + " дней");
    }
}
