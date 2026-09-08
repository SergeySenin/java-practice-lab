package org.study.javarush.java.core.level06.tasks06.e;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Solution107 {
    public static void main(String[] args) {

        double totalGlobalSales = 12345678.9012;

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(Locale.US);
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);

        System.out.println(decimalFormat.format(totalGlobalSales));
    }
}
