package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.View;

import javafx.scene.shape.Circle;

public class ViewField implements Runnable{
    protected static Circle[][] circles;
    protected int row;
    protected int col;

    public static void setCircles(Circle[][] circles){
        ViewField.circles =circles;
    }
    ViewField(int row,int col){
       this.row=row;
       this.col=col;
    }
    @Override
    public void run() {

    }
}
