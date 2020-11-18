package week6;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Controller {
    public AnchorPane track = new AnchorPane();
    public GridPane raceCar = new GridPane();
    public Line path = new Line();

    public void drive(){
        //path.setLayoutX(0);
        path.setLayoutY(-1);
        path.setStartX(0);
        path.setStartY(0);
        path.setEndX(500);
        path.setEndY(0);
        PathTransition pt = new PathTransition(Duration.millis(10000),path,raceCar);
        pt.setCycleCount(5);
        pt.play();
       /* EventHandler<ActionEvent> eventHandler = e -> {
             if (raceCar.getLayoutX() == 0) {
                 raceCar.setLayoutX(track.getWidth()-raceCar.getWidth());
             }
             else {
                    raceCar.setLayoutX(0.0);
                 }
             };

        Timeline drive = new Timeline(new KeyFrame(Duration.seconds(3),eventHandler));
        drive.play();*/
    }
}
