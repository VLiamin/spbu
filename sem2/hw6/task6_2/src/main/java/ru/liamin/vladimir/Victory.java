package ru.liamin.vladimir;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import static java.lang.Math.abs;

public class Victory {
    private int total;

    public boolean win(int[] numbers, TextArea textArea, Button buttonOne, Button buttonTwo, Button buttonThree, Button buttonFour,
                       Button buttonFive, Button buttonSix, Button buttonSeven, Button buttonEight, Button buttonNine, int count) {
        if ((abs(numbers[0] + numbers[1] + (numbers[2])) == 3) ||
                (abs(numbers[3] + numbers[4] + numbers[5]) == 3) ||
                (abs(numbers[6] + numbers[7] + numbers[8]) == 3) ||
                (abs(numbers[2] + numbers[4] + numbers[6]) == 3) ||
                (abs(numbers[0] + numbers[4] + numbers[8]) == 3) ||
                (abs(numbers[0] + numbers[3] + numbers[6]) == 3) ||
                (abs(numbers[1] + numbers[4] + numbers[7]) == 3) ||
                (abs(numbers[3] + numbers[5] + numbers[8]) == 3)) {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = 0;
            }
            buttonOne.setText("");
            buttonTwo.setText("");
            buttonThree.setText("");
            buttonFour.setText("");
            buttonFive.setText("");
            buttonSix.setText("");
            buttonSeven.setText("");
            buttonEight.setText("");
            buttonNine.setText("");
            if (count % 2 == 1)
                textArea.setText("X win!");
            else
                textArea.setText("O win!");
            return true;

        }
        total = 0;
        for (int i = 0; i < numbers.length; i++) {
            total = total + abs(numbers[i]);
        }

        if (total == 9) {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = 0;
            }
            buttonOne.setText("");
            buttonTwo.setText("");
            buttonThree.setText("");
            buttonFour.setText("");
            buttonFive.setText("");
            buttonSix.setText("");
            buttonSeven.setText("");
            buttonEight.setText("");
            buttonNine.setText("");
            textArea.setText("Draw");
            return true;
        }
        return false;
    }
}
