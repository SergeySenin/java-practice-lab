package org.study.javarush.java.core.level07.tasks07.g;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int athleteCount = 4;

        String[] athleteNotes = new String[athleteCount];
        System.out.println(athleteNotes[0]);
        athleteNotes[0] = "Team captain";
        System.out.println(athleteNotes[0]);

        String[] athleteNames = new String[athleteCount];

        for (int athleteNameIndex = 0; athleteNameIndex < athleteNames.length; athleteNameIndex++) {
            athleteNames[athleteNameIndex] = console.nextLine();
        }

        System.out.println("Athletes: " + athleteNames.length);

        int[] qualifyingScores = new int[athleteCount];

        for (
                int qualifyingScoreIndex = 0;
                qualifyingScoreIndex < qualifyingScores.length;
                qualifyingScoreIndex++
        ) {
            qualifyingScores[qualifyingScoreIndex] = console.nextInt();
        }

        System.out.println("First athlete: " + athleteNames[0]);
        System.out.println("First score: "   + qualifyingScores[0]);
        System.out.println("Last athlete: "  + athleteNames[athleteNames.length - 1]);
        System.out.println("Last score: "    + qualifyingScores[qualifyingScores.length - 1]);

        int qualificationSum = 0;

        for (int qualifyingScore : qualifyingScores) {
            qualificationSum += qualifyingScore;
        }

        double qualificationAverage = (double) qualificationSum / qualifyingScores.length;

        int minimumScore = qualifyingScores[0];
        int maximumScore = qualifyingScores[0];

        for (int qualifyingScoreIndex = 1;
             qualifyingScoreIndex < qualifyingScores.length;
             qualifyingScoreIndex++) {
            if (qualifyingScores[qualifyingScoreIndex] < minimumScore) {
                minimumScore = qualifyingScores[qualifyingScoreIndex];
            }
            if (qualifyingScores[qualifyingScoreIndex] > maximumScore) {
                maximumScore = qualifyingScores[qualifyingScoreIndex];
            }
        }

        for (int reverseScoreIndex = qualifyingScores.length - 1;
             reverseScoreIndex >= 0;
             reverseScoreIndex--) {
            System.out.print(qualifyingScores[reverseScoreIndex]);
            if (reverseScoreIndex > 0) {
                System.out.print(" ");
            }
        }
        System.out.println();

        int[] workingScores = qualifyingScores;
        workingScores[0] += 5;

        System.out.println(Arrays.toString(qualifyingScores));
        System.out.println(Arrays.toString(workingScores));

        int[] qualifyingScoresCopy = Arrays.copyOf(qualifyingScores, qualifyingScores.length);
        qualifyingScoresCopy[0] += 10;

        System.out.println(Arrays.toString(qualifyingScores));
        System.out.println(Arrays.toString(qualifyingScoresCopy));

        int[] sortedQualifyingScores = Arrays.copyOf(qualifyingScores, qualifyingScores.length);
        Arrays.sort(sortedQualifyingScores);

        System.out.println("Original scores: " + Arrays.toString(qualifyingScores));
        System.out.println("Sorted scores: "   + Arrays.toString(sortedQualifyingScores));

        int[] finalistScores = Arrays.copyOfRange(
                sortedQualifyingScores,
                sortedQualifyingScores.length - 2,
                sortedQualifyingScores.length
        );
        System.out.println("Finalist scores: " + Arrays.toString(finalistScores));

        int[] backupQualifyingScores = Arrays.copyOf(qualifyingScores, qualifyingScores.length);
        boolean qualifyingScoresMatchBackup =
                Arrays.equals(qualifyingScores, backupQualifyingScores);
        System.out.println(qualifyingScoresMatchBackup);

        backupQualifyingScores[0]++;
        qualifyingScoresMatchBackup = Arrays.equals(qualifyingScores, backupQualifyingScores);
        System.out.println(qualifyingScoresMatchBackup);

        int disciplineCount = 3;
        int[][] competitionScores = new int[athleteNames.length][disciplineCount];

        for (int athleteIndex = 0; athleteIndex < competitionScores.length; athleteIndex++) {
            for (int disciplineIndex = 0;
                 disciplineIndex < competitionScores[athleteIndex].length;
                 disciplineIndex++) {
                competitionScores[athleteIndex][disciplineIndex] = console.nextInt();
            }
        }

        for (int athleteIndex = 0; athleteIndex < competitionScores.length; athleteIndex++) {
            System.out.print(athleteNames[athleteIndex] + ":");
            for (int disciplineIndex = 0;
                 disciplineIndex < competitionScores[athleteIndex].length;
                 disciplineIndex++) {
                System.out.print(" " + competitionScores[athleteIndex][disciplineIndex]);
            }
            System.out.println();
        }

        int[] athleteTotalScores = new int[athleteNames.length];

        for (int athleteIndex = 0; athleteIndex < competitionScores.length; athleteIndex++) {
            int athleteTotalScore = 0;
            for (int disciplineScore : competitionScores[athleteIndex]) {
                athleteTotalScore += disciplineScore;
            }
            athleteTotalScores[athleteIndex] = athleteTotalScore;
        }

        int winnerIndex = 0;

        for (
                int athleteIndex = 1;
                athleteIndex < athleteTotalScores.length;
                athleteIndex++
        ) {
            if (athleteTotalScores[athleteIndex] > athleteTotalScores[winnerIndex]) {
                winnerIndex = athleteIndex;
            }
        }

        System.out.println("Winner: "       + athleteNames[winnerIndex]);
        System.out.println("Winner score: " + athleteTotalScores[winnerIndex]);

        System.out.println(Arrays.deepToString(competitionScores));

        int[][] backupCompetitionScores = new int[competitionScores.length][];

        for (int athleteIndex = 0; athleteIndex < competitionScores.length; athleteIndex++) {
            backupCompetitionScores[athleteIndex] = Arrays.copyOf(
                    competitionScores[athleteIndex], competitionScores[athleteIndex].length
            );
        }

        boolean shallowCompetitionScoresMatch =
                Arrays.equals(competitionScores, backupCompetitionScores);
        boolean deepCompetitionScoresMatch =
                Arrays.deepEquals(competitionScores, backupCompetitionScores);

        System.out.println(shallowCompetitionScoresMatch);
        System.out.println(deepCompetitionScoresMatch);

        int[][] extraAttemptScores = new int[athleteNames.length][];
        extraAttemptScores[0] = new int[] {5, 7};
        extraAttemptScores[1] = new int[] {4, 6, 8, 10};
        extraAttemptScores[2] = new int[] {9};
        extraAttemptScores[3] = new int[] {3, 5, 7};

        int totalExtraAttemptScore = 0;

        for (int[] athleteAttemptScores : extraAttemptScores) {
            for (int attemptScore : athleteAttemptScores) {
                totalExtraAttemptScore += attemptScore;
            }
        }

        for (int athleteIndex = 0; athleteIndex < extraAttemptScores.length; athleteIndex++) {
            System.out.println(
                    athleteNames[athleteIndex]
                            + " attempts: "
                            + extraAttemptScores[athleteIndex].length
            );
        }

        String[] awardStatuses = new String[athleteNames.length];
        Arrays.fill(awardStatuses, "PENDING");
        System.out.println(Arrays.toString(awardStatuses));

        awardStatuses[winnerIndex] = "GOLD";
        System.out.println(Arrays.toString(awardStatuses));

        System.out.println("Athletes: "              + athleteNames.length);
        System.out.println("Qualification scores: "  + Arrays.toString(qualifyingScores));
        System.out.println("Qualification sum: "     + qualificationSum);
        System.out.println("Qualification average: " + qualificationAverage);
        System.out.println("Minimum score: "         + minimumScore);
        System.out.println("Maximum score: "         + maximumScore);
        System.out.println("Sorted scores: "         + Arrays.toString(sortedQualifyingScores));
        System.out.println("Finalist scores: "       + Arrays.toString(finalistScores));
        System.out.println("Competition scores: "    + Arrays.deepToString(competitionScores));
        System.out.println("Total scores: "          + Arrays.toString(athleteTotalScores));
        System.out.println("Winner: "                + athleteNames[winnerIndex]);
        System.out.println("Winner score: "          + athleteTotalScores[winnerIndex]);
        System.out.println("Extra attempts sum: "    + totalExtraAttemptScore);
        System.out.println("Award statuses: "        + Arrays.toString(awardStatuses));
    }
}
