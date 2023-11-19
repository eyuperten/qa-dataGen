package org.example.dataGenerator;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class RandomFootballTeamGenerator {
    private static ArrayList<String> teams;
    private static final Random random = new Random();

    public static String RandomTeam() {
        try {
            // YAML dosyasını oku
            Yaml yaml = new Yaml();
            FileInputStream inputStream = new FileInputStream("trFootballTeams.yaml");
            Map<String, ArrayList<String>> teamsData = yaml.load(inputStream);

            teams = teamsData.get("teams");
            String randomTeam = getRandomTeam(teams);
            return randomTeam;

        } catch (FileNotFoundException e) {
            System.err.println("trFootballTeams yaml file not found");
            return null;
        }
    }

    public static String getRandomTeam(ArrayList<String> teams) {
        int index = random.nextInt(teams.size());
        return teams.get(index);
    }


}

