package org.study.javarush.java.core.level11.tasks11.g;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final int ACCEPTED_COUNT_INDEX = 0;
    private static final int REJECTED_COUNT_INDEX = 1;
    private static final int TOTAL_PAYOUT_INDEX   = 2;

    public static int validateAndCalculatePayout(String payoutRecord) {
        String[] payoutFields = payoutRecord.split(";", -1);

        if (payoutFields.length != 3) {
            throw new IllegalArgumentException(
                    "Invalid payout record structure: " + payoutRecord
            );
        }

        String payoutId = payoutFields[0].trim();

        if (!payoutId.startsWith("PAY-") || payoutId.length() <= 4) {
            throw new IllegalArgumentException(
                    "Invalid payout identifier: " + payoutId
            );
        }

        int grossAmount = Integer.parseInt(payoutFields[1].trim());
        int platformFee = Integer.parseInt(payoutFields[2].trim());

        if (grossAmount <= 0 || platformFee < 0 || platformFee >= grossAmount) {
            throw new IllegalArgumentException(
                    "Invalid payout values: " + payoutId
            );
        }

        int payableAmount = grossAmount - platformFee;
        return payableAmount;
    }

    public static int[] readPayoutFile(String filePath) throws IOException {
        int[] payoutStatistics = new int[3];

        try (BufferedReader payoutReader = new BufferedReader(new FileReader(filePath))) {
            String payoutRecord;
            int fileLineNumber = 0;

            while ((payoutRecord = payoutReader.readLine()) != null) {
                fileLineNumber++;

                if (payoutRecord.trim().isEmpty()) {
                    continue;
                }

                try {
                    int calculatedPayout = validateAndCalculatePayout(payoutRecord);

                    payoutStatistics[ACCEPTED_COUNT_INDEX]++;
                    payoutStatistics[TOTAL_PAYOUT_INDEX]  += calculatedPayout;

                    System.out.println("Line "    + fileLineNumber + ": ACCEPTED, amount: " + calculatedPayout);

                } catch (NumberFormatException exception) {
                    payoutStatistics[REJECTED_COUNT_INDEX]++;

                    System.out.println("Line "    + fileLineNumber + ": REJECTED - NUMBER_FORMAT");
                    System.out.println("Reason: " + exception.getMessage());

                } catch (IllegalArgumentException exception) {
                    payoutStatistics[REJECTED_COUNT_INDEX]++;

                    System.out.println("Line "    + fileLineNumber + ": REJECTED - VALIDATION");
                    System.out.println("Reason: " + exception.getMessage());
                }
            }
        }

        return payoutStatistics;
    }

    public static int[] runPayoutImport(String filePath) throws IOException {
        System.out.println("IMPORT STARTED: " + filePath);
        return readPayoutFile(filePath);
    }

    public static void main(String[] args) {

        Scanner console      = new Scanner(System.in);
        String filePathInput = console.nextLine();
        String filePath      = filePathInput.trim();

        try {
            int[] importStatistics = runPayoutImport(filePath);

            System.out.println("Accepted:      " + importStatistics[ACCEPTED_COUNT_INDEX]);
            System.out.println("Rejected:      " + importStatistics[REJECTED_COUNT_INDEX]);
            System.out.println("Payable total: " + importStatistics[TOTAL_PAYOUT_INDEX]);

        } catch (IOException exception) {
            System.out.println("IMPORT FAILED: unable to read " + filePath);

        } finally {
            System.out.println("IMPORT ATTEMPT FINISHED");
        }
    }
}
