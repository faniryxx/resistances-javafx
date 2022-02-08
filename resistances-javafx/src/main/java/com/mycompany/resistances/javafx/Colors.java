package com.mycompany.resistances.javafx;

import javafx.scene.paint.Color;

public class Colors {
    private Integer index;
    private Color color;
    private String couleur;


    Colors(Integer index, Color color, String couleur){
        this.index = index;
        this.color = color;
        this.couleur = couleur;
    }

    @Override
    public String toString(){
        return this.couleur;
    }

    public Integer getIndex(){
        return this.index;
    }

    public Color getColor(){
        return this.color;
    }
}
