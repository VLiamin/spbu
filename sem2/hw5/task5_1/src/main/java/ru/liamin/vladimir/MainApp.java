package ru.liamin.vladimir;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/** Graphic application class */
public class MainApp extends Application {

    /**
     * Graphical application method
     * @param stage the primary stage for this application
     */
    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("Select Brightness:");

        Label infoLabel = new Label("Value: 0.0");

        Slider slider = new Slider();

        ProgressBar progressBar = new ProgressBar(0);

        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(0);

        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setBlockIncrement(0.1);

        // Adding Listener to value property.
        slider.valueProperty().addListener(new ChangeListener<Number>() {

            /**
             * Class changing progress bar
             * @param observable the ObservableValue which value changed
             * @param oldValue the old value of progress bar
             * @param newValue the new value of progress bar
             */
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                infoLabel.setText("Value: " + newValue);
                progressBar.setProgress((Double) newValue / 100);
            }
        });

        VBox root = new VBox();
        root.setPadding(new Insets(20));
        root.setSpacing(10);
        root.getChildren().addAll(label, slider, infoLabel, progressBar);//, progressBar);

        stage.setTitle("JavaFX Slider (ru.liamin.vladimir)");
        Scene scene = new Scene(root, 350, 200);
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
