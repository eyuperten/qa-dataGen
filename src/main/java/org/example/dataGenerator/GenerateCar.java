package org.example.dataGenerator;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class GenerateCar {
    public static String generateRandomCar() {
        try {
            // YAML dosyasını oku
            Yaml yaml = new Yaml();
            FileInputStream inputStream = new FileInputStream("/Users/volkan/Desktop/data-backend/target/classes/trCars.yaml");
            Map<String, ArrayList<Map<String, String>>> data = yaml.load(inputStream);

            ArrayList<Map<String, String>> carsList = data.get("car_models_with_brands");

            Random rand = new Random();
            Map<String, String> randomCar = carsList.get(rand.nextInt(carsList.size()));

            return randomCar.get("brand") + " " + randomCar.get("model");
        } catch (FileNotFoundException e) {
            System.err.println("trCars.yaml dosyası bulunamadı.");
            return null;
        }
    }
}
