package org.example.dataGenerator;
import java.util.Random;

public class RandomPassportGenerator {

    private static String [] passportDomain = {"U","Z","S","P"};
    public static String  RandomPassport (){

        Random random = new Random();

        int randomNumber = random.nextInt(100000,999999);
        String domain = getRandomElement(passportDomain);
        String passport = domain + " " + randomNumber;

        return passport;

    }


    //https://www.gruppal.com/blog/hangi-pasaport-kime-verilir
    public static String getRandomElement(String[] passportDomain){

        Random random = new Random();
        int index = random.nextInt(0,passportDomain.length);
        return passportDomain[index];

    }

}






