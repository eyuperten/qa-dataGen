package org.example.dataGenerator;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Map;

public class RandomJobGenerator {
    private static final Random random = new Random();

    public static String RandomMeslek() {
        try {
            // YAML dosyasını oku
            Yaml yaml = new Yaml();
            FileInputStream inputStream = new FileInputStream("/Users/volkan/Desktop/data-backend/target/classes/trNames.yaml");
            Map<String, ArrayList<String>> data = yaml.load(inputStream);

            // Meslekleri ayrı bir listeden al
            ArrayList<String> meslekler = data.get("Meslekler");

            // Rastgele bir meslek seç
            String rastgeleMeslek = getRandomMeslek(meslekler);
            return rastgeleMeslek;
        } catch (FileNotFoundException e) {
            System.err.println("jobs.yaml dosyası bulunamadı.");
            return null;
        }
    }

    public static String getRandomMeslek(ArrayList<String> meslekler) {
        int index = random.nextInt(meslekler.size());
        return meslekler.get(index);
    }
}
