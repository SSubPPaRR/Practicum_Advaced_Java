package week7.server;

import javafx.scene.control.TextArea;

public class FuckTask implements Runnable {
    String text;
    TextArea ta;

    public FuckTask(String text, TextArea ta) {
        this.text = text;
        this.ta = ta;
    }

    @Override
    public void run() {
        ta.setText(text);
    }
}
