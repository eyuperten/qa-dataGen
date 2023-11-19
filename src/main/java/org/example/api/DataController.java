package org.example.api;

import com.github.javafaker.Faker;
import org.example.dataGenerator.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static org.example.dataGenerator.RandomEpinGenerator.generateRandomEpinNumber;
import static org.example.dataGenerator.RandomIbanGenerator.RandomEngIban;


@RestController
public class DataController {
    Faker fakerUS = new Faker(new Locale("en-US"));

    private static final Logger logger = LoggerFactory.getLogger(DataController.class);

    @GetMapping("/generateDataEng")
    public ResponseEntity<List<Map<String, Object>>> generateDataEng(
            @RequestParam(name = "includeAll", required = false, defaultValue = "false") boolean includeAll,

            @RequestParam(name = "includeAd", required = false, defaultValue = "false") boolean includeAd,
            @RequestParam(name = "adKeyName", required = false, defaultValue = "ad") String adKeyName,

            @RequestParam(name = "includeAdVeSoyAd", required = false, defaultValue = "false") boolean includeAdVeSoyAd,
            @RequestParam(name = "adVeSoyadKeyName", required = false, defaultValue = "adVeSoyAd") String adVeSoyadKeyName,

            @RequestParam(name = "includeSoyAd", required = false, defaultValue = "false") boolean includeSoyAd,
            @RequestParam(name = "soyadKeyName", required = false, defaultValue = "soyAd") String soyadKeyName,

            @RequestParam(name = "includeDogumTarihi", required = false, defaultValue = "false") boolean includeDogumTarihi,
            @RequestParam(name = "dTarihiKeyName", required = false, defaultValue = "dogumTarihi") String dTarihiKeyName,

            @RequestParam(name = "includeSehir", required = false, defaultValue = "false") boolean includeSehir,
            @RequestParam(name = "sehirKeyName", required = false, defaultValue = "sehir") String sehirKeyName,

            @RequestParam(name = "includeGmailAccount", required = false, defaultValue = "false") boolean includeGmailAccount,
            @RequestParam(name = "mailKeyName", required = false, defaultValue = "gmailAccount") String mailKeyName,

            @RequestParam(name = "includeWalletNumber", required = false, defaultValue = "false") boolean includeWalletNumber,
            @RequestParam(name = "walletKeyName", required = false, defaultValue = "walletNumber") String walletKeyName,

            @RequestParam(name = "includeTutar", required = false, defaultValue = "false") boolean includeTutar,
            @RequestParam(name = "tutarKeyName", required = false, defaultValue = "tutar") String tutarKeyName,

            @RequestParam(name = "includeRastgeleEgitimDuzeyi", required = false, defaultValue = "false") boolean includeRastgeleEgitimDuzeyi,
            @RequestParam(name = "egitimKeyName", required = false, defaultValue = "rastgeleEgitimDuzeyi") String egitimKeyName,

            @RequestParam(name = "includeTelefonNumarasi", required = false, defaultValue = "false") boolean includeTelefonNumarasi,
            @RequestParam(name = "telefonKeyName", required = false, defaultValue = "telefonNumarasi") String telefonKeyName,

            @RequestParam(name = "includeTcNum", required = false, defaultValue = "false") boolean includeTcNum,
            @RequestParam(name = "tcNumKeyName", required = false, defaultValue = "tcNum") String tcNumKeyName,

            @RequestParam(name = "includeIban", required = false, defaultValue = "false") boolean includeIban,
            @RequestParam(name = "ibanKeyName", required = false, defaultValue = "iban") String ibanKeyName,

            @RequestParam(name = "includePassword", required = false, defaultValue = "false") boolean includePassword,
            @RequestParam(name = "passwordKeyName", required = false, defaultValue = "password") String passwordKeyName,

            @RequestParam(name = "includeEpin", required = false, defaultValue = "false") boolean includeEpin,
            @RequestParam(name = "epinKeyName", required = false, defaultValue = "epin") String epinKeyName,

            @RequestParam(name = "includeJob", required = false, defaultValue = "false") boolean includeJob,
            @RequestParam(name = "jobKeyName", required = false, defaultValue = "job") String jobKeyName,

            @RequestParam(name = "includePassport", required = false, defaultValue = "false") boolean includePassport,
            @RequestParam(name = "passportKeyName", required = false, defaultValue = "passport") String passportKeyName,

            @RequestParam(name = "includeCar", required = false, defaultValue = "false") boolean includeCar,
            @RequestParam(name = "carKeyName", required = false, defaultValue = "car") String carKeyName,

            @RequestParam(name = "repeat", required = false, defaultValue = "1") int repeat ) {


        List<Map<String, Object>> dataList = new ArrayList<>();
        for (int i=0 ; i< repeat ; i++)
        {
            Map<String, Object> dataMap = new LinkedHashMap<>();
            if (includeAll) {
                dataMap.put("ad", fakerUS.name().firstName());
                dataMap.put("soyAd", fakerUS.name().lastName());
                dataMap.put("adVeSoyAd", fakerUS.name().fullName());
                dataMap.put("dogumTarihi", GenerateDate.generateRandomDate());
                dataMap.put("sehir", fakerUS.address().cityName());
                dataMap.put("gmailAccount", RandomGmailAccountGenerator.RandomGmailAccountEng());
                dataMap.put("walletNumber", RandomWalletNumberGenerator.generateRandomWalletNumberEng());
                double randomAmount = RandomMoneyGenerator.generateRandomAmount();
                dataMap.put("tutar", RandomMoneyGenerator.formatAmount(randomAmount));
                dataMap.put("rastgeleEgitimDuzeyi", RandomEducation.rastgeleEgitimSec());
                dataMap.put("telefonNumarasi", fakerUS.phoneNumber().cellPhone());
                dataMap.put("tcNum", fakerUS.idNumber().valid());
                dataMap.put("iban", RandomEngIban());
                dataMap.put("password", RandomPasswordGenerator.generatePassword());
                dataMap.put("epin", generateRandomEpinNumber());
                String meslek = fakerUS.job().title();
                dataMap.put("job", meslek);
                dataMap.put("car", GenerateCar.generateRandomCar());

            }
            if (includeAd) {
                if (adKeyName != null) {
                    dataMap.put(adKeyName, fakerUS.name().firstName());
                } else {
                    dataMap.put("ad", fakerUS.name().firstName());
                }
            }
            if (includeSoyAd) {
                if (soyadKeyName != null) {
                    dataMap.put(soyadKeyName, fakerUS.name().lastName());
                } else {
                    dataMap.put("soyAd", fakerUS.name().lastName());
                }
            }

            if (includeAdVeSoyAd) {
                if (adVeSoyadKeyName != null) {
                    dataMap.put(adVeSoyadKeyName, fakerUS.name().fullName());
                } else {
                    dataMap.put("adVeSoyAd", fakerUS.name().fullName());
                }
            }

            if (includeDogumTarihi) {
                if (dTarihiKeyName != null) {
                    dataMap.put(dTarihiKeyName, GenerateDate.generateRandomDate());
                } else {
                    dataMap.put("dogumTarihi", GenerateDate.generateRandomDate());
                }
            }

            if (includeSehir) {
                if (sehirKeyName != null) {
                    dataMap.put(sehirKeyName, fakerUS.address().cityName());
                } else {
                    dataMap.put("sehir", fakerUS.address().cityName());
                }
            }

            if (includeGmailAccount) {
                if (mailKeyName != null) {
                    dataMap.put(mailKeyName, RandomGmailAccountGenerator.RandomGmailAccountEng());
                } else {
                    dataMap.put("gmailAccount", RandomGmailAccountGenerator.RandomGmailAccountEng());
                }
            }

            if (includeWalletNumber) {
                if (walletKeyName != null) {
                    dataMap.put(walletKeyName, RandomWalletNumberGenerator.generateRandomWalletNumberEng());
                } else {
                    dataMap.put("walletNumber", RandomWalletNumberGenerator.generateRandomWalletNumberEng());
                }
            }

            if (includeTutar) {
                double randomAmount = RandomMoneyGenerator.generateRandomAmount();
                if (tutarKeyName != null) {
                    dataMap.put(tutarKeyName, RandomMoneyGenerator.formatAmount(randomAmount));
                } else {
                    dataMap.put("tutar", RandomMoneyGenerator.formatAmount(randomAmount));
                }
            }

            if (includeRastgeleEgitimDuzeyi) {
                if (egitimKeyName != null) {
                    dataMap.put(egitimKeyName, RandomEducation.rastgeleEgitimSec());
                } else {
                    dataMap.put("rastgeleEgitimDuzeyi", RandomEducation.rastgeleEgitimSec());
                }
            }

            if (includeTelefonNumarasi) {
                if (telefonKeyName != null) {
                    dataMap.put(telefonKeyName, fakerUS.phoneNumber().cellPhone());
                } else {
                    dataMap.put("telefonNumarasi", fakerUS.phoneNumber().cellPhone());
                }
            }
            if (includeTcNum) {
                if (tcNumKeyName != null) {
                    dataMap.put(tcNumKeyName, fakerUS.idNumber().valid());
                } else {
                    dataMap.put("tcNum", fakerUS.idNumber().valid());
                }
            }
            if (includeIban) {
                if (ibanKeyName != null) {
                    dataMap.put(ibanKeyName, RandomEngIban());
                } else {
                    dataMap.put("iban", RandomEngIban());
                }
            }
            if (includePassword) {
                if (passwordKeyName != null) {
                    dataMap.put(passwordKeyName, RandomPasswordGenerator.generatePassword());
                } else {
                    dataMap.put("password", RandomPasswordGenerator.generatePassword());
                }
            }
            if (includeEpin) {
                if (epinKeyName != null) {
                    dataMap.put(epinKeyName, generateRandomEpinNumber());
                } else {
                    dataMap.put("epin", generateRandomEpinNumber());
                }
            }
            if (includeJob) {
                String meslek = fakerUS.job().title();
                if (jobKeyName != null) {
                    dataMap.put(jobKeyName, meslek);
                } else {
                    dataMap.put("job", meslek);
                }

            }
            if (includePassport) {
                if (jobKeyName != null) {
                    dataMap.put(passportKeyName, RandomPassportGenerator.RandomPassport());
                } else {
                    dataMap.put("passport", RandomPassportGenerator.RandomPassport());
                }
            }
            if (includeCar) {
                if (carKeyName != null) {
                    dataMap.put(carKeyName, GenerateCar.generateRandomCar());
                } else {
                    dataMap.put("car", GenerateCar.generateRandomCar());
                }
            }

            dataList.add(dataMap); // Add the data map to the list
        }

        if (dataList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.valueOf(400));
        }
        return new ResponseEntity<>(dataList, HttpStatus.OK);
    }









    @GetMapping("/generateData")
    public ResponseEntity<List<Map<String, Object>>> generateData(
            @RequestParam(name = "includeAll", required = false, defaultValue = "false") boolean includeAll,

            @RequestParam(name = "includeAd", required = false, defaultValue = "false") boolean includeAd,
            @RequestParam(name = "adKeyName", required = false, defaultValue = "ad") String adKeyName,

            @RequestParam(name = "includeAdVeSoyAd", required = false, defaultValue = "false") boolean includeAdVeSoyAd,
            @RequestParam(name = "adVeSoyadKeyName", required = false, defaultValue = "adVeSoyAd") String adVeSoyadKeyName,

            @RequestParam(name = "includeSoyAd", required = false, defaultValue = "false") boolean includeSoyAd,
            @RequestParam(name = "soyadKeyName", required = false, defaultValue = "soyAd") String soyadKeyName,

            @RequestParam(name = "includeDogumTarihi", required = false, defaultValue = "false") boolean includeDogumTarihi,
            @RequestParam(name = "dTarihiKeyName", required = false, defaultValue = "dogumTarihi") String dTarihiKeyName,

            @RequestParam(name = "includeSehir", required = false, defaultValue = "false") boolean includeSehir,
            @RequestParam(name = "sehirKeyName", required = false, defaultValue = "sehir") String sehirKeyName,

            @RequestParam(name = "includeGmailAccount", required = false, defaultValue = "false") boolean includeGmailAccount,
            @RequestParam(name = "mailKeyName", required = false, defaultValue = "gmailAccount") String mailKeyName,

            @RequestParam(name = "includeWalletNumber", required = false, defaultValue = "false") boolean includeWalletNumber,
            @RequestParam(name = "walletKeyName", required = false, defaultValue = "walletNumber") String walletKeyName,

            @RequestParam(name = "includeTutar", required = false, defaultValue = "false") boolean includeTutar,
            @RequestParam(name = "tutarKeyName", required = false, defaultValue = "tutar") String tutarKeyName,

            @RequestParam(name = "includeRastgeleEgitimDuzeyi", required = false, defaultValue = "false") boolean includeRastgeleEgitimDuzeyi,
            @RequestParam(name = "egitimKeyName", required = false, defaultValue = "rastgeleEgitimDuzeyi") String egitimKeyName,

            @RequestParam(name = "includeTelefonNumarasi", required = false, defaultValue = "false") boolean includeTelefonNumarasi,
            @RequestParam(name = "telefonKeyName", required = false, defaultValue = "telefonNumarasi") String telefonKeyName,

            @RequestParam(name = "includeTcNum", required = false, defaultValue = "false") boolean includeTcNum,
            @RequestParam(name = "tcNumKeyName", required = false, defaultValue = "tcNum") String tcNumKeyName,

            @RequestParam(name = "includeIban", required = false, defaultValue = "false") boolean includeIban,
            @RequestParam(name = "ibanKeyName", required = false, defaultValue = "iban") String ibanKeyName,

            @RequestParam(name = "includePassword", required = false, defaultValue = "false") boolean includePassword,
            @RequestParam(name = "passwordKeyName", required = false, defaultValue = "password") String passwordKeyName,

            @RequestParam(name = "includeEpin", required = false, defaultValue = "false") boolean includeEpin,
            @RequestParam(name = "epinKeyName", required = false, defaultValue = "epin") String epinKeyName,

            @RequestParam(name = "includeJob", required = false, defaultValue = "false") boolean includeJob,
            @RequestParam(name = "jobKeyName", required = false, defaultValue = "job") String jobKeyName,

            @RequestParam(name = "includePassport", required = false, defaultValue = "false") boolean includePassport,
            @RequestParam(name = "passportKeyName", required = false, defaultValue = "passport") String passportKeyName,

            @RequestParam(name = "includeCar", required = false, defaultValue = "false") boolean includeCar,
            @RequestParam(name = "carKeyName", required = false, defaultValue = "car") String carKeyName,

            @RequestParam(name = "includeFTeam", required = false, defaultValue = "false") boolean includeFTeam,
            @RequestParam(name = "fTeamKeyName", required = false, defaultValue = "team") String fTeamKeyName,

            @RequestParam(name = "includeIpv4", required = false, defaultValue = "false") boolean includeIpv4,
            @RequestParam(name = "ipv4KeyName", required = false, defaultValue = "ipv4") String ipv4KeyName,

            @RequestParam(name = "includeIpv6", required = false, defaultValue = "false") boolean includeIpv6,
            @RequestParam(name = "ipv6KeyName", required = false, defaultValue = "ipv6") String ipv6KeyName,

            @RequestParam(name = "includeMac", required = false, defaultValue = "false") boolean includeMac,
            @RequestParam(name = "macKeyName", required = false, defaultValue = "mac") String macKeyName,

            @RequestParam(name = "includeLocation", required = false, defaultValue = "false") boolean includeLocation,
            @RequestParam(name = "locationKeyName", required = false, defaultValue = "location") String locationKeyName,

            @RequestParam(name = "includeMovieGen", required = false, defaultValue = "false") boolean includeMovieGen,
            @RequestParam(name = "movieGenKeyName", required = false, defaultValue = "movieType") String movieGenKeyName,

            @RequestParam(name = "includeMovieName", required = false, defaultValue = "false") boolean includeMovieName,
            @RequestParam(name = "movieNameKeyName", required = false, defaultValue = "movieName") String movieNameKeyName,

            @RequestParam(name = "repeat", required = false, defaultValue = "1") int repeat ) {


        List<Map<String, Object>> dataList = new ArrayList<>();
        for (int i=0 ; i< repeat ; i++)
        {
            Map<String, Object> dataMap = new LinkedHashMap<>();
            if (includeAll) {
                dataMap.put("ad", GenerateNameAndSurname.generateOnlyName());
                dataMap.put("soyAd", GenerateNameAndSurname.generateOnlySurname());
                dataMap.put("adVeSoyAd", GenerateNameAndSurname.generateRandomNameAndSurname());
                dataMap.put("dogumTarihi", GenerateDate.generateRandomDate());
                dataMap.put("sehir", RandomCities.generateRandomCity());
                dataMap.put("gmailAccount", RandomGmailAccountGenerator.RandomGmailAccount());
                dataMap.put("walletNumber", RandomWalletNumberGenerator.generateRandomWalletNumber());
                double randomAmount = RandomMoneyGenerator.generateRandomAmount();
                dataMap.put("tutar", RandomMoneyGenerator.formatAmount(randomAmount));
                dataMap.put("rastgeleEgitimDuzeyi", RandomEducation.rastgeleEgitimSec());
                dataMap.put("telefonNumarasi", RandomGsmGenerator.rastgeleTurkTelefonuUret());
                dataMap.put("tcNum", RandomIdNumGenerator.generateRandomIdNumber());
                dataMap.put("iban", RandomIbanGenerator.rastgeleTurkIBANUret());
                dataMap.put("password", RandomPasswordGenerator.generatePassword());
                dataMap.put("epin", generateRandomEpinNumber());
                String meslek = RandomJobGenerator.RandomMeslek();
                dataMap.put("job", meslek);
                dataMap.put("car", GenerateCar.generateRandomCar());

            }
            if (includeAd) {
                if (adKeyName != null) {
                    dataMap.put(adKeyName, GenerateNameAndSurname.generateOnlyName());
                } else {
                    dataMap.put("ad", GenerateNameAndSurname.generateOnlyName());
                }
            }
            if (includeSoyAd) {
                if (soyadKeyName != null) {
                    dataMap.put(soyadKeyName, GenerateNameAndSurname.generateOnlySurname());
                } else {
                    dataMap.put("soyAd", GenerateNameAndSurname.generateOnlySurname());
                }
            }

            if (includeAdVeSoyAd) {
                if (adVeSoyadKeyName != null) {
                    dataMap.put(adVeSoyadKeyName, GenerateNameAndSurname.generateRandomNameAndSurname());
                } else {
                    dataMap.put("adVeSoyAd", GenerateNameAndSurname.generateRandomNameAndSurname());
                }
            }

            if (includeDogumTarihi) {
                if (dTarihiKeyName != null) {
                    dataMap.put(dTarihiKeyName, GenerateDate.generateRandomDate());
                } else {
                    dataMap.put("dogumTarihi", GenerateDate.generateRandomDate());
                }
            }

            if (includeSehir) {
                if (sehirKeyName != null) {
                    dataMap.put(sehirKeyName, RandomCities.generateRandomCity());
                } else {
                    dataMap.put("sehir", RandomCities.generateRandomCity());
                }
            }

            if (includeGmailAccount) {
                if (mailKeyName != null) {
                    dataMap.put(mailKeyName, RandomGmailAccountGenerator.RandomGmailAccount());
                } else {
                    dataMap.put("gmailAccount", RandomGmailAccountGenerator.RandomGmailAccount());
                }
            }

            if (includeWalletNumber) {
                if (walletKeyName != null) {
                    dataMap.put(walletKeyName, RandomWalletNumberGenerator.generateRandomWalletNumber());
                } else {
                    dataMap.put("walletNumber", RandomWalletNumberGenerator.generateRandomWalletNumber());
                }
            }

            if (includeTutar) {
                double randomAmount = RandomMoneyGenerator.generateRandomAmount();
                if (tutarKeyName != null) {
                    dataMap.put(tutarKeyName, RandomMoneyGenerator.formatAmount(randomAmount));
                } else {
                    dataMap.put("tutar", RandomMoneyGenerator.formatAmount(randomAmount));
                }
            }

            if (includeRastgeleEgitimDuzeyi) {
                if (egitimKeyName != null) {
                    dataMap.put(egitimKeyName, RandomEducation.rastgeleEgitimSec());
                } else {
                    dataMap.put("rastgeleEgitimDuzeyi", RandomEducation.rastgeleEgitimSec());
                }
            }

            if (includeTelefonNumarasi) {
                if (telefonKeyName != null) {
                    dataMap.put(telefonKeyName, RandomGsmGenerator.rastgeleTurkTelefonuUret());
                } else {
                    dataMap.put("telefonNumarasi", RandomGsmGenerator.rastgeleTurkTelefonuUret());
                }
            }
            if (includeTcNum) {
                if (tcNumKeyName != null) {
                    dataMap.put(tcNumKeyName, RandomIdNumGenerator.generateRandomIdNumber());
                } else {
                    dataMap.put("tcNum", RandomIdNumGenerator.generateRandomIdNumber());
                }
            }
            if (includeIban) {
                if (ibanKeyName != null) {
                    dataMap.put(ibanKeyName, RandomIbanGenerator.rastgeleTurkIBANUret());
                } else {
                    dataMap.put("iban", RandomIbanGenerator.rastgeleTurkIBANUret());
                }
            }
            if (includePassword) {
                if (passwordKeyName != null) {
                    dataMap.put(passwordKeyName, RandomPasswordGenerator.generatePassword());
                } else {
                    dataMap.put("password", RandomPasswordGenerator.generatePassword());
                }
            }
            if (includeEpin) {
                if (epinKeyName != null) {
                    dataMap.put(epinKeyName, generateRandomEpinNumber());
                } else {
                    dataMap.put("epin", generateRandomEpinNumber());
                }
            }
            if (includeJob) {
                String meslek = RandomJobGenerator.RandomMeslek();
                if (jobKeyName != null) {
                        dataMap.put(jobKeyName, meslek);
                } else {
                        dataMap.put("job", meslek);
                }

            }
            if (includePassport) {
                if (jobKeyName != null) {
                    dataMap.put(passportKeyName, RandomPassportGenerator.RandomPassport());
                } else {
                    dataMap.put("passport", RandomPassportGenerator.RandomPassport());
                }
            }
            if (includeCar) {
                if (carKeyName != null) {
                    dataMap.put(carKeyName, GenerateCar.generateRandomCar());
                } else {
                    dataMap.put("car", GenerateCar.generateRandomCar());
                }
            }
            if (includeFTeam) {
                if (fTeamKeyName != null) {
                    dataMap.put(fTeamKeyName, RandomFootballTeamGenerator.RandomTeam());
                } else {
                    dataMap.put("team", RandomFootballTeamGenerator.RandomTeam());
                }
            }

            if (includeIpv4) {
                if (ipv4KeyName != null) {
                    dataMap.put(ipv4KeyName, RandomIPGenerator.generateRandomIPv4());
                } else {
                    dataMap.put("ipv4", RandomIPGenerator.generateRandomIPv4());
                }
            }

            if (includeIpv6) {
                if (ipv6KeyName != null) {
                    dataMap.put(ipv6KeyName, RandomIPGenerator.generateRandomIPv6());
                } else {
                    dataMap.put("ipv6", RandomIPGenerator.generateRandomIPv6());
                }
            }

            if (includeMac) {
                if (macKeyName != null) {
                    dataMap.put(macKeyName, RandomIPGenerator.generateRandomMAC());
                } else {
                    dataMap.put("mac", RandomIPGenerator.generateRandomMAC());
                }
            }

            if (includeLocation) {
                if (locationKeyName != null) {
                    dataMap.put(locationKeyName,RandomLocation.getLocation());
                } else {
                    dataMap.put("location",RandomLocation.getLocation());
                }
            }


            if (includeMovieGen) {
                if (movieGenKeyName != null) {
                    dataMap.put(movieGenKeyName, RandomMovieGenerator.generateRandomMovieGenre());
                } else {
                    dataMap.put("movieType", RandomMovieGenerator.generateRandomMovieGenre());
                }
            }


            dataList.add(dataMap); // Add the data map to the list
        }

        if (dataList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.valueOf(400));
        }
        return new ResponseEntity<>(dataList, HttpStatus.OK);
    }


}
