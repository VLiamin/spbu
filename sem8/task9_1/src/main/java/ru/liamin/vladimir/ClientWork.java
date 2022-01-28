package ru.liamin.vladimir;

import com.example.grps.GreetingServiceGrpc;
import com.example.grps.HelloRequest;
import com.example.grps.HelloResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
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

public class ClientWork extends Application
{
    private ObservableList<String> messages = FXCollections.observableArrayList();
    private ListView<String> messagesView = new ListView<>();
    private TextField field = new TextField("Message");
    private TextField message = new TextField();
    private Button send = new Button();
    private String ip;
    private static final int PORT = 2000;

    /** Assigns IP address of the server */
    public ClientWork(String ipAddress) {
        this.ip = ipAddress;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        messagesView.setItems(messages);

        send.setText("Send");

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

        primaryStage.show();

        ManagedChannel channel = ManagedChannelBuilder.forAddress(ip, PORT).usePlaintext().build();
        GreetingServiceGrpc.GreetingServiceStub chatService = GreetingServiceGrpc.newStub(channel);
        StreamObserver<HelloRequest> chat = chatService.greeting(new StreamObserver<HelloResponse>() {
            @Override
            public void onNext(HelloResponse value) {
                Platform.runLater(() -> {
                    messages.add(value.getMessage());
                    messagesView.scrollTo(messages.size());
                });
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
                System.out.println("Disconnected");
            }

            @Override
            public void onCompleted() {
                System.out.println("Disconnected");
            }
        });

        send.setOnAction(e -> {
            chat.onNext(HelloRequest.newBuilder().setMessage(message.getText()).build());
            message.setText("");
        });
        primaryStage.setOnCloseRequest(e -> {chat.onCompleted(); channel.shutdown(); });
    }
}
