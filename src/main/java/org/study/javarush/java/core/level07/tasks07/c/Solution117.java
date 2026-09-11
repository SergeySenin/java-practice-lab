package org.study.javarush.java.core.level07.tasks07.c;

import java.util.Scanner;

public class Solution117 {
    public static void main(String[] args) {

        String[] favoriteMovies = new String[3];
        Scanner console = new Scanner(System.in);
        for (int i = 0; i < favoriteMovies.length; i++) {
            favoriteMovies[i] = console.nextLine();
        }
        for (int i = favoriteMovies.length - 1; i >= 0; i--) {
            System.out.println(favoriteMovies[i]);
        }
    }
}
