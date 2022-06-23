package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model;

public class Spiel {
    protected Spieler[] spieler;
    protected short spielerAmZug;
    protected short spielerNichtAmZug;
    protected boolean sieg;
    protected boolean started;

    public Spiel(Spieler p1, Spieler p2) {
        this.spieler = new Spieler[2];
        this.spieler[0] = p1;
        this.spieler[1] = p2;
        this.spielerAmZug = 0;
        this.spielerNichtAmZug = 1;
        this.sieg = false;
        this.started = false;
    }

    public short getSpielerAmZug() {
        return spielerAmZug;
    }

    public Spieler[] getSpieler() {
        return spieler;
    }

    public short getSpielerNichtAmZug() {
        return spielerNichtAmZug;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public void setSieg(boolean sieg) {
        this.sieg = sieg;
    }

    public void switchPlayer() {
        short newCurrentPlayer = this.spielerNichtAmZug;
        this.spielerNichtAmZug = spielerAmZug;
        this.spielerAmZug = newCurrentPlayer;
    }
}
