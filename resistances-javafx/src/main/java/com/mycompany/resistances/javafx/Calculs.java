package com.mycompany.resistances.javafx;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Calculs {
    private static HashMap<String, String> Colors = new HashMap<String, String>();
    private static HashMap<String, Integer> Multiplicateurs = new HashMap<String, Integer>();
    private static HashMap<String, String> Tolerance = new HashMap<String, String>();
    
    Calculs(){
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
