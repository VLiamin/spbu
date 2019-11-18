package ru.liamin.vladimir;

import static java.lang.Math.abs;
import static java.lang.StrictMath.sqrt;

/** Class checking the game for the presence of the winner */
public class Victory {

    /**
     * Method who checks the game for a winner
     * @param valueFromButtons game cells (marked and empty)
     * @param isMyTurn whose turn
     * @return Is there a winner and who?
     */
    public static String win(String[][] valueFromButtons, boolean isMyTurn) {

        String[] newValueFromButtons = new String[valueFromButtons.length * valueFromButtons.length];
        int number = 0;
        for (int i = 0; i < valueFromButtons.length; i++)
            for (int j = 0; j < valueFromButtons.length; j++) {
                newValueFromButtons[number] = valueFromButtons[i][j];
                number++;
            }
        int total = 0;

        if ((checkForVictory(newValueFromButtons, 1, (int) sqrt(newValueFromButtons.length))) ||
                (checkForVictory(newValueFromButtons, (int) sqrt(newValueFromButtons.length) - 1, 0)) ||
                (checkForVictory(newValueFromButtons, (int) sqrt(newValueFromButtons.length) + 1, 0)) ||
                (checkForVictory(newValueFromButtons, (int) sqrt(newValueFromButtons.length), 1))) {

            if (isMyTurn)
                return "X";
            else
                return "0";

        }

        for (int i = 0; i < newValueFromButtons.length; i++) {
            if ((newValueFromButtons[i] == "0") || (newValueFromButtons[i] == "X"))
                total++;
        }
        if (total == newValueFromButtons.length)
            return "D";
        return "F";
    }

    private static boolean checkForVictory(String[] valueFromButtons, int numberOfCellsToSkip, int nextCell) {

        int trickCycles = (int) sqrt(valueFromButtons.length);
        if (nextCell == 0)
            trickCycles = 1;
        int start = 0;
        if (numberOfCellsToSkip == (int) sqrt(valueFromButtons.length) - 1)
            start = (int) sqrt(valueFromButtons.length) - 1;
        for (int i = 0; i < trickCycles; i++) {
            int count = 0;
            for (int j = nextCell * i + start; j < nextCell * i + numberOfCellsToSkip * (int) sqrt(valueFromButtons.length) + start; j = j + numberOfCellsToSkip) {
                if (valueFromButtons[j] == "X")
                    count = count + 1;
                else if (valueFromButtons[j] == "0")
                    count = count - 1;
            }
            if (abs(count) == sqrt(valueFromButtons.length))
                return true;
        }
        return false;
    }
}