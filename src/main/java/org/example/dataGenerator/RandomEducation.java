package org.example.dataGenerator;

import java.util.Random;

public class RandomEducation {

    public static String rastgeleEgitimSec() {
        String[] egitimDuzeyleri = {"İlk Okul", "Orta Okul", "Lise", "Üniversite", "Yüksek Lisans", "Doktora"};

        Random random = new Random();
        int rastgeleIndex = random.nextInt(egitimDuzeyleri.length);
        return egitimDuzeyleri[rastgeleIndex];
    }
}


