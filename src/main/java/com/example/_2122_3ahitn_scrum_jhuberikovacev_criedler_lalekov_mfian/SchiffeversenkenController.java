package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian;

import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model.Spiel;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

public class SchiffeversenkenController {

    protected Spiel sp;


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

            /*
            import javafx.stage.Stage;
            import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.input.*;

var r = Rectangle {
    x: 50, y: 50
    width: 120, height: 120
    fill: Color.RED
    onMouseClicked: function(e:MouseEvent):Void {
        if (e.button == MouseButton.SECONDARY) {
            println("Right button clicked");
        }
    }
}

Stage {
    title : "ClickTest"
    scene: Scene {
        width: 200
        height: 200
        content: [ r ]
    }
}
             */
        }
    }

    public void setSp(Spiel sp) {
        this.sp = sp;
    }
}
