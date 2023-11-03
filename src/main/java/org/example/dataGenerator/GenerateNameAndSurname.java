package org.example.dataGenerator;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class GenerateNameAndSurname {
    public static String generateRandomNameAndSurname() {
        try {
            // YAML dosyasını oku
            Yaml yaml = new Yaml();
            FileInputStream inputStream = new FileInputStream("/Users/mobven/Desktop/dataGen-WebApi/src/main/resources/trNames.yaml");
            Map<String, ArrayList<String>> data = yaml.load(inputStream);

            // İsimler ve soyisimleri ayrı listelerden al
            ArrayList<String> isimler = data.get("İsimler");
            ArrayList<String> soyisimler = data.get("Soyisimler");

            // Rastgele bir isim ve soyisim seç
            Random rand = new Random();
            String randomIsim = isimler.get(rand.nextInt(isimler.size()));
            String randomSoyisim = soyisimler.get(rand.nextInt(soyisimler.size()));

            // Seçilen isim ve soyisimi birleştirip döndür
            return randomIsim + " " + randomSoyisim;
        } catch (FileNotFoundException e) {
            System.err.println("trNames.yaml dosyası bulunamadı.");
            return null;
        }
    }

    public static String generateOnlyName() {
        try {
            // YAML dosyasını oku
            Yaml yaml = new Yaml();
            FileInputStream inputStream = new FileInputStream("/Users/mobven/Desktop/dataGen-WebApi/src/main/resources/trNames.yaml");
            Map<String, ArrayList<String>> data = yaml.load(inputStream);

            // İsimleri ayrı bir listeden al
            ArrayList<String> isimler = data.get("İsimler");

            // Rastgele bir isim seç
            Random rand = new Random();
            String randomIsim = isimler.get(rand.nextInt(isimler.size()));

            return randomIsim;
        } catch (FileNotFoundException e) {
            System.err.println("trNames.yaml dosyası bulunamadı.");
            return null;
        }
    }

    public static String generateOnlySurname() {
        try {
            // YAML dosyasını oku
            Yaml yaml = new Yaml();
            FileInputStream inputStream = new FileInputStream("/Users/mobven/Desktop/dataGen-WebApi/src/main/resources/trNames.yaml");
            Map<String, ArrayList<String>> data = yaml.load(inputStream);

            // Soyisimleri ayrı bir listeden al
            ArrayList<String> soyisimler = data.get("Soyisimler");

            // Rastgele bir soyisim seç
            Random rand = new Random();
            String randomSoyisim = soyisimler.get(rand.nextInt(soyisimler.size()));

            return randomSoyisim;
        } catch (FileNotFoundException e) {
            System.err.println("trNames.yaml dosyası bulunamadı.");
            return null;
        }
    }
}
