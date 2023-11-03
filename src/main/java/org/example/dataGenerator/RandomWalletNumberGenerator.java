package org.example.dataGenerator;

import java.util.Random;

public class RandomWalletNumberGenerator {

    public static String generateRandomWalletNumber() {
        Random random = new Random();
        StringBuilder walletNumberBuilder = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            int digit = random.nextInt(10);
            walletNumberBuilder.append(digit);
        }

        return walletNumberBuilder.toString();
    }

    public static String generateRandomWalletNumberEng() {
        Random random = new Random();
        StringBuilder walletNumberBuilder = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            int digit = random.nextInt(10);
            walletNumberBuilder.append(digit);
        }

        return walletNumberBuilder.toString();
    }
}
