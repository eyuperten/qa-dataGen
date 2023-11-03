package org.example.dataGenerator;

import java.util.Random;

public class RandomEpinGenerator {
    public static String generateRandomEpinNumber() {
        Random random = new Random();
        StringBuilder idNumberBuilder = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10);
            idNumberBuilder.append(digit);
        }

        return idNumberBuilder.toString();
    }
}
