package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model;

public class Spieler {
    protected String name;
    private Spielfeld spielfeld;
    public static final boolean LINKS = true;
    public static final boolean OBEN = false;

    public Spielfeld getSpielfeld() {
        return spielfeld;
    }
// array fuer Schiffskins

    public Spieler(String name) {
        this.name = name;
        spielfeld=new Spielfeld();
    }

    public int guess(int row, int col, Spieler sp) {
        int checkhit = 0;
        if(sp.spielfeld.getField()[row][col]==Spielfeld.SHIP){
            sp.spielfeld.getField()[row][col]=Spielfeld.HIT;
            checkhit=Spielfeld.HIT;
        } else if (sp.spielfeld.getField()[row][col]==Spielfeld.EMPTY){
            sp.spielfeld.getField()[row][col]=Spielfeld.MISSED;
            checkhit=Spielfeld.MISSED;
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
