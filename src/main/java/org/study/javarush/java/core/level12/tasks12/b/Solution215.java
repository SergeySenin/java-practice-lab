package org.study.javarush.java.core.level12.tasks12.b;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution215 {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        List<String> tasks = new ArrayList<>();

        while (true) {
            String task = console.nextLine();

            if (task.isEmpty()) {
                break;
            }

            tasks.add(task);
        }

        for (int index = tasks.size() - 1; index >= 0; index--) {
            System.out.println(tasks.get(index));
        }
    }
}
