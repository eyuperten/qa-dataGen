package org.example.dataGenerator;

import java.math.BigInteger;
import java.util.Random;

public class RandomGsmGenerator {

    public static String rastgeleTurkTelefonuUret() {
        Random random = new Random();


        int digerRakamlar = 100000000 + random.nextInt(900000000);
        String telefonNumarasi = String.format("5%d", digerRakamlar);
        return telefonNumarasi;
    }

    public static String rastgeleGBTelefonuUret() {
        Random random = new Random();

        // Generate a random 9-digit number for the main part of the phone number
        int mainPart = 100000000 + random.nextInt(900000000);

        // Generate a random 4-digit area code
        int areaCode = 1000 + random.nextInt(9000);

        // Generate a random 6-digit local number
        int localNumber = 100000 + random.nextInt(900000);

        // Combine the parts to create the phone number format
        String phoneNumber = String.format("+44 %04d %06d", areaCode, localNumber);

        return phoneNumber;
    }
}


