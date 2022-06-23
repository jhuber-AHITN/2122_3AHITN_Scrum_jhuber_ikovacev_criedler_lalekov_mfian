package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian;

import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.View.ViewField;
import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model.Spiel;
import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model.Spieler;
import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model.Spielfeld;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class SchiffeversenkenController implements Initializable {
    public TextField error;
    public TextField currentdirection;
    Circle[][] circleFieldP1 = new Circle[10][10];
    Circle[][] circleFieldP2 = new Circle[10][10];
    ViewField viewFieldP1 = new ViewField(circleFieldP1);
    ViewField viewFieldP2 = new ViewField(circleFieldP2);
    ViewField currentView;
    protected int counter1 = 0;

    protected Spiel sp;
    @FXML
    protected GridPane gpP1;
    @FXML
    protected GridPane gpP2;
    boolean direction;
    protected int amountOfShipsPlaced = 0;


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
        direction = Spieler.OBEN;
    }


    @FXML
    public void onClick(javafx.scene.input.MouseEvent event) {
        Node clickedNode = event.getPickResult().getIntersectedNode();


        if (event.getButton() == MouseButton.SECONDARY) {
            if (direction == Spieler.OBEN) {
                direction = Spieler.LINKS;
                currentdirection.setText("Direction changed: Left to right");
            } else {
                direction = Spieler.OBEN;
                currentdirection.setText("Direction changed: Up to down");
            }
        }

        if ((clickedNode != gpP1 || clickedNode != gpP2) && event.getButton() == MouseButton.PRIMARY) {
            // click on descendant node
            //null pointer exception bei rowindex
            Integer colIndex =  GridPane.getColumnIndex(clickedNode);
            Integer rowIndex =  GridPane.getRowIndex(clickedNode);
            if (sp.isStarted()) {
                this.shoot(rowIndex, colIndex);
            } else {
                this.placeShip(rowIndex, colIndex, direction);
            }


        }
    }


    protected void selectRightView() {
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

    public void placeShip(int row, int col, boolean direction) {
        boolean success;
        boolean secondplayer = false;

        if (amountOfShipsPlaced == 10) {
            this.selectRightView();
            sp.switchPlayer();
            secondplayer = true;
            counter1 = 0;
        }
        System.out.println(row+" "+col);
        success = sp.getSpieler()[sp.getSpielerAmZug()].placeShip(sp.getSpieler()[sp.getSpielerAmZug()].getFlotte()[counter1], row, col, direction);
        System.out.println(success);

        if (success) {
            error.setText("shipplaced");
            if (direction== Spieler.OBEN){

            }
//            for (int i = 0; i < 10; i++) {
//                for (int j = 0; j < 10; j++) {
//                    if (sp.getSpieler()[sp.getSpielerAmZug()].getSpielfeld().getField()[i][j] == Spielfeld.SHIP) {
//                        if (!secondplayer) {
//                            Circle cl = new Circle(14);
//                            cl.setFill(Color.BROWN);
//                            circleFieldP1[i][j] = cl;
//
//                            gpP1.add(cl, i, j);
//
//                        } else {
//                            Circle cl = new Circle(14);
//                            cl.setFill(Color.BROWN);
//                            circleFieldP2[i][j] = cl;
//
//                            gpP2.add(cl, i, j);
//
//                        }
//                    }
//                }
//            }

            System.out.println(sp.getSpieler()[sp.getSpielerAmZug()].getFlotte()[counter1].getLaenge());

            counter1++;
            amountOfShipsPlaced++;

            if (amountOfShipsPlaced == 20) {

                sp.setStarted(true);
            }

        } else {
            error.setText("Error");
        }
    }

    public void shoot(int row, int col) {
        System.out.println(sp.getSpieler()[sp.getSpielerAmZug()].getName() + " shot:" + col + " And: " + row);
        sp.getSpieler()[sp.getSpielerAmZug()].guess(row, col, sp.getSpieler()[sp.getSpielerNichtAmZug()]);
        this.selectRightView();
        currentView.checkHit(col, row);
        sp.switchPlayer();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        direction = Spieler.OBEN;
    }
}




