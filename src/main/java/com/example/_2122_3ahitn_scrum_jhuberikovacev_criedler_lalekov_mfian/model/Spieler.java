package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model;

public class Spieler {


    public static final int SCHIFFANZAHL = 10;

    protected Schiff[] Flotte = new Schiff[SCHIFFANZAHL];
    protected String name;
    protected Spielfeld spielfeld;
    protected int amountOfShipsPlaced;
    public static final boolean LINKS = true;
    public static final boolean OBEN = false;

    // array fuer Schiffskins

    public Spieler(String name) {
        this.name = name;
        this.spielfeld = new Spielfeld();
        for (int i = 0; i < SCHIFFANZAHL; i++) {
            if (i == 0) {
                Flotte[i] = new Schiff(5);
            } else if (i < 3) {
                Flotte[i] = new Schiff(4);
            } else if (i < 6) {
                Flotte[i] = new Schiff(3);
            } else {
                Flotte[i] = new Schiff(2);
            }
        }
        amountOfShipsPlaced = 0;
    }


    public boolean guess(int row, int col, Spieler sp) {
        boolean checkhit = false;
        if (sp.spielfeld.getField()[row][col] == 1) {
            sp.spielfeld.getField()[row][col] = 3;
            checkhit = true;
        }

        return checkhit;
    }

    /**
     * ueberprueft dds direction boolean und iterieten je nachdem ob es auf LINKS oder OBEN gesetzt ist das field array durch.
     * Wenn es OBEN gesetzt laeuft die for schleife solange wie in der laenge angegeben ist, wobei die Reihe fix bleibt und die Spalte immer höher geht
     *
     * @param row
     * @param col
     * @param direction
     * @return
     */
    public boolean placeShip(Schiff ship, int row, int col, boolean direction) {
        boolean shipplaceable = true;
        if (direction == LINKS) {
            if ((row - Flotte[amountOfShipsPlaced].getLaenge()) < Flotte[amountOfShipsPlaced].getLaenge()) {



                if (shipplaceable) {
                    for (int i = col; i < row + ship.laenge; i++) {
                        spielfeld.setShip(row, i);

                    }
                    amountOfShipsPlaced++;
                }
                prientfield();
                return true;
            }
        } else {
            if ((col - Flotte[amountOfShipsPlaced].getLaenge()) < Flotte[amountOfShipsPlaced].getLaenge()) {


                for (int i = row; i < col + ship.laenge; i++) {
                    spielfeld.setShip(i, col);
                }
                amountOfShipsPlaced++;
                prientfield();
                return true;
            }
        }prientfield();
        return false;

    }


    public void setName(String name) {
        this.name = name;
    }

    public Spielfeld getSpielfeld() {
        return spielfeld;
    }

    public String getName() {
        return name;
    }

    public Schiff[] getFlotte() {
        return Flotte;
    }

    public void prientfield(){
        for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(spielfeld.getField()[i][j]);
                }
            System.out.println("");
        }
    }
}
/*
    public int shoot(int row, int col) {
        if (row < 0 || row)
    }

    public int shoot(int row, int col)throw

        IllegalCoordinateException{
        if(<0)throw new IllegalCoordinat._ eException();
        return Spielfeld.EMPTY;
        }
}
 */

