package ru.liamin.vladimir;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;

/** Class implementing a graphical application */
public class FXMLController implements Initializable {

    @FXML
    private Label label = new Label();

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Slider slider;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(0);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setBlockIncrement(0.1);
        slider.valueProperty().addListener(new ChangeListener<Number>() {

            /**
             * Class changing progress bar
             * @param observable the ObservableValue which value changed
             * @param oldValue the old value of progress bar
             * @param newValue the new value of progress bar
             */
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                label.setText("Value: " + newValue);
                progressBar.setProgress((Double) newValue / 100);
            }
        });
    }
}