package util;

import java.io.*;
import java.util.Scanner;

/**
 * Created by gabri on 2015-12-12.
 */
public class ReadFromFile {

    public static final String PATH = "C:/Users/gabri/Documents/Workspace/Advent/src/files/advent_day_";

    public static String getInputString(int day) {
        StringBuilder builder = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(PATH + day + ".txt"));
            while (scanner.hasNext()) {
                builder.append(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }

    public static String getInputLines(int day) {
        StringBuilder builder = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(PATH + day + ".txt"));
            while (scanner.hasNextLine()) {
                builder.append(scanner.nextLine() + '\n');
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }
}