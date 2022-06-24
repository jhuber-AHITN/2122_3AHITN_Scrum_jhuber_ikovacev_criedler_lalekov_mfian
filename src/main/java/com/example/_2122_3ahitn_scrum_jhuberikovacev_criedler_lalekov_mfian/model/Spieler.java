package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model;

/**
 * Ermöglicht das erzeugen eines Spieler Obejkts,
 * jeder Spieler hat eine Flotte in FOrm eines Schiffarrays,
 * einen Namen und ein zugeordnetes Spielfeld
 * Zusätzlich wird noch gespeichert wieviel Schiffe ein Spieler bereits platziert hat,
 * um zu wissen wann man den currentPlayer beim platzieren der Schiffe wechseln sollte
 */

public class Spieler {


    public static final int SCHIFFANZAHL = 10;

    protected Schiff[] Flotte = new Schiff[SCHIFFANZAHL];
    protected String name;
    protected Spielfeld spielfeld;
    protected int amountOfShipsPlaced;
    public static final boolean LINKS = true;
    public static final boolean OBEN = false;


    /**
     * Gibd den Spieler seinen Namen, sein Spielfeld und befüült das Schiffsarray Flotte mit Schiffen
     *
     * @param name
     */
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


    /**
     * Überprüft ob der mit mitgegeben Spieler an der Stelle ein Schiff hat,
     * wenn ja wird das Feld auf getroffen gesetzt
     * wenn nicht wird false zurückgegebn
     *
     * @param row
     * @param col
     * @param sp
     * @return
     */
    public boolean guess(int row, int col, Spieler sp) {
        boolean checkhit = false;
        if (sp.spielfeld.getField()[row][col] == Spielfeld.SHIP) {
            sp.spielfeld.getField()[row][col] = Spielfeld.HIT;
            checkhit = true;
        }

        return checkhit;
    }

    /**
     * ueberprueft das direction boolean und iterieten je nachdem ob es auf LINKS oder OBEN gesetzt ist das field array durch.
     * Überprüft dann ob das Schiff platt hat und platziert werden darf.
     * Wenn es OBEN gesetzt laeuft die for schleife solange wie in der laenge angegeben ist, wobei die Spalte fix bleibt und die Reihe immer höher geht.
     * Wenn es LINKS ist bleibt die Reihe fix und die Spalte erhöht sich mit jedem Durchlauf um 1
     *
     * @param row
     * @param col
     * @param direction
     * @return
     */
    public boolean placeShip(Schiff ship, int row, int col, boolean direction) {
        boolean shipplaceable = false;
        if (direction == LINKS) {

            System.out.println("placeship links nach rechts:" + spielfeld.shipplaceable(ship, row, col));

            if (spielfeld.shipplaceable(ship, row, col)) {
                for (int i = col; i < col + ship.laenge; i++) {
                    spielfeld.setShip(row, i);

                }
                amountOfShipsPlaced++;
                prientfield();
                shipplaceable = true;
            }


        } else {

            System.out.println("placeship oben nach unten:" + spielfeld.shipplaceable(ship, row, col));


            if (spielfeld.shipplaceable(ship, row, col)) {
                for (int i = row; i < row + ship.laenge; i++) {
                    spielfeld.setShip(i, col);
                }
                amountOfShipsPlaced++;
                prientfield();
                shipplaceable = true;
            }


        }
        return shipplaceable;

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

    /**
     * Debugging in Console
     */
    public void prientfield() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(spielfeld.getField()[i][j]);
            }
            System.out.println("");
        }
    }
}

