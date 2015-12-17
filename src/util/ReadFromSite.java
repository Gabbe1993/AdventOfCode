package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

public class ReadFromSite {

    public static String getInputString(int day) {
        StringBuilder strBuilder = new StringBuilder();
        try {
            String urlString = "http://adventofcode.com/day/" + day + "/input";
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader((
                            new URL(urlString)).openConnection().getInputStream(), Charset.forName("UTF-8")));

            String inputLine;
            while ((inputLine = reader.readLine()) != null)
                strBuilder.append(inputLine);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strBuilder.toString();
    }

}
