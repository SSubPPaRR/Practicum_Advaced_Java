package week7.server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(loadFXML());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Chat Server");

        primaryStage.show();

        new Thread(this::connectToClient).start();


    }

    private void connectToClient() {
        new Controller().connectToClient();
    }


    private static Parent loadFXML() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChatServer.class.getResource("server" + ".fxml"));
        return fxmlLoader.load();
    }
}
