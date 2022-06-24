package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian;

import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.View.ViewAction;
import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model.Spiel;
import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model.Spieler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.IOException;

public class HelloController {
    public static ViewAction action;
    public Label user;
    public TextField usereingabe;
    public Button createButton;
    public String[] playername = new String[2];
    public int createcounter = 0;
    @FXML
    protected BorderPane backGround;
    @FXML
    protected Label labelForError;

public void initialize(){
    labelForError.setTextFill(Color.RED);
    action=new ViewAction();
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

    /**
     * Creates the 2 users for the game ships sink
     * @throws IOException gets thrown if there are problems when giving "spiel" to SchiffeversenkenApplication
     * */

    public void oncreateclick() {
    try {
        if (usereingabe.getText().length() == 0) {
            HelloController.action.setLabel(labelForError, "Input a Name!");
        } else {
            playername[createcounter] = usereingabe.getText();
            usereingabe.setText("");
            createcounter++;

        }
        if (createcounter == 1) {
            user.setText("Enter name of player 2");
            createButton.setText("Create 2nd player");
            HelloController.action.setLabel(labelForError, "");

        } else if (createcounter == 2) {
            Spieler sp1 = new Spieler(playername[0]);
            Spieler sp2 = new Spieler(playername[1]);
            Spiel spiel = new Spiel(sp1, sp2);

            new SchiffeversenkenApplication(spiel);
        }
    } catch ( IOException e){
        e.printStackTrace();

    }
    }
}