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

/** Game tic-tac-toe class */
public class FXMLController implements Initializable {
    private int count;

    @FXML
    private TextArea textArea;
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

    /**
     * Called to initialize a controller after its root element has been completely processed
     * @param url The location used to resolve relative paths for the root object
     * @param rb The resources used to localize the root object
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int[] numbers = new int[9];
        Victory victory = new Victory();

        ArrayList<Button> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix,
                buttonSeven, buttonEight, buttonNine));

        textArea.setEditable(false);


        for (Button button : arrayList)
            button.setOnAction(new EventHandler<ActionEvent>() {


                @Override
                public void handle(ActionEvent event) {
                    textArea.setText("");
                    if ((count % 2 == 0) && (numbers[arrayList.indexOf(button)] == 0)) {
                        button.setText("X");
                        numbers[arrayList.indexOf(button)]++;
                        count++;
                    } else if (numbers[arrayList.indexOf(button)] == 0) {
                        button.setText("O");
                        numbers[arrayList.indexOf(button)]--;
                        count++;
                    }
                    if (victory.win(numbers, textArea, arrayList, count))
                        count = 0;

                }
            });
    }
}