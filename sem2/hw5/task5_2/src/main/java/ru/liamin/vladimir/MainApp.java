package ru.liamin.vladimir;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/** Graphic application class */
public class MainApp extends Application {

    /**
     * Graphical application method
     * @param stage variable for the GUI window
     * @throws Exception input / output exception
     */
    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/ru.liamin.vladimir/scene.fxml"));
        stage.setTitle("JavaFX Slider (ru.liamin.vladimir)");
        Scene scene = new Scene(root, 550, 200);

        stage.setMinWidth(450);
        stage.setMinHeight(100);
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Method showing the implementation of the graphical application
     * @param args args array of arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}