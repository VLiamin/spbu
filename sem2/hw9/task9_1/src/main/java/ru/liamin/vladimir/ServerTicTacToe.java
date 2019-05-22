package ru.liamin.vladimir;

import javafx.scene.control.Alert;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static javafx.application.Application.launch;

/** Class for implementation of game part for server player */
public class ServerTicTacToe implements TicTacToe {

    public static final int PORT = 2000;
    private ServerSocket server;
    private Socket client;
    private BufferedReader input;
    private PrintWriter output;

    public static void main(String[] args) {

        launch(args);
    }

    /** Raises the server with the specified port */
    public ServerTicTacToe() {

        try {
            server = new ServerSocket(PORT);
            System.out.println("Address " + server.getInetAddress() + " Port " + server.getLocalPort());
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Error, the server is already running");
            alert.showAndWait();
            System.exit(1);
        }
    }

    /**
     * Sends given command
     * @param command your command
     */
    @Override
    public synchronized void send(String command) {

        init();
        output.println(command);
        output.flush();

    }

    /** Returns received command */
    @Override
    public String receive() {

        init();
        return input.lines().limit(1).findAny().orElse(null);
    }

    private void init() {

        if (client == null) {
            try {
                client = server.accept();
                input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                output = new PrintWriter(client.getOutputStream());
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }
}