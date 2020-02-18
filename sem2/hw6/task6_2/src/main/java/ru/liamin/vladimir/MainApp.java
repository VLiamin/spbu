package ru.liamin.vladimir;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** Graphic application class */
public class MainApp extends Application {


    /**
     * Graphical application method
     * @param stage the primary stage for this application
     */
    @Override
    public void start(Stage stage) throws Exception {


        Parent root = FXMLLoader.load(getClass().getResource("/ru.liamin.vladimir/scene.fxml"));
        stage.setTitle("JavaFX Tic Tac Toe (ru.liamin.vladimir)");
        Scene scene = new Scene(root, 500, 500);

        stage.setMinWidth(200);
        stage.setMinHeight(400);
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