package ru.liamin.vladimir;

import javafx.scene.control.Alert;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.TimerTask;
import java.util.Timer;

import static javafx.application.Application.launch;

/** Class for implementation of game part for server player */
public class ServerCannon extends TimerTask implements ICannon {

    public static final int PORT = 2000;
    private ServerSocket server;
    private Socket client;
    private BufferedReader input;
    private PrintWriter output;

    public static void main(String[] args) {
        launch(args);
    }

    /** Raises the server with the specified port */
    public ServerCannon() {

        try {
            server = new ServerSocket(PORT);
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

    public void run() {
        this.send("");
    }

    private void init() {

        if (client == null) {
            try {
                client = server.accept();
                input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                output = new PrintWriter(client.getOutputStream());
                Timer timer = new Timer(true);
                timer.scheduleAtFixedRate(this, 0, 5 * 1000);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }
}