package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.View;

import javafx.scene.shape.Circle;

public class ViewField{
    private static int SHIP = 1;
    private static int NOSHIP = 0;
    protected  Circle[][] circles;



    public ViewField(Circle[][] circles){
       this.circles=circles;
    }

    public void checkHit(int row,int col){

    }
}
