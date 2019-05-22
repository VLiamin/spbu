package ru.liamin.vladimir;

public class Victory {

    public static String win(String[][] valueFromButtons) {

        if (checkX(valueFromButtons))
            return "X";
        if (check0(valueFromButtons))
            return "0";
        if (checkD(valueFromButtons))
            return "D";

        return "F";
    }

    private static boolean checkX(String[][] valueFromButton) {
        boolean symbol = false;
        for (int i = 0; i < valueFromButton.length; i++) {
            for (int j = 0; j < valueFromButton.length; j++) {
                if (valueFromButton[i][j] != "X")
                    break;
                if  (j == valueFromButton.length - 1)
                    symbol = true;
            }
        }
            if (symbol)
                return symbol;
        for (int j = 0; j < valueFromButton.length; j++) {
            for (int i = 0; i < valueFromButton.length; i++) {
                if (valueFromButton[i][j] != "X")
                    break;
                if  (i == valueFromButton.length - 1)
                    symbol = true;
            }
        }
        if (symbol)
            return symbol;

        for (int i = 0; i < valueFromButton.length; i++) {

            if (valueFromButton[i][i] != "X")
                break;
            if  (i == valueFromButton.length - 1)
                symbol = true;
        }
        for (int i = valueFromButton.length - 1; i >= 0; i--) {

            if (valueFromButton[i][i] != "X")
                break;
            if (i == 0)
                symbol = true;
        }

        return symbol;
    }

    private static boolean check0(String[][] valueFromButton) {
        boolean symbol = false;
        for (int i = 0; i < valueFromButton.length; i++) {
            for (int j = 0; j < valueFromButton.length; j++) {

                if (valueFromButton[i][j] != "0")
                    break;
                if (j == valueFromButton.length - 1)
                    symbol = true;
            }
        }

        if (symbol)
            return symbol;

        for (int i = 0; i < valueFromButton.length; i++) {
            for (int j = 0; j < valueFromButton.length; j++) {

                if (valueFromButton[j][i] != "0")
                    break;
                if (j == valueFromButton.length - 1)
                    symbol = true;
            }
        }
        if (symbol)
            return symbol;

        for (int i = 0; i < valueFromButton.length; i++) {

            if (valueFromButton[i][i] != "0")
                break;
            if  (i == valueFromButton.length - 1)
                symbol = true;
        }
        for (int i = valueFromButton.length - 1; i >= 0; i--) {

            if (valueFromButton[i][i] != "0")
                break;
            if (i == 0)
                symbol = true;
        }

        return symbol;
    }

    private static boolean checkD(String[][] valueFromButton) {
        boolean symbol = true;
        for (int i = 0; i < valueFromButton.length; i++) {
            for (int j = 0; j < valueFromButton.length; j++) {

                if ((valueFromButton[i][j] != "X") && (valueFromButton[i][j] != "0"))
                    symbol = false;
            }
        }
        return symbol;
    }
}