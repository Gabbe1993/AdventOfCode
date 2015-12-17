package days;

import util.ReadFromFile;

/**
 * Created by gabri on 2015-12-17.
 */
public class Day3 implements Day {
    int size = 10000;

    @Override
    public void partOne(String input) {
        char grid[][] = new char[size][size];
        int presents = 1;
        int x = size / 2, y = size / 2;
        grid[x][y] = 'x';
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '^':
                    y++;
                    break;
                case 'v':
                    y--;
                    break;
                case '>':
                    x++;
                    break;
                case '<':
                    x--;
                    break;
            }
            if (grid[x][y] != 'x') {
                presents++;
                grid[x][y] = 'x';
            }
        }
        System.out.println("presents = " + presents);
    }

    @Override
    public void partTwo(String input) {
        char[][] grid = new char[size][size];
        int presents = 1;
        Santa santa = new Santa(grid);
        Santa robo = new Santa(grid);

        for (int i = 0; i < input.length(); i++) {
            Santa currSanta = (i % 2 == 0) ? santa : robo;
            int x = currSanta.x;
            int y = currSanta.y;
            grid = currSanta.grid;

            switch (input.charAt(i)) {
                case '^':
                    y++;
                    break;
                case 'v':
                    y--;
                    break;
                case '>':
                    x++;
                    break;
                case '<':
                    x--;
                    break;
            }
            if (grid[x][y] != 'x') {
                presents++;
                currSanta.grid[x][y] = 'x';
            }
            currSanta.x = x;
            currSanta.y = y;
        }
        System.out.println("presents = " + presents);
    }

    class Santa {
        char[][] grid;
        int x = size / 2, y = size / 2;

        Santa(char[][] grid) {
            this.grid = grid;
            grid[x][y] = 'x';
        }
    }


    @Override
    public void start(int day) {
        String string = ReadFromFile.getInputLines(day);
        partTwo(string);

    }
}
