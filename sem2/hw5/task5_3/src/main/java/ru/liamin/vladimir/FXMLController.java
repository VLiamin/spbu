package ru.liamin.vladimir;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class FXMLController implements Initializable {

    private int count;
    private int signNumber;
    private int lastValue;
    private char lastOperation = '\b';
    @FXML
    private TextArea textArea;
    @FXML
    private Button buttonZero;
    @FXML
    private Button buttonOne;
    @FXML
    private Button buttonTwo;
    @FXML
    private Button buttonThree;
    @FXML
    private Button buttonFour;
    @FXML
    private Button buttonFive;
    @FXML
    private Button buttonSix;
    @FXML
    private Button buttonSeven;
    @FXML
    private Button buttonEight;
    @FXML
    private Button buttonNine;
    @FXML
    private Button buttonAddition;
    @FXML
    private Button buttonDivision;
    @FXML
    private Button buttonEqual;
    @FXML
    private Button buttonMultiplication;
    @FXML
    private Button buttonSubtraction;

    /**
     * Called to initialize a controller after its root element has been completely processed
     * @param url The location used to resolve relative paths for the root object
     * @param rb The resources used to localize the root object
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textArea.setEditable(false);
        List list = new List();
        Calculate calculate = new Calculate();

        ArrayList<Button> arrayList = new ArrayList<>();

        arrayList.addAll(Arrays.asList(buttonZero, buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix,
                buttonSeven, buttonEight, buttonNine));

        /** Number one processing */
        for (Button button : arrayList)
            button.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    if (count % 2 == 0)
                        lastValue = 0;
                    lastValue = lastValue + arrayList.indexOf(button);
                    if (count % 2 == 0)
                        count++;
                    if (signNumber != 1)
                        list.push(arrayList.indexOf(button), 'b', count);
                    else
                        list.push(-arrayList.indexOf(button), 'b', count);
                    list.printList(textArea);
                }
            });


        /** Addition operation processing */
        buttonAddition.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                lastOperation = '+';
                signNumber = 0;
                count(list, textArea, calculate, false);
                if (count % 2 == 1)
                    count++;
                list.push(0, '+', count);
                list.printList(textArea);
            }
        });

        /** Subtraction operation processing */
        buttonSubtraction.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                lastOperation = '-';
                signNumber = 0;
                count(list, textArea, calculate, false);
                if (count % 2 == 1)
                    count++;
                if (count == 0) {
                    signNumber = 1;
                    textArea.setText("-");
                } else {
                    list.push(0, '-', count);
                    list.printList(textArea);
                }
            }
        });

        /** Multiplication operation processing */
        buttonMultiplication.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                lastOperation = '*';
                signNumber = 0;
                count(list, textArea, calculate, false);
                if (count % 2 == 1)
                    count++;
                list.push(0, '*', count);
                list.printList(textArea);
            }
        });

        /** Division operation processing */
        buttonDivision.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                lastOperation = '/';
                signNumber = 0;
                count(list, textArea, calculate, false);
                if (count % 2 == 1)
                    count++;
                list.push(0, '/', count);
                list.printList(textArea);
            }
        });

        /** Result calculation */
        buttonEqual.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                count(list, textArea, calculate, true);
            }
        });
    }

    private void count(List list, TextArea textArea, Calculate calculate, Boolean isEqual) {

        if ((count % 2 == 1) && (count > 2)) {
            list.sortList();
            count = 1;
            try {
                textArea.setText(String.valueOf(calculate.countExpression(list)));
            } catch (ArithmeticException e) {
                textArea.setText("Division by zero.");
                count = 0;
                list.clear();
            }
        } else if ((lastOperation != '\b') && (lastValue != 0) && (count % 2 == 1) && (isEqual)) {

            count++;
            list.push(0, lastOperation, count);
            count++;
            list.push(lastValue, 'b', count);
            list.sortList();
            count = 1;
            textArea.setText(String.valueOf(calculate.countExpression(list)));

        }
    }
}