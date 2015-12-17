package days;

import util.ReadFromFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by gabri on 2015-12-12.
 */
public class Day2 implements Day {

    private int total;
    private int s[] = new int[2];

    @Override
    public void partOne(String input) {
        String[] sizes = input.split("x");
        int l = Integer.parseInt(sizes[0]);
        int w = Integer.parseInt(sizes[1]);
        int h = Integer.parseInt(sizes[2]);

        int s1 = l * w;
        int s2 = w * h;
        int s3 = h * l;
        int slack;

        if (s1 <= s2 && s1 <= s3) {
            slack = s1;
        } else if (s2 <= s3 && s2 <= s1) {
            slack = s2;
        } else {
            slack = s3;
        }
        total += (2 * s1) + (2 * s2) + (2 * s3) + slack;
    }

    @Override
    public void partTwo(String input) {
        String[] sizes = input.split("x");
        int l = Integer.parseInt(sizes[0]);
        int w = Integer.parseInt(sizes[1]);
        int h = Integer.parseInt(sizes[2]);

        if(l <= w || l <= h) {
            s[0] = l;
            s[1] = (w <= h) ? w : h;
        } else {
            s[0] = w;
            s[1] = h;
        }
        int ribbon = 2 * s[0] + 2 * s[1];
        int bow = l * w * h;

        total += ribbon + bow;
    }

    @Override
    public void start(int day) {
        try {
            Scanner scanner = new Scanner(new File(ReadFromFile.PATH + day + ".txt"));
            while (scanner.hasNextLine()) {
                partTwo(scanner.next());
            }
            System.out.println("Total: " + total);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
