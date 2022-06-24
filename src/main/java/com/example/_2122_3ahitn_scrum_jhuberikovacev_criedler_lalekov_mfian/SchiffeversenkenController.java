package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian;

import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.View.ViewField;
import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model.Spiel;
import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model.Spieler;
import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model.Spielfeld;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class SchiffeversenkenController {

    public Label p1label;
    public Label p2label;
    Circle[][] circleFieldP1 = new Circle[10][10];
    Circle[][] circleFieldP2 = new Circle[10][10];
    ViewField viewFieldP1 = new ViewField(circleFieldP1);
    ViewField viewFieldP2 = new ViewField(circleFieldP2);
    ViewField currentView;
    protected int counter1 = 0;
    protected int roundCounterInt = 0;
    protected boolean secondplayer = false;

    @FXML
    public HBox hBoxForplayfield;
    @FXML
    public Label currentdirection;
    @FXML
    public Label labelForShips;
    @FXML
    public Label infoLabel;

    @FXML
    Label labelForP1;
    @FXML
    Label labelForP2;
    @FXML
    Label roundCounter;
    @FXML
    Label whosTrun;

    protected Spiel sp;
    @FXML
    protected GridPane gpP1;
    @FXML
    protected GridPane gpP2;
    boolean direction;
    protected int amountOfShipsPlaced = 0;

    /**
     * "initzialize" for the game ships sink
     * @param spiel the game to use
     */
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
        this.selectRightView();
        HelloController.action.setLabel(labelForP1,sp.getSpieler()[0].getName());
        HelloController.action.setLabel(labelForP2,sp.getSpieler()[1].getName());
        HelloController.action.setLabel(whosTrun,sp.getSpieler()[sp.getSpielerAmZug()].getName()+"'s Turn");
        HelloController.action.setLabel(labelForShips,(sp.getSpieler()[sp.getSpielerAmZug()].getFlotte().length- counter1)+" Ships left to place");
        HelloController.action.setLabel(currentdirection,"Direction changed:\n     up to down");
    }

    /**
     * Whenever one of the Gridpanes are clicked this function will be called. <br />
     * 2 functions, the first palces a ship and the other one shoots
     * @param event location from mouseclick
     */
    @FXML
    public void onClick(javafx.scene.input.MouseEvent event) {
        Node clickedNode = event.getPickResult().getIntersectedNode();


        if (event.getButton() == MouseButton.SECONDARY) {
            if (direction == Spieler.OBEN) {
                direction = Spieler.LINKS;
                HelloController.action.setLabel(currentdirection,"Direction changed:\n     Left to right");
            } else {
                direction = Spieler.OBEN;
                HelloController.action.setLabel(currentdirection,"Direction changed:\n     up to down");
            }
        }

        if ((clickedNode != gpP1 && clickedNode != gpP2) && event.getButton() == MouseButton.PRIMARY) {
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
            gpP2.setDisable(true);
            gpP1.setDisable(false);
            currentView = viewFieldP2;
        } else {
            gpP1.setDisable(true);
            gpP2.setDisable(false);
            currentView = viewFieldP1;
        }
    }

    /**
     * Places the ship from start location into the choosen direction <br />
     * @param row location from the starting row<br />
     * @param col location from the satrting col<br />
     * @param direction direction to place (possibly: left to right || Up to down) <br />
     */
    public void placeShip(int row, int col, boolean direction) {
        boolean success;
        success = sp.getSpieler()[sp.getSpielerAmZug()].placeShip(sp.getSpieler()[sp.getSpielerAmZug()].getFlotte()[counter1], row, col, direction);

        if (success) {

            if (direction== Spieler.OBEN){

            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (sp.getSpieler()[sp.getSpielerAmZug()].getSpielfeld().getField()[i][j] == Spielfeld.SHIP) {
                        if (!secondplayer) {
                            Circle cl = new Circle(14);
                            cl.setFill(Color.BROWN);
                            circleFieldP1[j][i] = cl;

                            gpP1.add(cl, j,i);

                        } else {
                            Circle cl = new Circle(14);
                            cl.setFill(Color.BROWN);
                            circleFieldP2[j][i] = cl;

                            gpP2.add(cl, j, i);

                        }
                    }
                }
            }

            System.out.println(sp.getSpieler()[sp.getSpielerAmZug()].getFlotte()[counter1].getLaenge());

            counter1++;
            amountOfShipsPlaced++;
            HelloController.action.setLabel(labelForShips,(sp.getSpieler()[sp.getSpielerAmZug()].getFlotte().length- counter1)+" Ships left to place");
            if (amountOfShipsPlaced == 10) {

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {

                        Circle cl = new Circle(14);
                        cl.setFill(Color.BLUEVIOLET);
                        circleFieldP1[j][i] = cl;
                        gpP1.add(cl, j, i);
                    }
                }

                sp.switchPlayer();
                secondplayer = true;
                counter1 = 0;
                this.selectRightView();
                HelloController.action.setLabel(whosTrun,sp.getSpieler()[sp.getSpielerAmZug()].getName()+"'s Turn");
                HelloController.action.setLabel(labelForShips,(sp.getSpieler()[sp.getSpielerAmZug()].getFlotte().length- counter1)+" Ships left to place");

            }


            if (amountOfShipsPlaced == 20) {
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {

                        Circle cl = new Circle(14);
                        cl.setFill(Color.BLUEVIOLET);
                        circleFieldP2[j][i] = cl;
                        gpP2.add(cl, j, i);
                    }
                }
                sp.switchPlayer();
                this.selectRightView();
                sp.setStarted(true);
                counter1++;
                HelloController.action.setLabel(whosTrun,sp.getSpieler()[sp.getSpielerAmZug()].getName()+"'s Turn");
                HelloController.action.setLabel(roundCounter,"Round:\n\t"+roundCounterInt);
                HelloController.action.setLabel(infoLabel,"To shoot, click on your own field");
                HelloController.action.setLabel(currentdirection,"");
                HelloController.action.setLabel(labelForShips,"");
                counter1 = 1;
            }

        } else {
            HelloController.action.setLabel(infoLabel,"Unable to place ship\nclick on free circles");
        }
    }

    /**
     * looks if a Ship or nothing is placed on the enemies Playfield. <br />
     * If there are ships or nothing, corresponded circles will be placed
     * @param row The row to check from the enemy
     * @param col The col to check from the enemy
     */
    public void shoot(int row, int col) {
        System.out.println(sp.getSpieler()[sp.getSpielerAmZug()].getName() + " shot:" + col + " And: " + row);
       if(sp.getSpieler()[sp.getSpielerAmZug()].guess(row, col, sp.getSpieler()[sp.getSpielerNichtAmZug()])) {

                       if (sp.getSpielerAmZug() == 1) {
                           sp.getSpieler()[0].getSpielfeld().getField()[col][row]=Spielfeld.HIT;
                           Circle cl = new Circle(14);
           //                cl = new ImageView(new Image("test.png"));
             //              cl = new Water();
               //            cl = new Hit();

                           cl.setFill(Color.BROWN);
                           circleFieldP1[col][row] = cl;
                           gpP1.add(cl, col, row);

                       } else {
                           sp.getSpieler()[1].getSpielfeld().getField()[col][row]=Spielfeld.HIT;
                           Circle cl = new Circle(14);
                           cl.setFill(Color.BROWN);
                           circleFieldP2[col][row] = cl;

                           gpP2.add(cl, col, row);

                       }

                   } else {
           if (sp.getSpielerAmZug() == 1) {
               sp.getSpieler()[0].getSpielfeld().getField()[col][row]=Spielfeld.MISSED;
               Circle cl = new Circle(14);
               cl.setFill(Color.GRAY);
               circleFieldP1[col][row] = cl;
               gpP1.add(cl, col, row);

           } else {
               sp.getSpieler()[1].getSpielfeld().getField()[col][row]=Spielfeld.MISSED;
               Circle cl = new Circle(14);
               cl.setFill(Color.GRAY);
               circleFieldP2[col][row] = cl;

               gpP2.add(cl, col, row);

           }
       }
       if (sp.getSpieler()[sp.getSpielerAmZug()].getSpielfeld().checkWin()){
           hBoxForplayfield.setVisible(false);
           HelloController.action.setLabel(labelForP1,"");
           HelloController.action.setLabel(labelForP2,"");
           HelloController.action.setLabel(roundCounter,sp.getSpieler()[sp.getSpielerAmZug()].getName()+" hat gewonnen");

           // set text in label to "Player sp.getSpieler()[sp.getSpielerAmZug()] won"
       }



        sp.switchPlayer();
        this.selectRightView();
        counter1++;
        if (counter1%2==0){
            roundCounterInt++;
        }
        HelloController.action.setLabel(roundCounter,"Round:\n"+roundCounterInt);
        HelloController.action.setLabel(whosTrun,sp.getSpieler()[sp.getSpielerAmZug()].getName()+"'s Turn");
    }

}




