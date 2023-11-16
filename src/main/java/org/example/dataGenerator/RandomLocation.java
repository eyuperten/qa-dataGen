package org.example.dataGenerator;

import java.util.Random;

public class RandomLocation {
    private static final Random random = new Random();

    // Function to generate a random latitude
    public static double generateRandomLatitude() {
        // Latitude ranges from -90 degrees (south) to 90 degrees (north)
        return -90.0 + random.nextDouble() * 180.0;
    }

    // Function to generate a random longitude
    public static double generateRandomLongitude() {
        // Longitude ranges from -180 degrees (west) to 180 degrees (east)
        return -180.0 + random.nextDouble() * 360.0;
    }

    public static String getLocation() {
        return "Latitude: "+ generateRandomLatitude() + " " + "Longtitude: "+ generateRandomLongitude();
    }
}
