package week7.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatClient extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(loadFXML());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Chat Client");
        primaryStage.show();

        Controller.Start();



    }
    private static Parent loadFXML() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChatClient.class.getResource("client" + ".fxml"));
        return fxmlLoader.load();
    }
}
