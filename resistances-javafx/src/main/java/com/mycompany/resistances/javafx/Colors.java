package com.mycompany.resistances.javafx;

import javafx.scene.paint.Color;

/**
 * Classe qui "englobe" la classe Color pour l'utilisation qu'on en fait dans le projet, avec un index et une chaîne de
 * caractères correspondant à la couleur en plus de la Color elle-même.
 * Ses attributs sont accessibles via les getters correspondants.
 */
public class Colors {
    /**
     * Variable utilisée pour le calcul des résistances.
     * L'index de chaque couleur est égal au chiffre significatif correspondant. Par exemple, si la couleur BLACK a
     * l'index 0, son chiffre significatif est 0. De même pour la couleur RED qui a comme index 2 et qui a comme chiffre
     * significatif 2.
     */
    private Integer index;

    /**
     * Valeur de la couleur.
     */
    private Color color;

    /**
     * Couleur en chaîne de caractères.
     */
    private String couleur;

    /**
     * Constructeur de la classe.
     * @param index Chiffre significatif correspondant dans le cas où il s'agit des 3 premières bandes.
     * @param color Couleur.
     * @param couleur Couleur en chaîne de caractères pour l'affichage.
     */
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
