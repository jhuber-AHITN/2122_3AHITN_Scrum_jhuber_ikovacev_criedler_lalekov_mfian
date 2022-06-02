package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian;

import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model.Spieler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class SchiffeversenkenController {


    @FXML
    private GridPane gp;
    Spieler sp;
    Circle[][] circleField;

    @FXML
    public void initialize() {
        circleField=new Circle[10][10];
        sp = new Spieler("Consti");
        sp.getSpielfeld().fillWater();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Circle cl = new Circle(14);
                cl.setFill(Color.BLUEVIOLET);
                circleField[i][j]= cl;
                gp.add(cl, i, j);
            }
        }
    }

    @FXML
    public void onClick(javafx.scene.input.MouseEvent event) {
        Node clickedNode = event.getPickResult().getIntersectedNode();
        if (clickedNode != gp) {
            // click on descendant node
            Integer colIndex = GridPane.getColumnIndex(clickedNode);
            Integer rowIndex = GridPane.getRowIndex(clickedNode);
            int guess = sp.guess(rowIndex, colIndex, sp);
            Color cl=Color.BLUEVIOLET;
            switch (guess){
                case 3:
                    cl=Color.RED;break;
                case 2:
                    cl=Color.GRAY;break;
            }
            circleField[colIndex][rowIndex].setFill(cl);
            System.out.println("Mouse clicked cell: " + rowIndex + " And: " + colIndex);
        }
    }

}
