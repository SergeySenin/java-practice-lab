package org.study.javarush.java.core.level11.tasks11.d;

public class Solution202 {
    public static void main(String[] args) {

        try {
            System.out.println(5 / 0);
        } finally {
            System.out.println("Датчик сообщает: Работа finally завершена. Даже в случае аварии.");
        }
    }
}
