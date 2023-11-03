package org.example.dataGenerator;

import java.util.Random;

public class RandomPasswordGenerator {

    public static String generatePassword() {
        String password;
        do {
            password = generateRandomPassword();
        } while (!isValid(password));
        return password;
    }

    private static String generateRandomPassword() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int digit = random.nextInt(10); // Random 0-9 arası rakam
            sb.append(digit);
        }
        return sb.toString();
    }

    private static boolean isValid(String password) {
        return !containsConsecutiveDigits(password) &&
                !containsThreeOrMoreRepeatingDigits(password) &&
                !startsWithZero(password) &&
                !containsYears(password);
    }

    private static boolean containsConsecutiveDigits(String password) {
        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsThreeOrMoreRepeatingDigits(String password) {
        for (int i = 0; i < password.length() - 2; i++) {
            if (password.charAt(i) == password.charAt(i + 1) &&
                    password.charAt(i) == password.charAt(i + 2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean startsWithZero(String password) {
        return password.charAt(0) == '0';
    }

    private static boolean containsYears(String password) {
        int year = 1900;
        int currentYear = java.time.Year.now().getValue();
        while (year <= currentYear) {
            if (password.contains(Integer.toString(year))) {
                return true;
            }
            year++;
        }
        return false;
    }
}

