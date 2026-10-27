package org.study.javarush.java.core.level07.tasks07.g;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        // Данные спортсменов
        int      athleteCount = 4;
        String[] athleteNames = new String[athleteCount];
        String[] athleteNotes = new String[athleteCount];

        // В новом String[] каждый элемент равен null: строка ещё не присвоена.
        // Сначала выводим значение по умолчанию, затем записываем пометку о капитане.
        System.out.println(athleteNotes[0]);

        athleteNotes[0] = "Team captain";
        System.out.println(athleteNotes[0]);

        // Имена читаем целыми строками, чтобы сохранить возможные пробелы внутри имени.
        for (
                int athleteNameIndex = 0;
                athleteNameIndex < athleteNames.length;
                athleteNameIndex++
        ) {
            athleteNames[athleteNameIndex] = console.nextLine();
        }

        System.out.println("Athletes: " + athleteNames.length);

        // Квалификационные баллы: индекс связывает результат с именем спортсмена.
        int[] qualifyingScores = new int[athleteCount];

        for (
                int qualifyingScoreIndex = 0;
                qualifyingScoreIndex < qualifyingScores.length;
                qualifyingScoreIndex++
        ) {
            qualifyingScores[qualifyingScoreIndex] = console.nextInt();
        }

        // Первый индекс равен 0, последний — длине массива минус один.
        System.out.println("First athlete: " + athleteNames[0]);
        System.out.println("First score:   " + qualifyingScores[0]);

        System.out.println("Last athlete:  " + athleteNames[athleteNames.length - 1]);
        System.out.println("Last score:    " + qualifyingScores[qualifyingScores.length - 1]);

        // Статистика квалификации до начисления бонуса
        // Сумма, среднее, минимум и максимум сохранятся в этих переменных.
        // Позднейшее изменение массива не пересчитает их автоматически.
        int qualificationSum = 0;

        for (int qualifyingScore : qualifyingScores) {
            qualificationSum += qualifyingScore;
        }

        // Приведение к double выполняется до деления, чтобы сохранить дробную часть.
        double qualificationAverage = (double) qualificationSum / qualifyingScores.length;

        // Начинаем с первого балла: такой поиск работает и для отрицательных результатов.
        // Первый элемент уже учтён, поэтому обход начинается с индекса 1.
        int minimumScore = qualifyingScores[0];
        int maximumScore = qualifyingScores[0];

        for (
                int qualifyingScoreIndex = 1;
                qualifyingScoreIndex < qualifyingScores.length;
                qualifyingScoreIndex++
        ) {
            if (qualifyingScores[qualifyingScoreIndex] < minimumScore) {
                minimumScore = qualifyingScores[qualifyingScoreIndex];
            }

            if (qualifyingScores[qualifyingScoreIndex] > maximumScore) {
                maximumScore = qualifyingScores[qualifyingScoreIndex];
            }
        }

        // Обратный вывод меняет направление обхода.
        // Порядок элементов в самом массиве остаётся прежним.
        for (
                int reverseScoreIndex = qualifyingScores.length - 1;
                reverseScoreIndex >= 0;
                reverseScoreIndex--
        ) {
            System.out.print(qualifyingScores[reverseScoreIndex]);

            // Пробел разделяет числа. После последнего числа нужен только перевод строки.
            if (reverseScoreIndex > 0) {
                System.out.print(" ");
            }
        }

        System.out.println();

        // Общая ссылка на массив
        // workingScores и qualifyingScores указывают на один объект.
        // Бонус через workingScores изменит балл и при обращении через qualifyingScores.
        int[] workingScores = qualifyingScores;

        workingScores[0] += 5;

        System.out.println(Arrays.toString(qualifyingScores));
        System.out.println(Arrays.toString(workingScores));

        // Независимая копия
        // Arrays.copyOf создаёт отдельный int[] с текущими баллами, уже после бонуса.
        int[] qualifyingScoresCopy = Arrays.copyOf(
                qualifyingScores,
                qualifyingScores.length
        );

        qualifyingScoresCopy[0] += 10;

        System.out.println(Arrays.toString(qualifyingScores));
        System.out.println(Arrays.toString(qualifyingScoresCopy));

        // Сортировка отдельной копии сохраняет исходный порядок спортсменов и их баллов.
        int[] sortedQualifyingScores = Arrays.copyOf(
                qualifyingScores,
                qualifyingScores.length
        );

        Arrays.sort(sortedQualifyingScores);

        System.out.println("Original scores: " + Arrays.toString(qualifyingScores));
        System.out.println("Sorted scores: "   + Arrays.toString(sortedQualifyingScores));

        // Два наибольших результата находятся в конце отсортированного массива.
        // В copyOfRange начальный индекс включается в диапазон, конечный — не включается.
        int[] finalistScores = Arrays.copyOfRange(
                sortedQualifyingScores,
                sortedQualifyingScores.length - 2,
                sortedQualifyingScores.length
        );

        System.out.println("Finalist scores: " + Arrays.toString(finalistScores));

        // Сравнение содержимого с резервной копией: до изменения и после него.
        int[] backupQualifyingScores = Arrays.copyOf(
                qualifyingScores,
                qualifyingScores.length
        );

        boolean qualifyingScoresMatchBackup = Arrays.equals(
                qualifyingScores,
                backupQualifyingScores
        );

        System.out.println(qualifyingScoresMatchBackup);


        backupQualifyingScores[0]++;

        qualifyingScoresMatchBackup = Arrays.equals(
                qualifyingScores,
                backupQualifyingScores
        );

        System.out.println(qualifyingScoresMatchBackup);

        // Результаты по дисциплинам
        // Строка таблицы соответствует спортсмену, столбец — отдельной дисциплине.
        int disciplineCount = 3;
        int[][] competitionScores = new int[athleteNames.length][disciplineCount];

        for (
                int athleteIndex = 0;
                athleteIndex < competitionScores.length;
                athleteIndex++
        ) {
            for (
                    int disciplineIndex = 0;
                    disciplineIndex < competitionScores[athleteIndex].length;
                    disciplineIndex++
            ) {
                competitionScores[athleteIndex][disciplineIndex] = console.nextInt();
            }
        }

        // Одна строка вывода: имя спортсмена, все его баллы, затем перевод строки.
        // %-8s выравнивает подпись влево; имя длиннее восьми символов не обрезается.
        for (
                int athleteIndex = 0;
                athleteIndex < competitionScores.length;
                athleteIndex++
        ) {
            System.out.print(String.format("%-8s", athleteNames[athleteIndex] + ":"));

            for (
                    int disciplineIndex = 0;
                    disciplineIndex < competitionScores[athleteIndex].length;
                    disciplineIndex++
            ) {
                System.out.print(" " + competitionScores[athleteIndex][disciplineIndex]);
            }

            System.out.println();
        }

        // Итоговые баллы спортсменов
        // Для каждой строки начинаем сумму с нуля и сохраняем результат под тем же индексом.
        int[] athleteTotalScores = new int[athleteNames.length];

        for (
                int athleteIndex = 0;
                athleteIndex < competitionScores.length;
                athleteIndex++
        ) {
            int athleteTotalScore = 0;

            for (int disciplineScore : competitionScores[athleteIndex]) {
                athleteTotalScore += disciplineScore;
            }

            athleteTotalScores[athleteIndex] = athleteTotalScore;
        }

        // Победитель: сначала считаем лучшим первого спортсмена.
        // Строгое сравнение > сохраняет первого из спортсменов с одинаковым лучшим результатом.
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

        System.out.println("Winner:       " + athleteNames[winnerIndex]);
        System.out.println("Winner score: " + athleteTotalScores[winnerIndex]);

        // deepToString показывает содержимое всех строк двумерного массива.
        System.out.println(Arrays.deepToString(competitionScores));

        // Независимая копия двумерного массива
        // Одной копии внешнего массива недостаточно: каждая внутренняя строка
        // тоже должна стать отдельным int[] со своими элементами.
        int[][] backupCompetitionScores = new int[competitionScores.length][];

        for (
                int athleteIndex = 0;
                athleteIndex < competitionScores.length;
                athleteIndex++
        ) {
            backupCompetitionScores[athleteIndex] = Arrays.copyOf(
                    competitionScores[athleteIndex],
                    competitionScores[athleteIndex].length
            );
        }

        // equals сравнивает ссылки на строки: строки-копии являются другими объектами.
        // deepEquals сравнивает содержимое строк: все скопированные числа совпадают.
        boolean shallowCompetitionScoresMatch = Arrays.equals(
                competitionScores,
                backupCompetitionScores
        );
        boolean deepCompetitionScoresMatch = Arrays.deepEquals(
                competitionScores,
                backupCompetitionScores
        );

        System.out.println(shallowCompetitionScoresMatch);
        System.out.println(deepCompetitionScoresMatch);

        // Дополнительные попытки: число элементов в каждой строке может различаться.
        int[][] extraAttemptScores = new int[athleteNames.length][];

        extraAttemptScores[0] = new int[] {5, 7};
        extraAttemptScores[1] = new int[] {4, 6, 8, 10};
        extraAttemptScores[2] = new int[] {9};
        extraAttemptScores[3] = new int[] {3, 5, 7};

        // Два for-each обходят все строки и все попытки.
        // Строки разной длины не требуют отдельной обработки.
        int totalExtraAttemptScore = 0;

        for (int[] athleteAttemptScores : extraAttemptScores) {
            for (int attemptScore : athleteAttemptScores) {
                totalExtraAttemptScore += attemptScore;
            }
        }

        // Количество попыток берём из длины строки конкретного спортсмена.
        for (
                int athleteIndex = 0;
                athleteIndex < extraAttemptScores.length;
                athleteIndex++
        ) {
            System.out.println(
                    String.format("%-17s", athleteNames[athleteIndex] + " attempts:")
                            + " " + extraAttemptScores[athleteIndex].length
            );
        }

        // Награды: сначала все ожидают решения, затем победитель получает GOLD.
        String[] awardStatuses = new String[athleteNames.length];

        Arrays.fill(awardStatuses, "PENDING");
        System.out.println(Arrays.toString(awardStatuses));

        awardStatuses[winnerIndex] = "GOLD";
        System.out.println(Arrays.toString(awardStatuses));

        // Итоговый отчёт: квалификация, дисциплины, победитель, дополнительные попытки и награды.
        System.out.println("Athletes:              " + athleteNames.length);

        System.out.println("Qualification scores:  " + Arrays.toString(qualifyingScores));
        System.out.println("Qualification sum:     " + qualificationSum);
        System.out.println("Qualification average: " + qualificationAverage);
        System.out.println("Minimum score:         " + minimumScore);
        System.out.println("Maximum score:         " + maximumScore);

        System.out.println("Sorted scores:         " + Arrays.toString(sortedQualifyingScores));
        System.out.println("Finalist scores:       " + Arrays.toString(finalistScores));

        System.out.println("Competition scores:    " + Arrays.deepToString(competitionScores));
        System.out.println("Total scores:          " + Arrays.toString(athleteTotalScores));

        System.out.println("Winner:                " + athleteNames[winnerIndex]);
        System.out.println("Winner score:          " + athleteTotalScores[winnerIndex]);

        System.out.println("Extra attempts sum:    " + totalExtraAttemptScore);
        System.out.println("Award statuses:        " + Arrays.toString(awardStatuses));

        console.close();
    }
}
