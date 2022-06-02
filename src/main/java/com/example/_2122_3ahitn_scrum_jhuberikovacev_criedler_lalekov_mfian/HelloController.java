package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian;

import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model.Spiel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HelloController {
    public Label user;
    public TextField usereingabe;
    public Button createButton;
    public String[] playername = new String[2];
    public int createcounter = 0;
    public Spiel spiel;


    public void oncreateclick() throws IOException {

        playername[createcounter] = usereingabe.getText();
        usereingabe.setText("");

        createcounter++;
        if(createcounter==2){
            switchwindow();
        }
        user.setText("Enter name of player 2");
        createButton.setText("Create 2nd player");
    }

    private void switchwindow() throws IOException {
        new SchiffeversenkenApplication();
    }
}