package com.mycompany.resistances.javafx;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import javafx.scene.paint.Color;

public class Calculs {
    // Colors and their values on resistance value bands
    public static HashMap<String, String> Colors;
    
    // Colors and their values on multiplicator band
    public static HashMap<String, Integer> Multiplicateurs;
    
    // Colors and their values on tolerance band
    public static HashMap<String, String> Tolerance;
    
    public HashMap<Integer, Color> colorValuesbyIndex;

    Calculs(){
        Colors = new HashMap<String, String>();
        Colors.put("Black","0");
        Colors.put("Brown","1");
        Colors.put("Red","2");
        Colors.put("Orange","3");
        Colors.put("Yellow","4");
        Colors.put("Green","5");
        Colors.put("Blue","6");
        Colors.put("Purple","7");
        Colors.put("Gray","8");
        Colors.put("White","9");
        
        Multiplicateurs = new HashMap<String, Integer>();
        Multiplicateurs.put("Black",1);
        Multiplicateurs.put("Brown",10);
        Multiplicateurs.put("Red",100);
        Multiplicateurs.put("Orange",1000);
        Multiplicateurs.put("Yellow",10000);
        Multiplicateurs.put("Green",100000);
        Multiplicateurs.put("Blue",1000000);
        Multiplicateurs.put("Purple",10000000);
        Multiplicateurs.put("Gray",100000000);
        Multiplicateurs.put("White",1000000000);
        
        Tolerance = new HashMap<String, String>();
        Tolerance.put("Black","");
        Tolerance.put("Brown","1%");
        Tolerance.put("Red","2%");
        Tolerance.put("Orange","");
        Tolerance.put("Yellow","");
        Tolerance.put("Green","0.5%");
        Tolerance.put("Blue","0.25%");
        Tolerance.put("Purple","0.1%");
        Tolerance.put("Gray","0.05%");
        Tolerance.put("White","");
        Tolerance.put("Gold","5%");
        Tolerance.put("White","10%");
        
        colorValuesbyIndex = new HashMap<Integer, Color>();
        colorValuesbyIndex.put(0, Color.BLACK);
        colorValuesbyIndex.put(1, Color.BROWN);
        colorValuesbyIndex.put(2, Color.RED);
        colorValuesbyIndex.put(3, Color.ORANGE);
        colorValuesbyIndex.put(4, Color.YELLOW);
        colorValuesbyIndex.put(5, Color.GREEN);
        colorValuesbyIndex.put(6, Color.BLUE);
        colorValuesbyIndex.put(7, Color.PURPLE);
        colorValuesbyIndex.put(8, Color.GRAY);
        colorValuesbyIndex.put(9, Color.WHITE);
        colorValuesbyIndex.put(10, Color.GOLD);
        colorValuesbyIndex.put(11, Color.SILVER);
    }
    
    public static String Calcul5Bandes(List<String> bandes){
        String chiffresSignificatifs = Colors.get(bandes.get(0)) + Colors.get(bandes.get(1))
                + Colors.get(bandes.get(2));
        Integer chiffresSignificatifsInt = Integer.parseInt(chiffresSignificatifs);
        Integer value = chiffresSignificatifsInt * Multiplicateurs.get(bandes.get(3));
        String tolerance = Tolerance.get(bandes.get(4));
        
        String resultat = String.valueOf(value) + " ± " + tolerance;
        return resultat;
    }
}
