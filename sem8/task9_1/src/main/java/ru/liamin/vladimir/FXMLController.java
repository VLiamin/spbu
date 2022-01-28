package ru.liamin.vladimir;

import java.awt.*;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptors;
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

import javax.swing.*;

import static java.lang.System.*;
import static java.lang.Thread.sleep;

public class FXMLController extends Application {

    private static Button serverField;
    private static Button clientField;
    private static Button connection;
    private static TextField ipAddress;
    private static GridPane connectScreen = new GridPane();
    private Scene scene = new Scene(connectScreen, 500, 200);

    private static final int PORT = 2000;

    /**
     * Starts TicTacToe
     */
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

    @Override
    public void stop() {
        System.exit(0);
    }

    /**
     * Creates a start window
     */
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

    /**
     * Generates TicTacToe field and its functionality for server
     */
    private void gameForServer() throws IOException, InterruptedException {
        System.out.println("Server started");

/*        Server server = ServerBuilder.forPort(PORT)
                .addService(new ServerWork())
                .build()
                .start();
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.err.println("*** shutting down grpc server since JVM is shutting down");
            FXMLController.this.stop();
            System.err.println("*** server shut down");
        }));*/
    //    Server server = ServerBuilder.forPort(2000).addService(new ServerWork()).build();

    //    server.start();
    }

    /**
     * Actions when starting the "Server field" button
     */
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
                exit(1);
            }

            TextField ip = new TextField("Your IP address: " + thisIp.getHostAddress());
            connectScreen.add(ip, 0, 4);
            serverField.setDisable(true);
            try {
                gameForServer();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Actions when the "Connect" button was pressed
     */
    private void connectButtonAction() {
        connection.setOnAction(event -> {
            String ipAddressText = ipAddress.getText();

            try {
                if (!InetAddress.getLocalHost().getHostAddress().equals(ipAddressText)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Wrong IP", ButtonType.CLOSE);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.showAndWait();
                    exit(1);
                }
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION,
                        "Couldn't get I/O for the connection to: " + ipAddressText, ButtonType.CLOSE);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.showAndWait();
                exit(1);
            }
            connection.setDisable(true);
            ipAddress.setDisable(true);
            gameForClient(ipAddressText);
        });
    }

    /**
     * Generates tic-tac-toe field and its functionality for player
     */
    private void gameForClient(String ip)
    {
        ClientWork client = new ClientWork(ip);
        client.start(new Stage());
    }



    public static void main(String[] args) {
        launch(args);
    }
}