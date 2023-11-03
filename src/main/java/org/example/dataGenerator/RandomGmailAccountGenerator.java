package org.example.dataGenerator;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class RandomGmailAccountGenerator {
    private static final Faker fakerTR = new Faker(new Locale("tr"));
    private static final Faker fakerUS = new Faker(new Locale("en-US"));



    private static final String[] DOMAIN = {"gmail.com","hotmail.com","outlook.com","yandex.com"};

    public static String RandomGmailAccount() {
        String ad = fakerTR.name().firstName();
        Random random = new Random();
        //String domain = DOMAIN[0];
        String domain = getRandomElement(DOMAIN);   //Fazladan domain eklenirse kullanılacak
        int randomNumber = random.nextInt(9999);
        String email = ad + randomNumber + "@" + domain;
        return email;
    }

    public static String RandomGmailAccountEng() {
        String name = fakerUS.name().firstName();
        Random random = new Random();
        //String domain = DOMAIN[0];
        String domain = getRandomElement(DOMAIN);   //Fazladan domain eklenirse kullanılacak
        int randomNumber = random.nextInt(9999);
        String email = name + randomNumber + "@" + domain;
        return email.toLowerCase();
    }

    private static String getRandomElement(String[] array) {      //Fazladan domain eklenirse kullanılacak
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
    }

}
