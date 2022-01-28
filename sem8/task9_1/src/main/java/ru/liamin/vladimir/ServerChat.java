package ru.liamin.vladimir;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class ServerChat {
    public static void main(String[] args) throws InterruptedException, IOException {
        Server server = ServerBuilder.forPort(2000).addService(new ServerWork()).build();

        server.start();
        server.awaitTermination();
    }
}
