package org.study.javarush.java.core.level07.tasks07.c;

import java.util.Scanner;

public class Solution117 {
    public static void main(String[] args) {

        String[] favoriteMovies = new String[3];
        Scanner console = new Scanner(System.in);

        for (int movieIndex = 0; movieIndex < favoriteMovies.length; movieIndex++) {
            favoriteMovies[movieIndex] = console.nextLine();
        }

        for (int movieIndex = favoriteMovies.length - 1; movieIndex >= 0; movieIndex--) {
            System.out.println(favoriteMovies[movieIndex]);
        }
    }
}
