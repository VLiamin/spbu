package ru.liamin.vladimir;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/** Graphic application class */
public class MainApp extends Application {

    /**
     * Graphical application method
     * @param primaryStage variable for the GUI window
     * @throws Exception exception of division by zero
     */
    @Override
    public void start(Stage primaryStage) throws ArithmeticException {

        ArithmeticSign subtraction = new ArithmeticSign('-', "-");
        ArithmeticSign addition = new ArithmeticSign('+', "+");
        ArithmeticSign multiplication = new ArithmeticSign('*', "*");
        ArithmeticSign division = new ArithmeticSign('/', "/");

        FlowPane root = new FlowPane();

        ObservableList<ArithmeticSign> sign
                = FXCollections.observableArrayList(subtraction, addition , multiplication, division);

        ChoiceBox<ArithmeticSign> choiceBox = new ChoiceBox<>(sign);
        choiceBox.setValue(subtraction);
        final Spinner<Integer> spinner1 = new Spinner<>();

        final int initialValue = 3;

        SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(-100, 100, initialValue);

        spinner1.setValueFactory(valueFactory);

        final Spinner<Integer> spinner2 = new Spinner<>();

        valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(-100, 100, initialValue);

        spinner2.setValueFactory(valueFactory);

        Label label = new Label("=");
        TextField textField = new TextField("");
        textField.setMinWidth(170);

        Calculate calculate = new Calculate();
        textField.setText("0");
        /** Handles the change in the first spinner */
        spinner1.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                try {
                    textField.setText(calculate.count(spinner1.getValue(), spinner2.getValue(), String.valueOf(choiceBox.getValue())));
                } catch (ArithmeticException e) {
                    textField.setText("Division by zero.");
                }
            }
        });

        /** Handles the change in the second spinner */
        spinner2.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                try {
                    textField.setText(calculate.count(spinner1.getValue(), spinner2.getValue(), String.valueOf(choiceBox.getValue())));
                } catch (ArithmeticException e) {
                    textField.setText("Division by zero.");
                }
            }
        });

        /** Handles the change in the choiceBox*/
        choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue observable, Number oldValue, Number newValue) {
                if (newValue.equals(0))
                    textField.setText(calculate.count(spinner1.getValue(), spinner2.getValue(), "-"));
                else if (newValue.equals(1))
                    textField.setText(calculate.count(spinner1.getValue(), spinner2.getValue(), "+"));
                else if (newValue.equals(2))
                    textField.setText(calculate.count(spinner1.getValue(), spinner2.getValue(), "*"));
                else
                    try {
                        textField.setText(calculate.count(spinner1.getValue(), spinner2.getValue(), "/"));
                    } catch (ArithmeticException e) {
                        textField.setText("Division by zero.");
                    }

            }
        });

        root.setPadding(new Insets(100));
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(spinner1, choiceBox, spinner2, label, textField);
        root.setPadding(new Insets(20));
        root.setHgap(10);

        primaryStage.setTitle("ChoiceBox (ru.liamin.vladimir)");
        Scene scene = new Scene(root, 700, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Method showing the implementation of the graphical application
     * @param args args array of arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

}
