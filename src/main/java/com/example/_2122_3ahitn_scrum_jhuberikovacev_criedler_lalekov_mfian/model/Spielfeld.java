package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model;

/**
 * Field for each player
 */
public class Spielfeld {
    public static final int EMPTY = 0;
    public static final int SHIP = 1;
    public static final int MISSED = 2;
    public static final int HIT = 3;
    public static final int ROWS = 10;
    public static final int COLS = 10;


    private int[][] field;

    public Spielfeld() {
        field = new int[ROWS][COLS];
    }

    public void fillWater() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (field[i][j] != HIT) {
                    field[i][j] = EMPTY;
                }
            }
        }

    }


    public int[][] getField() {
        return field;
    }
    public boolean checkWin() {
        boolean checkwin = true;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (field[i][j] == 1) {
                    checkwin = false;
                }
            }

        }

        return checkwin;
    }

    public void setShip(int row, int i) {
            field[row][i] = SHIP;


    }


    public boolean shipplaceable(Schiff ship, int row, int col) {
        boolean shipplaceable=true;
        if (col+ship.laenge>9){
            shipplaceable=false;
        } else {
            for (int i = col; i < col + ship.laenge; i++) {
                if (field[row][i]==Spielfeld.SHIP || i > 10){
                    shipplaceable=false;
                    break;
                }
            }
        }
        return shipplaceable;
    }
}
