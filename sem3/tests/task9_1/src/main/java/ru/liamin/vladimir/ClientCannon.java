package ru.liamin.vladimir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

import static javafx.application.Application.launch;

public class ClientCannon extends TimerTask implements ICannon {

    private Socket client;
    private PrintWriter output;
    private BufferedReader input;
    private String ipAddress;

    public static void main(String[] args) {
        launch(args);
    }

    /** Assigns IP address of the server */
    public ClientCannon(String ipAddress) {
        this.ipAddress = ipAddress;
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
        InetAddress inetAddress = null;
        if (client == null) {
            try {
                client = new Socket(inetAddress = InetAddress.getByName(ipAddress), ServerCannon.PORT);

                output = new PrintWriter(client.getOutputStream());
                input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                Timer timer = new Timer(true);
                timer.scheduleAtFixedRate(this, 0, 5 * 1000);
            } catch (UnknownHostException e) {
                assert ipAddress != null;
                System.err.println("Do not know about host: " + inetAddress.getHostAddress());
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Could not get I/O for the connection to: " + inetAddress.getHostAddress());
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
    }

    @Override
    public void run() {
        this.send("");
    }
}
