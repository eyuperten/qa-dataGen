package org.example.dataGenerator;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class RandomMovieGenerator {
    private static final Random random = new Random();
    private static ArrayList<String> movies;

    static {
        try {
            Yaml yaml = new Yaml();
            FileInputStream inputStream = new FileInputStream("/Users/mobven/Desktop/dataGen-WebApi/src/main/resources/trMovies.yaml");
            Map<String, ArrayList<String>> nameData = yaml.load(inputStream);
            movies = nameData.get("Movies");

        } catch (FileNotFoundException e) {
            System.err.println("YAML dosyaları bulunamadı.");
        }
    }
    public static String generateRandomMovieGenre() {
        String[] genres = {"Drama", "Komedi", "Aksiyon", "Bilim Kurgu", "Korku", "Romantik", "Macera", "Gerilim", "Animasyon", "Fantastik"};
        int randomIndex = random.nextInt(genres.length);
        return genres[randomIndex];
    }

    public static String generateRandomMovieTitle() {
        if (movies == null) {
            return null;
        }

        String randomMovie = movies.get(random.nextInt(movies.size()));
        return randomMovie;
    }


    public static void main(String[] args) {
        System.out.println("Rastgele Film Türü: " + generateRandomMovieGenre());
        System.out.println("Rastgele Film İsmi: " + generateRandomMovieTitle());
    }
}
