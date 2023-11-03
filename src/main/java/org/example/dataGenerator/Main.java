package org.example.dataGenerator;


import com.github.javafaker.Faker;
import java.util.Locale;
import java.util.Scanner;

import static org.example.dataGenerator.RandomEducation.rastgeleEgitimSec;
import static org.example.dataGenerator.RandomEpinGenerator.generateRandomEpinNumber;
import static org.example.dataGenerator.RandomGmailAccountGenerator.RandomGmailAccount;
import static org.example.dataGenerator.RandomGmailAccountGenerator.RandomGmailAccountEng;
import static org.example.dataGenerator.RandomGsmGenerator.rastgeleGBTelefonuUret;
import static org.example.dataGenerator.RandomGsmGenerator.rastgeleTurkTelefonuUret;
import static org.example.dataGenerator.RandomIbanGenerator.RandomEngIban;
import static org.example.dataGenerator.RandomIbanGenerator.rastgeleTurkIBANUret;
import static org.example.dataGenerator.RandomIdNumGenerator.generateRandomIdNumber;
import static org.example.dataGenerator.RandomMoneyGenerator.formatAmount;
import static org.example.dataGenerator.RandomMoneyGenerator.generateRandomAmount;
import static org.example.dataGenerator.RandomPasswordGenerator.generatePassword;
import static org.example.dataGenerator.RandomWalletNumberGenerator.generateRandomWalletNumber;
import static org.example.dataGenerator.RandomWalletNumberGenerator.generateRandomWalletNumberEng;



public class Main {

    static final int dataAmountDefault=1000;

    public static void main(String[] args) {

        Scanner input = new Scanner (System.in);
        String lang = input.nextLine();
        while (lang != "q")
        {
            if (lang == "q")
            {
                break;
            }
            for ( int i = 0; i < dataAmountDefault; i++)
            {
                generateData(lang);
            }

            input = new Scanner (System.in);
            lang = input.nextLine();

        }
        }
    public static void generateData(String lang){


                switch (lang)
                {

                    case "eng":
                        Faker fakerUS = new Faker(new Locale("en-US"));
                        String name = fakerUS.name().firstName();
                        String surname  = fakerUS.name().lastName();
                        String birthDay   = fakerUS.date().birthday(16,99).toString();
                        String city = fakerUS.address().cityName();
                        String jobEng = fakerUS.job().title();
                        String idNum = fakerUS.idNumber().valid();
                        String phoneNum = rastgeleGBTelefonuUret();
                        String mailEng = RandomGmailAccountEng();
                        String ibanEng = RandomEngIban();
                        String password2 = generatePassword();

                        double randomAmount2 = generateRandomAmount();
                        String moneyAmount = formatAmount(randomAmount2);
                        String walletNumberEng = generateRandomWalletNumberEng();


                        System.out.printf("-----------------***********--------------------\n");
                        System.out.printf("Name:            %s\n", name);
                        System.out.printf("surname:         %s\n", surname);
                        System.out.printf("Birthdate:       %s\n", birthDay);
                        System.out.printf("City:            %s\n", city);
                        System.out.printf("Mail:            %s\n", mailEng);
                        System.out.printf("Wallet No:       %s\n", walletNumberEng);
                        System.out.printf("Money:           %s\n",  moneyAmount);
                        //System.out.printf("Egitim Düzeyi:   %s\n", rastgeleEgitimDuzeyi);
                        System.out.printf("Gsm No:          %s\n", phoneNum);
                        System.out.printf("ID:              %s\n", idNum);
                        System.out.printf("IBAN:            %s\n", ibanEng);
                        System.out.printf("Şifre:           %s\n", password2);
                        //System.out.printf("E-pin:           %s\n", epin);
                        System.out.printf("Job:             %s\n", jobEng);
                        System.out.printf("-----------------***********--------------------\n");

                        break;

                    case "tr":
                        String date = GenerateDate.generateRandomDate();
                        int randomPlakaNumarasi = (int) (Math.random() * (81 - 40 + 1)) + 40;
                        String sehir = RandomCities.generateRandomCity();
                        String gmailAccount = RandomGmailAccount();
                        String passport = RandomPassportGenerator.RandomPassport();
                        String walletNumber = generateRandomWalletNumber();
                        String rastgeleEgitimDuzeyi = rastgeleEgitimSec();
                        String telefonNumarasi = rastgeleTurkTelefonuUret();
                        String tcNum = generateRandomIdNumber();
                        String iban = rastgeleTurkIBANUret();
                        String password = generatePassword();
                        String epin = generateRandomEpinNumber();
                        String meslek = RandomJobGenerator.RandomMeslek();
                        String nameAndSurname= GenerateNameAndSurname.generateRandomNameAndSurname();
                        double randomAmount = generateRandomAmount();
                        String tutar = formatAmount(randomAmount);
                        String cars = GenerateCar.generateRandomCar();

                        System.out.printf("-----------------***********--------------------\n");
                        System.out.printf("AD:              %s\n", nameAndSurname);
                        System.out.printf("Dogum Tarihi:    %s\n", date);
                        System.out.printf("Sehir:           %s\n", sehir);
                        System.out.printf("Mail:            %s\n", gmailAccount);
                        System.out.printf("Cüzdan No:       %s\n", walletNumber);
                        System.out.printf("Tutar:           %s\n", tutar);
                        System.out.printf("Egitim Düzeyi:   %s\n", rastgeleEgitimDuzeyi);
                        System.out.printf("Gsm No:          %s\n", telefonNumarasi);
                        System.out.printf("Tc:              %s\n", tcNum);
                        System.out.printf("IBAN:            %s\n", iban);
                        System.out.printf("Şifre:           %s\n", password);
                        System.out.printf("E-pin:           %s\n", epin);
                        System.out.printf("Pasaport:        %s\n", passport);
                        System.out.printf("MESLEK:          %s\n", meslek);
                        System.out.printf("Araba:           %s\n", cars);

                        System.out.printf("-----------------***********--------------------\n");


                        break;

                }


    }


}
