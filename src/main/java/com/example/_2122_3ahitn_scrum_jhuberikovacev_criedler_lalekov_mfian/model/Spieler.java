package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model;

public class Spieler {
    protected String name;
    private Spielfeld spielfeld;
    public static final boolean LINKS = true;

    public static final boolean OBEN = false;

    // array fuer Schiffskins

    public Spieler(String name) {
        this.name = name;
    }

    public boolean guess(char row, int col, Spieler sp) {
        boolean checkhit = false;
        if(sp.spielfeld.getField()[row][col]==1){
            sp.spielfeld.getField()[row][col]=2;
            checkhit=true;
        }

       return checkhit;
    }

    /**
     * ueberprueft dds direction boolean und iterieten je nachdem ob es auf LINKS oder OBEN gesetzt ist das field array durch.
     * Wenn es OBEN gesetzt laeuft die for schleife solange wie in der laenge angegeben ist, wobei die Reihe fix bleibt und die Spalte immer höher geht
     * @param row
     * @param col
     * @param length
     * @param direction
     * @return
     */
    public boolean placeShip(char row, int col, int length, boolean direction) {
        boolean placed = true;
        if (direction == OBEN) {
            for (int i = row; i < row + length; i++) {
                if (spielfeld.getField()[row][i] == 0) {
                    spielfeld.getField()[row][i] = 1;
                } else {
                    placed = false;
                }
            }
        } else {
            for (int i = col; i < col + length; i++) {
                if (spielfeld.getField()[i][col] == 0) {
                    spielfeld.getField()[i][col] = 1;
                } else {
                    placed = false;
                }
            }
        }
        return placed;
    }
}
