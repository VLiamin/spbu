package ru.liamin.vladimir;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class that enters the initial data and runs the program
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> points = new ArrayList<>();
        int size;

        while (true) {
            System.out.print("Size of the field(size must be over 10 and under 33): ");
            size = scanner.nextInt();
            if (size >= 10 && size <= 33)
                break;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 1; j <= size; j++) {
                if (i * size + j >= 100)
                    System.out.print(i * size + j + " ");
                else if (i * size + j > 10)
                    System.out.print(i * size + j + "  ");
                else
                    System.out.print(i * size + j + "   ");
            }
            System.out.println();
        }

        System.out.println("\nWhich points will be alive?");
        outterLoop: while (true) {
            System.out.println("Exit: 0\nNext point: 1");
            System.out.print("Your number: ");

            switch (scanner.nextInt()) {
                case 0:
                    break outterLoop;
                case 1 :
                    System.out.print("Your point: ");
                    points.add(scanner.nextInt());
                    break;
            }

            System.out.println();
        }

        Life life = new Life(size, points);
        life.startGame();

    }
}
