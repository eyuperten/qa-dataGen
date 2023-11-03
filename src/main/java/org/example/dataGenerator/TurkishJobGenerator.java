package org.example.dataGenerator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Random;

public class TurkishJobGenerator {

    public static String SelectJob() {
        String url = "https://www.limasollunaci.com/ingilizce-meslekler";

        String[] jobArray = new String[68];

        try {

            int i= 0;
            Document document = Jsoup.connect(url).get();
            for (Element row : document.select(

                    "table.table.table-bordered tr")) {

                if (row.select("td:nth-of-type(3)").text().isEmpty())
                {
                    continue;
                }
                else
                {
                    String ticker = row.select("td:nth-of-type(3)").text();
                    jobArray[i] = ticker;
                    i++;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

     return selectRandomJob(jobArray);
    }
    public static String selectRandomJob(String[] jobArray) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(jobArray.length);
        return jobArray[randomIndex];
    }
}