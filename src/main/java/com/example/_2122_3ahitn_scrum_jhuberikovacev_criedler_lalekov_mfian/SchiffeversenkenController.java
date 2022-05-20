package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class SchiffeversenkenController {


    @FXML
    private GridPane gp;
    @FXML
    public void onClick(javafx.scene.input.MouseEvent event) {
        Node clickedNode = event.getPickResult().getIntersectedNode();

        if (clickedNode != gp) {
            // click on descendant node
            Integer colIndex = GridPane.getColumnIndex(clickedNode);
            Integer rowIndex = GridPane.getRowIndex(clickedNode);
            System.out.println("Mouse clicked cell: " + colIndex + " And: " + rowIndex);
        }
    }
}
