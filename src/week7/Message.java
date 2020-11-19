package week7;

import java.util.Date;

public class Message {
    int id;
    String sender,body;
    Date dateTime;

    public Message(int id, String sender, String body, Date dateTime) {
        this.id = id;
        this.sender = sender;
        this.body = body;
        this.dateTime = dateTime;
    }

    public Message(String body) {
        this.body = body;
    }
}
