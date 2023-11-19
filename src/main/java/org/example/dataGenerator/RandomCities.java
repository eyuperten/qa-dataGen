package org.example.dataGenerator;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Random;

public class RandomCities {
    public static String generateRandomCity() {
        try {
            // YAML dosyasını oku
            Yaml yaml = new Yaml();
            FileInputStream inputStream = new FileInputStream("trCities.yaml");
            Map<Integer, String> plakaSehirMap = yaml.load(inputStream);

            // Rasgele bir plaka numarası seç
            Random rand = new Random();
            int randomPlakaNumarasi = rand.nextInt(81) + 1; // 1 ila 81 arasında rastgele bir plaka numarası

            // Seçilen plaka numarasına göre şehri bul
            String secilenSehir = plakaSehirMap.get(randomPlakaNumarasi);

            return secilenSehir;
        } catch (FileNotFoundException e) {
            System.err.println("trCities.yaml dosyası bulunamadı.");
            return null;
        }
    }
}
