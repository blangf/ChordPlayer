package sample;

import javafx.event.EventHandler;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PianoKey extends Pane {
    public boolean isBlack;
    public boolean pressed = false;

    public int position;
    public String name;
    public double frequency;
    public double noteNr;

    public PianoKey(int position, boolean isBlack) {
        super();
        this.position = position;
        this.isBlack = isBlack;


        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                press();
            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                release();
            }
        });

        setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent mouseDragEvent) {
                press();
            }
        });

        setOnMouseDragExited(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent mouseDragEvent) {
                release();
            }
        });

        setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent mouseDragEvent) {
                release();
            }
        });

        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                release();
            }
        });


        if(isBlack){
            setStyle("-fx-background-color: black; -fx-background-radius: 0 0 2 2");
        } else {
            setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 0 1 1 0; -fx-background-radius: 0 0 5 5; -fx-border-radius: 0 0 5 5");
        }

    }

    public void press(){

        if(!pressed){

            InnerShadow shadow = new InnerShadow();

            if(isBlack){
                shadow.setColor(Color.WHITE);
                shadow.setWidth(50);
            }
            setEffect(shadow);
            System.out.println(name + " pressed");
            pressed = true;
        }
    }

    public void release(){
        if(pressed){
            setEffect(null);
            System.out.println(name + " released");
            pressed = false;
        }
    }


}
