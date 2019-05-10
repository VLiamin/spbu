package ru.liamin.vladimir;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;


/** Graphic application class */
public class MainApp extends Application {
    private int count;

    /**
     * Graphical application method
     * @param stage the primary stage for this application
     */
    @Override
    public void start(Stage stage) throws Exception {

        FlowPane root = new FlowPane();
        root.setPadding(new Insets(20));
        root.setHgap(10);
        root.setVgap(10);
        int[] numbers = new int[9];
        Victory victory = new Victory();
        Button buttonOne = new Button("");
        buttonOne.setPrefWidth(72);
        Button buttonTwo = new Button("");
        buttonTwo.setPrefWidth(72);
        Button buttonThree = new Button("");
        buttonThree.setPrefWidth(72);
        Button buttonFour = new Button("");
        buttonFour.setPrefWidth(72);
        Button buttonFive = new Button("");
        buttonFive.setPrefWidth(72);
        Button buttonSix = new Button("");
        buttonSix.setPrefWidth(72);
        Button buttonSeven = new Button("");
        buttonSeven.setPrefWidth(72);
        Button buttonEight = new Button("");
        buttonEight.setPrefWidth(72);
        Button buttonNine = new Button("");
        buttonNine.setPrefWidth(72);

        Paint value0 = Paint.valueOf("BBBBBB");
        TextArea textArea = new TextArea();
        textArea.setPrefRowCount(0);
        textArea.setPrefColumnCount(20);
        textArea.setEditable(false);
        textArea.setStyle("-fx-control-inner-background: #" + value0.toString().substring(2));
        buttonOne.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * Button click processing method
             * @param event push button
             */
            @Override
            public void handle(ActionEvent event) {
                textArea.setText("");
                if ((count % 2 == 0) && (numbers[0] == 0)) {
                    buttonOne.setText("X");
                    numbers[0]++;
                    count++;
                } else if (numbers[0] == 0) {
                    buttonOne.setText("O");
                    numbers[0]--;
                    count++;
                }
                if (victory.win(numbers, textArea, buttonOne, buttonTwo, buttonThree, buttonFour,
                        buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, count))
                    count = 0;

            }
        });

        /**
         * Button click processing method
         * @param event push button
         */
        buttonTwo.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                textArea.setText("");
                if ((count % 2 == 0) && (numbers[1] == 0)) {
                    buttonTwo.setText("X");
                    numbers[1]++;
                    count++;
                } else if (numbers[1] == 0) {
                    buttonTwo.setText("O");
                    numbers[1]--;
                    count++;
                }

                if (victory.win(numbers, textArea, buttonOne, buttonTwo, buttonThree, buttonFour,
                        buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, count))
                    count = 0;
            }
        });

        /**
         * Button click processing method
         * @param event push button
         */
        buttonThree.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                textArea.setText("");
                if ((count % 2 == 0) && (numbers[2] == 0)) {
                    buttonThree.setText("X");
                    numbers[2]++;
                    count++;
                } else if (numbers[2] == 0) {
                    buttonThree.setText("O");
                    numbers[2]--;
                    count++;
                }
                if (victory.win(numbers, textArea, buttonOne, buttonTwo, buttonThree, buttonFour,
                        buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, count))
                    count = 0;
            }
        });

        /**
         * Button click processing method
         * @param event push button
         */
        buttonFour.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                textArea.setText("");
                if ((count % 2 == 0) && (numbers[3] == 0)) {
                    buttonFour.setText("X");
                    numbers[3]++;
                    count++;
                } else if (numbers[3] == 0) {
                    buttonFour.setText("O");
                    numbers[3]--;
                    count++;
                }
                if (victory.win(numbers, textArea, buttonOne, buttonTwo, buttonThree, buttonFour,
                        buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, count))
                    count = 0;
            }
        });

        /**
         * Button click processing method
         * @param event push button
         */
        buttonFive.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                textArea.setText("");
                if ((count % 2 == 0) && (numbers[4] == 0)) {
                    buttonFive.setText("X");
                    numbers[4]++;
                    count++;
                } else if (numbers[4] == 0) {
                    buttonFive.setText("O");
                    numbers[4]--;
                    count++;
                }
                if (victory.win(numbers, textArea, buttonOne, buttonTwo, buttonThree, buttonFour,
                        buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, count))
                    count = 0;
            }
        });

        /**
         * Button click processing method
         * @param event push button
         */
        buttonSix.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                textArea.setText("");
                if ((count % 2 == 0) && (numbers[5] == 0)) {
                    buttonSix.setText("X");
                    numbers[5]++;
                    count++;
                } else if (numbers[5] == 0) {
                    buttonSix.setText("O");
                    numbers[5]--;
                    count++;
                }

                if (victory.win(numbers, textArea, buttonOne, buttonTwo, buttonThree, buttonFour,
                        buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, count))
                    count = 0;
            }
        });

        /**
         * Button click processing method
         * @param event push button
         */
        buttonSeven.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                textArea.setText("");
                if ((count % 2 == 0) && (numbers[6] == 0)) {
                    buttonSeven.setText("X");
                    numbers[6]++;
                    count++;
                } else if (numbers[6] == 0) {
                    buttonSeven.setText("O");
                    numbers[6]--;
                    count++;
                }
                if (victory.win(numbers, textArea, buttonOne, buttonTwo, buttonThree, buttonFour,
                        buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, count))
                    count = 0;
            }
        });

        /**
         * Button click processing method
         * @param event push button
         */
        buttonEight.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                textArea.setText("");
                if ((count % 2 == 0) && (numbers[7] == 0)) {
                    buttonEight.setText("X");
                    numbers[7]++;
                    count++;
                } else if (numbers[7] == 0) {
                    buttonEight.setText("O");
                    numbers[7]--;
                    count++;
                }

                if (victory.win(numbers, textArea, buttonOne, buttonTwo, buttonThree, buttonFour,
                        buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, count))
                    count = 0;
            }
        });

        /**
         * Button click processing method
         * @param event push button
         */
        buttonNine.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                textArea.setText("");
                if ((count % 2 == 0) && (numbers[8] == 0)) {
                    buttonNine.setText("X");
                    numbers[8]++;
                    count++;
                } else if (numbers[8] == 0) {
                    buttonNine.setText("O");
                    numbers[8]--;
                    count++;
                }

                if (victory.win(numbers, textArea, buttonOne, buttonTwo, buttonThree, buttonFour,
                        buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, count))
                    count = 0;
            }
        });


        root.getChildren().addAll(textArea, buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix,
                buttonSeven, buttonEight, buttonNine);

        stage.setTitle("Tic tac toe (ru.liamin.vladimir)");

        Scene scene = new Scene(root, 280, 180);
        stage.setMaxHeight(220);
        stage.setMaxWidth(300);
        stage.setMinHeight(220);
        stage.setMinWidth(300);
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