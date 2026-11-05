package org.study.javarush.java.core.level22.tasks22.c.temp1;

public class Solution416 {
    public static void main(String[] args) {

        Ticket ticket = new Ticket("Ривертон - Нортвуд", 42);

        System.out.println("Маршрут: " + ticket.getRoute());
        System.out.println("Место: " + ticket.getSeatNumber());
    }
}

final class Ticket {
    private final String route;
    private final int seatNumber;

    public Ticket(String route, int seatNumber) {
        this.route = route;
        this.seatNumber = seatNumber;
    }

    public String getRoute() {
        return route;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
}
