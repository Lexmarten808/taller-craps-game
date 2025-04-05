package com.example.crapsgame.models;

public class Dice {

    int value;

    String IMAGES_PATH = "/com/example/crapsgame/imeges/dices/dice";

    public int roll(){
        this.value = (int)(Math.random()*6+1);
        return this.value;
    }

    public String getDiceImagePath() {
        return IMAGES_PATH + Integer.toString(this.value) + ".png";
    }
}
