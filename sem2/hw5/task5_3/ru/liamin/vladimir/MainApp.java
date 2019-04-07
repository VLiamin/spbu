package ru.liamin.vladimir;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/** Graphic application class */
public class MainApp extends Application {

    private int count;
    private int signNumber;

    /**
     * Graphical application method
     * @param stage stage the primary stage for this application
     * @throws Exception exception of division by zero
     */
    @Override
    public void start(Stage stage) throws ArithmeticException {
        List list = new List();
        Calculate calculate = new Calculate();
        FlowPane root = new FlowPane();
        root.setPadding(new Insets(5));
        root.setHgap(5);
        root.setVgap(10);

        TextArea textArea = new TextArea();
        textArea.setPrefRowCount(1);
        textArea.setPrefColumnCount(31);
        textArea.setText(String.format("Calculator ready to help you"));

        Button buttonOne = new Button("1");
        buttonOne.setPrefWidth(70);

        Button buttonTwo = new Button("2");
        buttonTwo.setPrefWidth(70);

        Button buttonThree = new Button("3");
        buttonThree.setPrefWidth(70);

        Button buttonFour = new Button("4");
        buttonFour.setPrefWidth(70);

        Button buttonFive = new Button("5");
        buttonFive.setPrefWidth(70);

        Button buttonSix = new Button("6");
        buttonSix.setPrefWidth(70);

        Button buttonSeven = new Button("7");
        buttonSeven.setPrefWidth(70);

        Button buttonEight = new Button("8");
        buttonEight.setPrefWidth(70);

        Button buttonNine = new Button("9");
        buttonNine.setPrefWidth(70);

        Button buttonZero = new Button("0");
        buttonZero.setPrefWidth(70);

        /** Number one processing */
        buttonOne.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (count % 2 == 0)
                    count++;
                if (signNumber != 1)
                    list.push(1, 'b', count);
                else
                    list.push(-1, 'b', count);
                signNumber = 0;
                list.printList(textArea);
            }
        });

        /** Number two processing */
        buttonTwo.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (count % 2 == 0)
                    count++;
                if (signNumber != 1)
                    list.push(2, 'b', count);
                else
                    list.push(-2, 'b', count);
                signNumber = 0;
                list.printList(textArea);
            }
        });

        /** Number three processing */
        buttonThree.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (count % 2 == 0)
                    count++;
                if (signNumber != 1)
                    list.push(3, 'b', count);
                else
                    list.push(-3, 'b', count);
                signNumber = 0;
                list.printList(textArea);
            }
        });

        /** Number four processing */
        buttonFour.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (count % 2 == 0)
                    count++;
                if (signNumber != 1)
                    list.push(4, 'b', count);
                else
                    list.push(-4, 'b', count);
                signNumber = 0;
                list.printList(textArea);
            }
        });

        /** Number five processing */
        buttonFive.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (count % 2 == 0)
                    count++;
                if (signNumber != 1)
                    list.push(5, 'b', count);
                else
                    list.push(-5, 'b', count);
                signNumber = 0;
                list.printList(textArea);
            }
        });

        /** Number six processing */
        buttonSix.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (count % 2 == 0)
                    count++;
                if (signNumber != 1)
                    list.push(6, 'b', count);
                else
                    list.push(-6, 'b', count);
                signNumber = 0;
                list.printList(textArea);
            }
        });

        /** Number seven processing */
        buttonSeven.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (count % 2 == 0)
                    count++;
                if (signNumber != 1)
                    list.push(7, 'b', count);
                else
                    list.push(-7, 'b', count);
                signNumber = 0;
                list.printList(textArea);
            }
        });

        /** Number eight processing */
        buttonEight.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (count % 2 == 0)
                    count++;
                if (signNumber != 1)
                    list.push(8, 'b', count);
                else
                    list.push(-8, 'b', count);
                signNumber = 0;
                list.printList(textArea);
            }
        });

        /** Number nine processing */
        buttonNine.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (count % 2 == 0)
                    count++;
                if (signNumber != 1)
                    list.push(9, 'b', count);
                else
                    list.push(-9, 'b', count);
                signNumber = 0;
                list.printList(textArea);
            }
        });

        /** Number zero processing */
        buttonZero.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (count % 2 == 0)
                    count++;
                list.push(0, 'b', count);
                list.printList(textArea);
            }
        });

        Button buttonAddition = new Button("+");
        buttonAddition.setPrefWidth(70);

        /** Addition operation processing */
        buttonAddition.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (count % 2 == 1)
                    count++;
                list.push(0, '+', count);
                list.printList(textArea);
            }
        });

        Button buttonSubtraction = new Button("-");
        buttonSubtraction.setPrefWidth(70);

        /** Subtraction operation processing */
        buttonSubtraction.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
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

        Button buttonMultiplication = new Button("*");
        buttonMultiplication.setPrefWidth(70);

        /** Multiplication operation processing */
        buttonMultiplication.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (count % 2 == 1)
                    count++;
                list.push(0, '*', count);
                list.printList(textArea);
            }
        });

        Button buttonDivision = new Button("/");
        buttonDivision.setPrefWidth(70);

        /** Division operation processing */
        buttonDivision.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (count % 2 == 1)
                    count++;
                list.push(0, '/', count);
                list.printList(textArea);
            }
        });

        Button buttonEqual = new Button("=");
        buttonEqual.setPrefWidth(70);

        /** Result calculation */
        buttonEqual.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (count % 2 == 1) {
                    list.sortList();
                    count = 1;
                    try {
                        textArea.setText(String.valueOf(calculate.countExpression(list)));
                    } catch (ArithmeticException e) {
                        textArea.setText("Division by zero.");
                        count = 0;
                        list.clear();
                    }
                }
            }
        });

        root.getChildren().addAll(textArea, buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven,
                buttonEight, buttonNine, buttonZero, buttonAddition, buttonSubtraction, buttonMultiplication, buttonDivision, buttonEqual);

        stage.setTitle("Java Calculate (ru.liamin.vladimir)");

        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Method showing the implementation of the graphical application
     * @param args args array of arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}