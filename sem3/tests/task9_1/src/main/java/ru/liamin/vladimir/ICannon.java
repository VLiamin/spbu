package ru.liamin.vladimir;

/** Interface for playing TicTacToe over the network */
public interface ICannon {

    /**
     * Sends given command
     * @param command your command
     */
    void send(String command);

    /** Returns received command. */
    String receive();
}
