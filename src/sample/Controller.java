package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private GridPane gpnTest;

    public ArrayList<PianoKey> keys = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        int position = 0;
        addWhite(position);
        position++;
        addBlack(position);
        position++;
        addWhite(position);
        position +=2;

        for(int i = 0; i<7; i++){
            position = addOctave(position);
        }
        addWhite(position);


    }



    public int addOctave(int position){
        addWhite(position);
        position++;
        addBlack(position);
        position++;
        addWhite(position);
        position++;
        addBlack(position);
        position++;
        addWhite(position);
        position+=2;
        addWhite(position);
        position++;
        addBlack(position);
        position++;
        addWhite(position);
        position++;
        addBlack(position);
        position++;
        addWhite(position);
        position++;
        addBlack(position);
        position++;
        addWhite(position);
        position+=2;
        return position;
    }

    public void addBlack(int position){
        PianoKey key = new PianoKey(position, true);
        gpnTest.add(key, position, 0);
        gpnTest.setColumnSpan(key, 2);
        key.toFront();
        gpnTest.setMargin(key, new Insets(0, 7, 0, 7));
        keys.add(key);
        System.out.println(position);
    }

    public void addWhite(int position){
        PianoKey key = new PianoKey(position, false);
        gpnTest.add(key, position, 0);
        gpnTest.setColumnSpan(key, 2);
        gpnTest.setRowSpan(key, 2);
        key.toBack();
        keys.add(key);
        System.out.println(position);
    }
}
