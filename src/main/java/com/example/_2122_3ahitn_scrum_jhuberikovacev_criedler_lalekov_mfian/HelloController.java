package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian;

import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model.Spiel;
import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model.Spieler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.IOException;

public class HelloController {
    public Label user;
    public TextField usereingabe;
    public Button createButton;
    public String[] playername = new String[2];
    public int createcounter = 0;
    @FXML
    protected BorderPane backGround;

public void initialize(){
    /**
     *   Image img = new Image("");
     *     BackgroundImage bImg = new BackgroundImage(img,
     *             BackgroundRepeat.NO_REPEAT,
     *             BackgroundRepeat.NO_REPEAT,
     *             BackgroundPosition.DEFAULT,
     *             BackgroundSize.DEFAULT);
     *     Background bGround = new Background(bImg);
     *     backGround.setBackground(bGround);
     */
}


    public void oncreateclick() throws IOException {

        playername[createcounter] = usereingabe.getText();
        usereingabe.setText("");

        createcounter++;
        if(createcounter==2){
            Spieler sp1=new Spieler(playername[0]);
            Spieler sp2=new Spieler(playername[1]);
            Spiel spiel=new Spiel(sp1,sp2);

            new SchiffeversenkenApplication(spiel);
        }
        user.setText("Enter name of player 2");
        createButton.setText("Create 2nd player");


    }
}