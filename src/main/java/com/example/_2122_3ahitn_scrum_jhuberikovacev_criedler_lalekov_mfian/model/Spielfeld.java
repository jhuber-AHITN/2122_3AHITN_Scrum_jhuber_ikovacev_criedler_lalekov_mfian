package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model;


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

    public void fillWater(){
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (field[i][j]!=HIT){
                    field[i][j] = EMPTY;
                }
            }
        }
    }
}
