package org.example.dataGenerator;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class GenerateNameAndSurname {
    private static ArrayList<String> isimler;
    private static ArrayList<String> soyisimler;

    static {
        try {
            // İsimler için YAML dosyasını oku ve isimleri al
            Yaml yaml = new Yaml();
            FileInputStream inputStream = new FileInputStream("/Users/mobven/Desktop/dataGen-WebApi/src/main/resources/trNames.yaml");
            Map<String, ArrayList<String>> nameData = yaml.load(inputStream);
            isimler = nameData.get("İsimler");

            // Soyisimler için YAML dosyasını oku ve soyisimleri al
            inputStream = new FileInputStream("/Users/mobven/Desktop/dataGen-WebApi/src/main/resources/trSurnames.yaml");
            Map<String, ArrayList<String>> surnameData = yaml.load(inputStream);
            soyisimler = surnameData.get("Soyisimler");
        } catch (FileNotFoundException e) {
            System.err.println("YAML dosyaları bulunamadı.");
        }
    }

    public static String generateRandomNameAndSurname() {
        if (isimler == null || soyisimler == null) {
            return null;
        }

        // Rastgele bir isim ve soyisim seç
        Random rand = new Random();
        String randomIsim = isimler.get(rand.nextInt(isimler.size()));
        String randomSoyisim = soyisimler.get(rand.nextInt(soyisimler.size()));

        // Seçilen isim ve soyisimi birleştirip döndür
        return randomIsim + " " + randomSoyisim;
    }

    public static String generateOnlyName() {
        if (isimler == null) {
            return null;
        }

        // Rastgele bir isim seç
        Random rand = new Random();
        String randomIsim = isimler.get(rand.nextInt(isimler.size()));

        return randomIsim;
    }

    public static String generateOnlySurname() {
        if (soyisimler == null) {
            return null;
        }

        // Rastgele bir soyisim seç
        Random rand = new Random();
        String randomSoyisim = soyisimler.get(rand.nextInt(soyisimler.size()));

        return randomSoyisim;
    }
}
