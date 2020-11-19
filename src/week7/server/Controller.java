package week7.server;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Controller {
    public Button send;
    String response = "";
    public TextArea ta;
    public TextField tf;

    public String connectToClient(){

        try {
            ServerSocket serverSocket = new ServerSocket(8000);

            Socket connectToClientSocket = serverSocket.accept();

            DataInputStream isFromClient = new DataInputStream(
                    connectToClientSocket.getInputStream()
            );
            DataOutputStream osToClient = new DataOutputStream(
                    connectToClientSocket.getOutputStream()
            );
            ArrayList<String> messages = new ArrayList<>();

            //noinspection LoopStatementThatDoesntLoop
            while (true){
                String message = isFromClient.readUTF() + "\n";
                messages.add(message);


                for (String s:messages) {
                    response = response.concat(s);
                }

                System.out.println(response);
                osToClient.writeUTF(response);
                return response;
            }
        }
        catch (IOException e){
            e.getMessage();
            System.out.println("failed to start/run server");
        }
        return null;
    }

    public void sendMessage(ActionEvent event) {

    }
}
