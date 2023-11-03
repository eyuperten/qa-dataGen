package org.example.dataGenerator;

import java.time.LocalDate;
import java.util.Random;

public class GenerateDate {
    public static void main(String[] args) {
        String randomDate = generateRandomDate();
        System.out.println(randomDate);
    }

    public static String generateRandomDate() {
        Random rand = new Random();
        LocalDate currentDate = LocalDate.now();
        int minDay = 1;
        int maxDay = 31;
        int minMonth = 1;
        int maxMonth = 12;
        int minYear = 1900;
        int maxYear = currentDate.getYear();

        int day = rand.nextInt((maxDay - minDay) + 1) + minDay;
        int month = rand.nextInt((maxMonth - minMonth) + 1) + minMonth;
        int year = rand.nextInt((maxYear - minYear) + 1) + minYear;

        String dayStr = String.format("%02d", day);
        String monthStr = String.format("%02d", month);
        String yearStr = String.format("%04d", year);

        return dayStr + "/" + monthStr + "/" + yearStr;
    }
}
