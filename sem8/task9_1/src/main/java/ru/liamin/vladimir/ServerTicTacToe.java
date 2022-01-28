package ru.liamin.vladimir;

import com.example.grps.GreetingServiceGrpc;
import com.example.grps.HelloRequest;
import com.example.grps.HelloResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import io.grpc.ServerBuilder;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ServerTicTacToe extends GreetingServiceGrpc.GreetingServiceImplBase
{
    private static final int PORT = 2000;
    private static Set<StreamObserver<HelloResponse>> observers = ConcurrentHashMap.newKeySet();

/*    private ObservableList<String> messages = FXCollections.observableArrayList();
    private ListView<String> messagesView = new ListView<>();
    private TextField field = new TextField("Message");
    private TextField message = new TextField();
    private Button send = new Button();*/

    @Override
    public StreamObserver<HelloRequest> greeting(StreamObserver<HelloResponse> responseObserver)
    {
        System.out.println("dkkdk");
        observers.add(responseObserver);

        /*Stage primaryStage = new Stage();
        BorderPane pane = new BorderPane();
        field.setEditable(false);
        pane.setLeft(field);
        pane.setCenter(message);
        pane.setRight(send);

        BorderPane root = new BorderPane();
        root.setCenter(messagesView);
        root.setBottom(pane);

        primaryStage.setTitle("Client");
        primaryStage.setScene(new Scene(root, 480, 320));

        primaryStage.show();*/

        return new StreamObserver<HelloRequest>() {
            @Override
            public void onNext(HelloRequest value) {
                System.out.println(value);
                HelloResponse message = HelloResponse.newBuilder()
                        .setMessage(value.getMessage())
                        .build();

                for (StreamObserver<HelloResponse> observer : observers) {
                    observer.onNext(message);
                }
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                observers.remove(responseObserver);
            }
        };
    }
}
