package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model;

public class Spiel {
    protected Spielfeld schiffeVersenkenField;
    protected Spieler[] spieler;
    short spielerAmZug;
    boolean sieg;

    public Spieler[] getSpieler() {
        return spieler;
    }

    protected boolean checkSieg(){
        return sieg;
    }
}
