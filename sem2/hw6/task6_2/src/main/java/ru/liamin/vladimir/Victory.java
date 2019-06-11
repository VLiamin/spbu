package ru.liamin.vladimir;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

import static java.lang.Math.abs;
import static java.lang.StrictMath.sqrt;

/** Class that checks the game for the presence of a winner */
public class Victory {

    /**
     * Method that checks the game is finished or not
     * @param numbers array of player turns
     * @param textArea textArea where results will be written
     * @param buttons buttons of the game
     * @param count whose turn was the last
     * @return is the game finished or not
     */
    public boolean win(int[] numbers, TextArea textArea, ArrayList<Button> buttons, int count) {
        int total = 0;
        if ((checkForVictory(numbers, 1, (int) sqrt(numbers.length))) ||
                (checkForVictory(numbers, (int) sqrt(numbers.length) - 1, 0)) ||
                (checkForVictory(numbers, (int) sqrt(numbers.length) + 1, 0)) ||
                (checkForVictory(numbers, (int) sqrt(numbers.length), 1))) {

            clearField(numbers, buttons);
            if (count % 2 == 1)
                textArea.setText("X win!");
            else
                textArea.setText("O win!");
            return true;

        }

        for (int i = 0; i < numbers.length; i++) {
            total = total + abs(numbers[i]);
        }

        if (total == numbers.length) {
            textArea.setText("Draw!");
            clearField(numbers, buttons);
            return true;
        }
        return false;
    }

    private void clearField(int[] numbers, ArrayList<Button> buttons) {

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = 0;
        }

        for (Button button : buttons) {

            button.setText("");
        }
    }

    /**
     * Method that checks the game for the presence of a winner
     * @param numbers array of player turns
     * @param numberOfCellsToSkip how many cells should be skipped at each iteration of the cycle
     * @param nextCell the cell from where the next check will be started
     * @return is there a winner or not
     */
    public boolean checkForVictory(int[] numbers, int numberOfCellsToSkip, int nextCell) {

        int trickCycles = (int) sqrt(numbers.length);
        if (nextCell == 0)
            trickCycles = 1;
        int start = 0;
        if (numberOfCellsToSkip == (int) sqrt(numbers.length) - 1)
            start = (int) sqrt(numbers.length) - 1;
        for (int i = 0; i < trickCycles; i++) {
            int count = 0;
            for (int j = nextCell * i + start; j < nextCell * i + numberOfCellsToSkip * (int) sqrt(numbers.length) + start; j = j + numberOfCellsToSkip) {

                count = count + numbers[j];
            }

            if (abs(count) == (int) sqrt(numbers.length))
                return true;
        }
        return false;
    }
}
