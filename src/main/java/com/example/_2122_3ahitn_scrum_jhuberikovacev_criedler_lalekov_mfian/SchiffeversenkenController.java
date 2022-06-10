package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian;

import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.View.ViewField;
import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model.Spiel;
import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model.Spieler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class SchiffeversenkenController {
    Circle[][] circleFieldP1 = new Circle[10][10];
    Circle[][] circleFieldP2 = new Circle[10][10];
    ViewField viewFieldP1 = new ViewField(circleFieldP1);
    ViewField viewFieldP2 = new ViewField(circleFieldP2);
    ViewField currentView;
    protected int counter = 0;
    protected Spiel sp;
    @FXML
    protected GridPane gpP1;
    @FXML
    protected GridPane gpP2;


    public void setSp(Spiel spiel) {
        this.sp = spiel;
        sp.getSpieler()[0].getSpielfeld().fillWater();
        sp.getSpieler()[1].getSpielfeld().fillWater();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Circle cl = new Circle(14);
                cl.setFill(Color.BLUEVIOLET);
                circleFieldP1[i][j] = cl;
                gpP1.add(cl, i, j);
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Circle cl = new Circle(14);
                cl.setFill(Color.BLUEVIOLET);
                circleFieldP2[i][j] = cl;
                gpP2.add(cl, i, j);
            }
        }
        this.selectRightView();
    }


    @FXML
    public void onClick(javafx.scene.input.MouseEvent event) {
        boolean direction=Spieler.OBEN;

        Node clickedNode = event.getPickResult().getIntersectedNode();
        if (event.getButton() == MouseButton.SECONDARY) {
            if (direction == Spieler.OBEN) {
                direction = Spieler.LINKS;
            } else {
                direction = Spieler.OBEN;
            }


            if (clickedNode != gpP1 || clickedNode != gpP2) {
                // click on descendant node
                Integer colIndex = GridPane.getColumnIndex(clickedNode);
                Integer rowIndex = GridPane.getRowIndex(clickedNode);
                System.out.println(sp.getSpieler()[sp.getSpielerAmZug()].getName() + " shot:" + colIndex + " And: " + rowIndex);
                sp.getSpieler()[sp.getSpielerAmZug()].placeShip(sp.getSpieler()[sp.getSpielerAmZug()].getFlotte()[counter], rowIndex, colIndex, direction);
                sp.getSpieler()[sp.getSpielerAmZug()].guess(rowIndex, colIndex, sp.getSpieler()[sp.getSpielerNichtAmZug()]);
                this.selectRightView();
                currentView.checkHit(colIndex, rowIndex);
                sp.switchPlayer();
            }
        }
    }
        protected void selectRightView () {
            if (sp.getSpielerAmZug() == 0) {
                gpP2.setDisable(false);
                gpP1.setDisable(true);
                currentView = viewFieldP2;
            } else {
                gpP1.setDisable(false);
                gpP2.setDisable(true);
                currentView = viewFieldP2;
            }
        }


    }

