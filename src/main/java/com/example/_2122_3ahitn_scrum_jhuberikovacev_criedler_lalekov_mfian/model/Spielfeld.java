package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model;


public class Spielfeld {
    public static final int EMPTY = 10;
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
        placeRandom();
    }
    public void placeRandom(){
        field[0][0]=SHIP;
        field[0][1]=SHIP;
        field[0][2]=SHIP;

        field[6][8]=SHIP;
        field[7][8]=SHIP;
        field[8][8]=SHIP;
        field[9][8]=SHIP;
        field[9][9]=SHIP;
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

    public void setShip(char row, int i) {
        if (field[row][i] == EMPTY) {
            field[row][i] = SHIP;
        }
    }
}
