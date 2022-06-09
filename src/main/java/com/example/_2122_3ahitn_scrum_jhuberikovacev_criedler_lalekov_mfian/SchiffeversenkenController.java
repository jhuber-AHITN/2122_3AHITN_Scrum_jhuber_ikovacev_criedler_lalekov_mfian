package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian;

import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.View.ViewField;
import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model.Spiel;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

public class SchiffeversenkenController {
    Circle[][] circleField = new Circle[10][10];
    protected Spiel sp;
    protected Circle gpP1;
    protected Circle gpP2;
    public void setSp(Spiel spiel) {
    this.sp=spiel;
    }
    @FXML
    public void initialize() {
                ViewField.setCircles(circleField);
                sp.getSpieler()[0].getSpielfeld().fillWater();
                sp.getSpieler()[1].getSpielfeld().fillWater();
    }


    @FXML
    public void onClick(javafx.scene.input.MouseEvent event) {
        Node clickedNode = event.getPickResult().getIntersectedNode();


        if (clickedNode != gpP1) {
            // click on descendant node
            Integer colIndex = GridPane.getColumnIndex(clickedNode);
            Integer rowIndex = GridPane.getRowIndex(clickedNode);
            System.out.println("Mouse clicked cell: " + colIndex + " And: " + rowIndex);
        }
    }


}

