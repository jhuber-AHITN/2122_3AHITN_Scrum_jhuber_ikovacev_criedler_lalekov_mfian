package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model;

public class Spiel {
    protected Spielfeld schiffeVersenkenField;
    protected Spieler[] spieler;
    protected  short spielerAmZug;
    protected boolean sieg;

   public Spiel(Spieler p1,Spieler p2){
        this.schiffeVersenkenField=new Spielfeld();
        this.spieler=new Spieler[2];
        this.spieler[0]=p1;
        this.spieler[1]=p2;
        this.spielerAmZug=0;
        this.sieg=false;

    }

    public Spieler[] getSpieler() {
        return spieler;
    }


}
