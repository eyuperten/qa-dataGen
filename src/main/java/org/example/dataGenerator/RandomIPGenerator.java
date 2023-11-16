package org.example.dataGenerator;

import java.util.Random;

public class RandomIPGenerator {
    private static final Random random = new Random();

    // Function to generate a random IPv4 address
    public static String generateRandomIPv4() {
        StringBuilder ip = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            ip.append(random.nextInt(256));
            if (i < 3) {
                ip.append(".");
            }
        }
        return ip.toString();
    }

    // Function to generate a random IPv6 address
    public static String generateRandomIPv6() {
        StringBuilder ip = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            ip.append(Integer.toHexString(random.nextInt(65536)));
            if (i < 7) {
                ip.append(":");
            }
        }
        return ip.toString();
    }

    // Function to generate a random MAC address
    public static String generateRandomMAC() {
        StringBuilder mac = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            mac.append(String.format("%02X", random.nextInt(256)));
            if (i < 5) {
                mac.append(":");
            }
        }
        return mac.toString();
    }

    public static void main(String[] args) {
        System.out.println("Random IPv4 Address: " + generateRandomIPv4());
        System.out.println("Random IPv6 Address: " + generateRandomIPv6());
        System.out.println("Random MAC Address: " + generateRandomMAC());
    }
}
