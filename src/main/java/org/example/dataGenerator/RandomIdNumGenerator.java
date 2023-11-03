package org.example.dataGenerator;

import java.util.Random;

public class RandomIdNumGenerator {

    public static String generateRandomIdNumber() {
        Random random = new Random();
        StringBuilder idNumberBuilder = new StringBuilder();

        for (int i = 0; i < 11; i++) {
            int digit = random.nextInt(10);
            idNumberBuilder.append(digit);
        }

        return idNumberBuilder.toString();
    }
}

