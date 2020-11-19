package week7.client;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.beans.EventHandler;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Controller {
    public Button send;
    public  TextArea ta;
    public TextField tf;

    private static DataInputStream isFromServer;
    private static DataOutputStream osToServer;


    public static void Start(){
        try {
            Socket connectToServer = new Socket("localhost",8000);
            isFromServer = new DataInputStream(
                    connectToServer.getInputStream()
            );

            osToServer = new DataOutputStream(
                    connectToServer.getOutputStream()
            );
            System.out.println("connection successful");

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
    public void PressedEnter(KeyEvent event){
        if (event.getCode() == KeyCode.ENTER){
            sendMessage();
        }
    }
    public void sendMessage(){
        String message = tf.getText();
        try {
            tf.clear();
            osToServer.writeUTF(message);
            osToServer.flush();

            String response = isFromServer.readUTF();
            ta.setText(response);
            System.out.println(response);
        } catch (IOException e) {
            tf.setText(message);
            System.out.println(e.getMessage());
            System.out.println("Something went wrong attempting to send message");
        }

    }

}
