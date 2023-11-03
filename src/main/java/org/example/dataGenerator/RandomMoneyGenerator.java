package org.example.dataGenerator;

import java.text.DecimalFormat;
import java.util.Random;

public class RandomMoneyGenerator {


    public static double generateRandomAmount() {
        Random random = new Random();
        double amount = random.nextDouble() * 100000.0;
        return amount;
    }

    public static String formatAmount(double amount) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.00");
        return decimalFormat.format(amount);
    }
}

