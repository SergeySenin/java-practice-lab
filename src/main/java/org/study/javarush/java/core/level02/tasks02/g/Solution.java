package org.study.javarush.java.core.level02.tasks02.g;

import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        console.useLocale(Locale.forLanguageTag("ru-RU"));

        String passengerNameInput = console.nextLine();
        String emailInput = console.nextLine();
        String departureCityInput = console.nextLine();
        String arrivalCityInput = console.nextLine();
        String ticketPriceText = console.nextLine();
        String travelMinutesText = console.nextLine();

        int availableSeatCount = console.nextInt();
        int soldTicketCount = console.nextInt();
        double routeDistanceKilometers = console.nextDouble();

        byte carriageNumber = 7;

        String passengerName = passengerNameInput.trim();
        int passengerNameLength = passengerName.length();

        String email = emailInput.trim();
        email = email.toLowerCase();

        String departureCity = departureCityInput.trim();
        String arrivalCity = arrivalCityInput.trim();

        String routeName = departureCity + " - " + arrivalCity;

        String routeDisplayName = routeName;
        routeDisplayName = routeDisplayName.toUpperCase();

        int ticketPrice = Integer.parseInt(ticketPriceText);
        int totalTravelMinutes = Integer.parseInt(travelMinutesText);

        int travelHours, remainingTravelMinutes;
        travelHours = totalTravelMinutes / 60;
        remainingTravelMinutes = totalTravelMinutes % 60;

        soldTicketCount++;
        availableSeatCount--;

        String ticketPriceAsText = String.valueOf(ticketPrice);

        int ticketNumber = 1000;
        ticketNumber++;

        String ticketCodePrefix = "";
        String ticketCode = ticketCodePrefix + "TRAIN-" + ticketNumber;

        String ticketFilePath = "C:\\Tickets\\" + ticketCode + ".txt";

        String electronicTicket =
                "\"RAILWAY TICKET\""                                               + "\n"
                        + "\tCode: "            + ticketCode                       + "\n"
                        + "\tPassenger: "       + passengerName                    + "\n"
                        + "\tEmail: "           + email                            + "\n"
                        + "\tName length: "     + passengerNameLength              + "\n"
                        + "\tRoute: "           + routeName                        + "\n"
                        + "\tRoute display: "   + routeDisplayName                 + "\n"
                        + "\tCarriage: "        + carriageNumber                   + "\n"
                        + "\tDistance: "        + routeDistanceKilometers + " km"  + "\n"
                        + "\tTravel time: "     + travelHours             + " h "
                                                + remainingTravelMinutes  + " min" + "\n"
                        + "\tPrice: "           + ticketPriceAsText                + "\n"
                        + "\tSold tickets: "    + soldTicketCount                  + "\n"
                        + "\tAvailable seats: " + availableSeatCount               + "\n"
                        + "\tFile: "            + ticketFilePath;

        System.out.println(electronicTicket);

        console.close();
    }
}
