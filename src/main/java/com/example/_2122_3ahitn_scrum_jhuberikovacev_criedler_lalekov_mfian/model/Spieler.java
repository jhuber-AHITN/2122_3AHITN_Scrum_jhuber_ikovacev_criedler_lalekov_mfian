package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model;

public class Spieler {
    protected String name;
    private Spielfeld spielfeld;
    public static final boolean LINKS = true;
    public static final boolean OBEN = false;

    // array fuer Schiffskins

    public Spieler(String name) {
        this.name = name;
        this.spielfeld=new Spielfeld();
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
     * @param length
     * @param direction
     * @return
     */
    public void placeShip(char row, int col, int length, boolean direction) {
        if (direction == OBEN) {
            for (int i = row; i < row + length; i++) {

                spielfeld.setShip(row, i);
            }
        } else {
            for (int i = col; i < col + length; i++) {
                spielfeld.setShip(row, i);

            }
        }
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
}
