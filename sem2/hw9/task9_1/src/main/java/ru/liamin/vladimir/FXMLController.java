package ru.liamin.vladimir;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class FXMLController extends Application {

    private static Button serverField;
    private static Button clientField;
    private static Button connection;
    private static TextField ipAddress;
    private static GridPane connectScreen = new GridPane();
    private Scene scene = new Scene(connectScreen, 500, 200);

    private boolean isMyTurn = false;

    private static Button[][] buttons = new Button[3][3];

    private volatile TicTacToe ticTacToe;
    private final ExecutorService executor;

    public FXMLController() {
        executor = Executors.newFixedThreadPool(2);
    }

    /** Starts TicTacToe */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Connecting");
        primaryStage.setResizable(false);

        initialize();

        serverButtonAction();

        clientField.setOnAction(event -> {
            clientField.setDisable(true);
            serverField.setDisable(true);
            connection.setDisable(false);
            ipAddress.setDisable(false);
        });

        primaryStage.setScene(scene);
        primaryStage.show();

        connectButtonAction();
    }

    /** Creates a start window */
    private static void initialize() {
        connectScreen.setPadding(new Insets(25, 25, 25, 25));
        connectScreen.setHgap(25);
        connectScreen.setVgap(15);

        serverField = new Button();
        serverField.setText("Server field");
        serverField.setTextFill(Color.DARKBLUE);
        serverField.setPrefSize(230, connectScreen.getHeight() / 25 /*5*/);

        clientField = new Button();
        clientField.setText("Client field");
        clientField.setTextFill(Color.DARKBLUE);
        clientField.setPrefSize(230, connectScreen.getHeight() / 25 /*5*/);

        Label message = new Label("IP address: ");
        message.setTextFill(Color.DARKBLUE);

        ipAddress = new TextField();
        ipAddress.setDisable(true);

        connection = new Button("Connect");
        connection.setTextFill(Color.DARKBLUE);
        connection.setPrefSize(230, connectScreen.getHeight() / 25);
        connection.setDisable(true);

        connectScreen.add(serverField, 0, 0);
        connectScreen.add(clientField, 1, 0);
        connectScreen.add(message, 0, 1);
        connectScreen.add(connection, 1, 2);
        connectScreen.add(ipAddress, 0, 2);
    }

    /** Generates TicTacToe field and its functionality for server */
    private void gameForServer() {
        ticTacToe = new ServerTicTacToe();
        GridPane serverField = new GridPane();
        StackPane serverStackPane = new StackPane();
        Stage serverWindow = new Stage();
        serverWindow.setResizable(false);

        serverField = createField(serverField);
        serverStackPane.getChildren().add(serverField);
        Scene serverScene = new Scene(serverStackPane,300,300);

        serverWindow.setTitle("Server TicTacToe");
        serverWindow.setScene(serverScene);
        serverWindow.show();

        changeField("X");
        pressButtons("0");
    }

    /** Actions when starting the "Server field" button */
    private void serverButtonAction() {
        serverField.setOnAction(event -> {
            clientField.setDisable(true);

            InetAddress thisIp = null;

            try {
                thisIp = InetAddress.getLocalHost();
            } catch (UnknownHostException ex) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Can't get IP", ButtonType.CLOSE);
                alert.setHeaderText(null);
                alert.showAndWait();
                System.exit(1);
            }

            TextField ip = new TextField("Your IP address: " + thisIp.getHostAddress());
            connectScreen.add(ip,0,4);
            serverField.setDisable(true);
            gameForServer();
        });
    }

    /** Actions when the "Connect" button was pressed */
    private void connectButtonAction() {
        connection.setOnAction(event -> {
            String ipAddressText = ipAddress.getText();

            try {
                if (!InetAddress.getLocalHost().getHostAddress().equals(ipAddressText)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Wrong IP", ButtonType.CLOSE);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.showAndWait();
                    System.exit(1);
                }
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION,
                        "Couldn't get I/O for the connection to: " + ipAddressText, ButtonType.CLOSE);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.showAndWait();
                System.exit(1);
            }
            connection.setDisable(true);
            ipAddress.setDisable(true);
            ticTacToe = new ClientTicTacToe(ipAddressText);
            gameForClient();
        });
    }

    /** Generates tic-tac-toe field and its functionality for player */
    private void gameForClient() {
        Stage clientWindow = new Stage();
        clientWindow.setResizable(false);

        GridPane clientField = new GridPane();
        clientField.setMinSize(300, 300);
        clientField = createField(clientField);

        StackPane clientStackPane = new StackPane();
        clientStackPane.getChildren().add(clientField);

        Scene clientScene = new Scene(clientStackPane, 300, 300);

        clientWindow.setTitle("Client TicTacToe");
        clientWindow.setScene(clientScene);
        clientWindow.show();

        isMyTurn = true;

        changeField("0");
        pressButtons("X");

    }

    /**
     * The method that fills the buttons with player moves
     * @param symbol whose turn was now
     */
    private void pressButtons(String symbol) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int finalI = i;
                int finalJ = j;
                buttons[i][j].setOnAction(event -> {
                    if (buttons[finalI][finalJ].getText().equals("") && isMyTurn) {
                        buttons[finalI][finalJ].setText(symbol);
                        processCommand(finalI + " " + finalJ);
                        isMyTurn = !isMyTurn;
                        String whoWin = Victory.win(getValueFromButtons(), isMyTurn);
                        if ((whoWin == "X") || (whoWin == "0")) {
                            exitWindow(symbol, "Win!");
                        }

                        if (whoWin == "D") {
                            exitWindow(symbol, "Draw!");
                        }
                    }
                });
            }
        }
    }

    private void processCommand(String command) {
        ticTacToe.send(command);
    }

    /**
     * Shows a window about the end of the algorithm
     * @param symbol whose game result
     * @param state game result
     */
    private void exitWindow(String symbol, String state) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, null, ButtonType.CLOSE);
        alert.setTitle("exit");
        alert.setHeaderText(null);
        if (state.equals("Draw!")) {
            alert.setContentText(state);
        } else {
            alert.setContentText(symbol + state);
        }
        alert.showAndWait().ifPresent(response -> System.exit(1));
    }

    /** Fills the game cells with the results of opponent's moves */
    private void changeField(String symbol) {
        executor.execute(() -> {
            ticTacToe.send("hello");

            String result = "";
            while (!result.equals("exit")) {
                result = ticTacToe.receive();
                if (result == null) {
                    return;
                }
                String finalResult = result;
                Platform.runLater(() -> {
                    if (finalResult.matches("\\d \\d")) {
                        isMyTurn = true;
                        int[] coordinates = Stream.of(finalResult.trim().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
                        buttons[coordinates[0]][coordinates[1]].setText(symbol);
                        String whoWin = Victory.win(getValueFromButtons(), isMyTurn);
                        if ((whoWin == "X") || (whoWin == "0")) {
                            exitWindow(whoWin, "Lose");
                        }

                        if (whoWin == "D") {
                            exitWindow(symbol, "Draw");
                        }
                    }
                });
            }
        });
    }

    private static GridPane createField(GridPane gridPane) {
        gridPane.getColumnConstraints().add(new ColumnConstraints(100));
        gridPane.getRowConstraints().add(new RowConstraints(100));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new Button("");
                buttons[i][j].setPrefSize(100, 100);
                gridPane.add(buttons[i][j], i, j);
            }
        }
        return gridPane;
    }

    private String[][] getValueFromButtons() {
        String[][] valueFromButtons = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                valueFromButtons[i][j] = buttons[i][j].getText();
            }
        }
        return valueFromButtons;
    }

    public static void main(String[] args) {
        launch(args);
    }
}