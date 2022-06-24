package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model;

/**
 * Ermöglicht das erzeugen eines
 * Schiffsobjekt mit bestimmter länge
 */
public class Schiff {
    protected int laenge;

    Schiff(int laenge){
        this.laenge=laenge;
    }

    public int getLaenge() {
        return laenge;
    }
}
