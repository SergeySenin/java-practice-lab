package org.study.javarush.java.core.level16.tasks16.b;

public class Solution295 {
    public static void main(String[] args) {

        House house = new House("Sunny Valley Lane");
        House.Room room = house.new Room("Master Bedroom");

        room.printAddresses();
    }
}

class House {
    private String houseAddress;

    public House(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    class Room {
        private String roomIdentifier;

        public Room(String roomIdentifier) {
            this.roomIdentifier = roomIdentifier;
        }

        public void printAddresses() {
            System.out.println(this.roomIdentifier);
            System.out.println(House.this.houseAddress);
        }
    }
}
