package ru.liamin.vladimir;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/** Class implementing a graphical application */
public class FXMLController implements Initializable {

    @FXML
    private TextField textField;

    @FXML
    private ChoiceBox<ArithmeticSign> choiceBox;

    @FXML
    private Spinner<Integer> spinner1;
    @FXML
    private Spinner<Integer> spinner2;

    /**
     * Called to initialize a controller after its root element has been completely processed
     * @param url The location used to resolve relative paths for the root object
     * @param rb The resources used to localize the root object
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ArithmeticSign subtraction = new ArithmeticSign('-', "-");
        ArithmeticSign addition = new ArithmeticSign('+', "+");
        ArithmeticSign multiplication = new ArithmeticSign('*', "*");
        ArithmeticSign division = new ArithmeticSign('/', "/");

        ObservableList<ArithmeticSign> sign
                = FXCollections.observableArrayList(subtraction, addition, multiplication, division);

        choiceBox.setItems(sign);
        choiceBox.setValue(subtraction);

        final int initialValue = 3;

        SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(-100, 100, initialValue);

        spinner1.setValueFactory(valueFactory);

        valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(-100, 100, initialValue);

        spinner2.setValueFactory(valueFactory);
        ArrayList<Spinner> arrayList = new ArrayList<>();
        arrayList.add(spinner1);
        arrayList.add(spinner2);
        textField.setMinWidth(170);

        Calculate calculate = new Calculate();
        textField.setText("0");
        /** Handles the change in all spinner */
        for (Spinner spinner : arrayList)
            spinner.valueProperty().addListener(new ChangeListener<Number>() {

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
    }
}