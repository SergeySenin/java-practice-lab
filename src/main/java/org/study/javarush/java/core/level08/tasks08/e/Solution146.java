package org.study.javarush.java.core.level08.tasks08.e;

public class Solution146 {
    public static void main(String[] args) {

        int[] playerSquad = {7, 9};

        swapPlayerNumbers(playerSquad);

        System.out.println(playerSquad[0] + " " + playerSquad[1]);
    }

    public static void swapPlayerNumbers(int[] teamLineup) {
        int firstPlayerNumber;
        firstPlayerNumber = teamLineup[0];
        teamLineup[0] = teamLineup[1];
        teamLineup[1] = firstPlayerNumber;
    }
}
