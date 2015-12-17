package days;

import util.ReadFromFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by gabri on 2015-12-12.
 */
public class Day2 implements Day {

    int h, l, w, total, slack, s1, s2, s3;

    @Override
    public void partOne(String input) {
        String[] sizes = input.split("x");
        l = Integer.parseInt(sizes[0]);
        w = Integer.parseInt(sizes[1]);
        h = Integer.parseInt(sizes[2]);

        s1 = l * w;
        s2 = w * h;
        s3 = h * l;


        if (s1 <= s2 && s1 <= s3) {
            slack = s1;
        } else if (s2 <= s3 && s2 <= s1) {
            slack = s2;
        } else if (s3 <= s1 && s3 <= s2) {
            slack = s3;
        }
        total += (2 * s1) + (2 * s2) + (2 * s3) + slack;
    }

    @Override
    public void partTwo(String input) {
        System.out.println("test");

    }

    @Override
    public void start(int day) {
        try {
            Scanner scanner = new Scanner(new File(ReadFromFile.PATH + day + ".txt"));
            while (scanner.hasNextLine()) {
                partOne(scanner.next());
            }
            //partOne("2x3x4");
            //partOne("1x1x10");
            System.out.println("Total: " + total);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
