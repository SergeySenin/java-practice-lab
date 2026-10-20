package org.study.javarush.java.core.level12.tasks12.c;

import java.util.HashMap;
import java.util.Map;

public class Solution219 {
    public static void main(String[] args) {

        String textContent = "java core java map";
        String[] words = textContent.split(" ");

        Map<String, Integer> wordCounts = new HashMap<>();

        // 1. containsKey() + if-else
        // 1.1. Классический for

        for (int index = 0; index < words.length; index++) {
            String word = words[index];

            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }

        // 1. containsKey() + if-else
        // 1.2. Улучшенный for-each

        /*
        for (String word : words) {
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }
        */

        // 2. get() + null + if-else
        // 2.1. Классический for

        /*
        for (int index = 0; index < words.length; index++) {
            String word = words[index];

            Integer previousCount = wordCounts.get(word);

            if (previousCount == null) {
                wordCounts.put(word, 1);
            } else {
                wordCounts.put(word, previousCount + 1);
            }
        }
        */

        // 2. get() + null + if-else
        // 2.2. Улучшенный for-each

        /*
        for (String word : words) {
            Integer previousCount = wordCounts.get(word);

            if (previousCount == null) {
                wordCounts.put(word, 1);
            } else {
                wordCounts.put(word, previousCount + 1);
            }
        }
        */

        // 3. get() + тернарный оператор
        // 3.1. Классический for

        /*
        for (int index = 0; index < words.length; index++) {
            String word = words[index];

            Integer previousCount = wordCounts.get(word);

            wordCounts.put(word, previousCount == null ? 1 : previousCount + 1);
        }
        */

        // 3. get() + тернарный оператор
        // 3.2. Улучшенный for-each

        /*
        for (String word : words) {
            Integer previousCount = wordCounts.get(word);

            wordCounts.put(word, previousCount == null ? 1 : previousCount + 1);
        }
        */

        // 4. getOrDefault() + put()
        // 4.1. Классический for

        /*

        for (int index = 0; index < words.length; index++) {
            String word = words[index];

            int currentCount = wordCounts.getOrDefault(word, 0);

            wordCounts.put(word, currentCount + 1);
        }
        */

        // 4. getOrDefault() + put()
        // 4.2. Улучшенный for-each

        /*
        for (String word : words) {
            int currentCount = wordCounts.getOrDefault(word, 0);

            wordCounts.put(word, currentCount + 1);
        }
        */

        // 1. entrySet() — перебор пар ключ-значение
        // 1.1. Предпочтительный способ

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 2. keySet() + get() — перебор ключей и получение значений
        // 2.1. Альтернативный способ для практики

        /*
        for (String word : wordCounts.keySet()) {
            System.out.println(word + ": " + wordCounts.get(word));
        }
        */
    }
}
