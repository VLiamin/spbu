package ru.liamin.vladimir;

import java.util.List;
import java.util.Scanner;

/**
 * Class which executes the main logic of the game
 */
public class Life {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";

    private int size;
    private List<Integer> points;
    private int[][] point;
    private boolean isFinish = false;

    /**
     * Live class constructor
     * @param size the size of the field on which the game takes place
     * @param points cells that have life
     */
    public Life(int size, List<Integer> points) {
        this.size = size;
        this.points = points;
        point = new int[size][size];
    }

    /**
     *
     */
    public void startGame() {

        Scanner scanner = new Scanner(System.in);
        fillArray();

        while (true) {

            isFinish = true;
            print();
            System.out.println(ANSI_RESET + "Next iteration: 1\nExit: 0");
            System.out.print("Your number: ");

            if (scanner.nextInt() == 0)
                return;

            System.out.println();
            doNextIteration();

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    point[i][j] = 0;
                }
            }

            fillArray();

            if (isFinish) {
                System.out.println("The game is over");
                return;
            }
        }
    }

    private void fillArray() {

        for (int i = 0; i < size; i++) {
            for (int j = 1; j <= size; j++) {
                if (points.contains(i * size + j))
                    point[i][j - 1] = 1;
                else
                    point[i][j - 1] = 0;
            }
        }
    }

    private void print() {

        System.out.println(ANSI_RESET + "The cell is alive:" + ANSI_GREEN + " L");
        System.out.println(ANSI_RESET + "The cell is dead:" + ANSI_RED + " D");
        System.out.println();

        for (int i = 0; i < point.length; i++) {
            for (int j = 0; j < point.length; j++) {
                if (point[i][j] == 1)
                    System.out.print(ANSI_GREEN + "L ");
                else
                    System.out.print(ANSI_RED + "D ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void doNextIteration() {

        int i = 0;

        while (i < points.size()) {
            int cell = points.get(i);
            if (!checkPointToLive(cell)) {
                isFinish = false;
                points.remove((Integer) cell);
                i--;
            }
            i++;
        }

        for (int j = 0; j < size; j++) {
            for (int l = 0; l < size; l++) {
                if (point[j][l] == 0)
                    if (!checkPointToDead(j * size + l + 1)) {
                        isFinish = false;
                        points.add(j * size + l + 1);
                    }
            }
        }

    }

    private boolean checkPointToLive(int cell) {

        int count = 0;

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if ((cell - 1) % size + j >= 0 && ((cell - 1) % size + j < size) &&
                        (cell - 1) / size + i >= 0 && (cell - 1) / size + i < size) {
                    if (point[(cell - 1) / size + i][(cell - 1) % size + j] == 1)
                        count++;
                }
            }
        }

        if (count > 4 || count < 3)
            return false;

        return true;
    }

    private boolean checkPointToDead(int cell) {

        int count = 0;

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if ((cell - 1) % size + j >= 0 && ((cell - 1) % size + j < size) &&
                        (cell - 1) / size + i >= 0 && (cell - 1) / size + i < size) {
                    if (point[(cell - 1) / size + i][(cell - 1) % size + j] == 1)
                        count++;
                }
            }
        }

        if (count == 3)
            return false;

        return true;
    }
}
