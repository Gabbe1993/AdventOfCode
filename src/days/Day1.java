package days;

import util.ReadFromFile;

public class Day1 implements Day {

    @Override
    public void partOne(String input) {
        int floor = 0;
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '(':
                    floor++;
                    break;
                case ')':
                    floor--;
                    break;
            }
        }
        System.out.println("Part one: " + floor);
    }

    @Override
    public void partTwo(String input) {
        int floor = 0;
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '(':
                    floor++;
                    break;
                case ')':
                    floor--;
                    break;
            }
            if (floor == -1) {
                System.out.println("Position: " + i + 1);
                return;
            }
        }
    }

    @Override
    public void start(int day) {
        String string = ReadFromFile.getInputString(day);
        partOne(string);
        partTwo(string);
    }
}
