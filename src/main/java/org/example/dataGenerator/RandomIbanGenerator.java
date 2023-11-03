package org.example.dataGenerator;

import java.math.BigInteger;
import java.util.Random;

public class RandomIbanGenerator {

    public static String rastgeleTurkIBANUret() {
        Random random = new Random();

        //  banka kodları
        String[] bankaKodlari = {"TR33", "TR70", "TR94", "TR26", "TR45", "TR86", "TR17"};

        //  şube kodları
        String[] subeKodlari = {"1000", "2000", "3000", "4000", "5000", "6000", "7000"};

        // Rastgele bir banka kodu ve şube kodu seç
        int rastgeleBankaIndex = random.nextInt(bankaKodlari.length);
        String bankaKodu = bankaKodlari[rastgeleBankaIndex];

        int rastgeleSubeIndex = random.nextInt(subeKodlari.length);
        String subeKodu = subeKodlari[rastgeleSubeIndex];

        // Rastgele 18 haneli hesap numarası oluştur
        StringBuilder hesapNumarasiBuilder = new StringBuilder();
        for (int i = 0; i < 18; i++) {

            int rastgeleRakam = random.nextInt(10);
            hesapNumarasiBuilder.append(rastgeleRakam);
        }
        String hesapNumarasi = hesapNumarasiBuilder.toString();

        // IBAN formatına göre hesap numarasını düzenle
        String duzenlenmisHesapNumarasi = hesapNumarasi.substring(0, 5) + "0" + hesapNumarasi.substring(5);

        // IBAN'ı oluştur ve kontrol hanelerini hesapla
        String ibanAlani = bankaKodu + subeKodu + duzenlenmisHesapNumarasi + "0000";
        int kontrolRakamlari = 98 - mod97(ibanAlani);

        // Son IBAN'ı oluştur
        String iban = "TR" + String.format("%02d", kontrolRakamlari) + " " + hesapNumarasi+ " " + subeKodu ;

        return iban;
    }

    public static String RandomEngIban() {
        Random random = new Random();

        //  banka kodları
        String[] bankaKodlari = {"GB33", "GB70", "GB94", "GB26", "GB45", "GB86", "GB17"};

        //  şube kodları
        String[] subeKodlari = {"1000", "2000", "3000", "4000", "5000", "6000", "7000"};

        // Rastgele bir banka kodu ve şube kodu seç
        int rastgeleBankaIndex = random.nextInt(bankaKodlari.length);
        String bankaKodu = bankaKodlari[rastgeleBankaIndex];

        int rastgeleSubeIndex = random.nextInt(subeKodlari.length);
        String subeKodu = subeKodlari[rastgeleSubeIndex];

        // Rastgele 18 haneli hesap numarası oluştur
        StringBuilder hesapNumarasiBuilder = new StringBuilder();
        for (int i = 0; i < 18; i++) {

            int rastgeleRakam = random.nextInt(10);
            hesapNumarasiBuilder.append(rastgeleRakam);
        }
        String hesapNumarasi = hesapNumarasiBuilder.toString();

        // IBAN formatına göre hesap numarasını düzenle
        String duzenlenmisHesapNumarasi = hesapNumarasi.substring(0, 5) + "0" + hesapNumarasi.substring(5);

        // IBAN'ı oluştur ve kontrol hanelerini hesapla
        String ibanAlani = bankaKodu + subeKodu + duzenlenmisHesapNumarasi + "0000";
        int kontrolRakamlari = 98 - mod97(ibanAlani);

        // Son IBAN'ı oluştur
        String iban = "GB" + String.format("%02d", kontrolRakamlari) + " " + hesapNumarasi+ " " + subeKodu ;

        return iban;
    }

    private static int mod97(String ibanAlani) {
        StringBuilder ibanAlaniBuilder = new StringBuilder();
        for (int i = 0; i < ibanAlani.length(); i++) {
            char c = ibanAlani.charAt(i);
            ibanAlaniBuilder.append(Character.getNumericValue(c));
        }

        String ibanNumeric = ibanAlaniBuilder.toString();
        BigInteger bigInt = new BigInteger(ibanNumeric);
        return bigInt.mod(BigInteger.valueOf(97)).intValue();
    }
}

