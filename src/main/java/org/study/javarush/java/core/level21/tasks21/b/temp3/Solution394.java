package org.study.javarush.java.core.level21.tasks21.b.temp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution394 {
    public static void main(String[] args) {

        List<Integer> scores = new ArrayList<>(Arrays.asList(-5, 3, -2, 7, 0));
        Comparator<Integer> byAbsoluteValue
                = (first, second) -> Long.compare(Math.abs((long) first), Math.abs((long) second));

        scores.sort(byAbsoluteValue);

        System.out.println(scores);
    }
}
