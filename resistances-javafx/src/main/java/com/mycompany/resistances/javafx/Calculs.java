package com.mycompany.resistances.javafx;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import javafx.scene.paint.Color;

public class Calculs {

    public static HashMap<Integer, Color> colorValuesbyIndex;
    public static HashMap<Integer, Double> multiplierValuesbyIndex;
    public static HashMap<Integer, Double> toleranceValuesbyIndex;

    Calculs(){
        
        multiplierValuesbyIndex = new HashMap<Integer, Double>();
        multiplierValuesbyIndex.put(0,1.0);
        multiplierValuesbyIndex.put(1,10.0);
        multiplierValuesbyIndex.put(2,100.0);
        multiplierValuesbyIndex.put(3,1000.0);
        multiplierValuesbyIndex.put(4,10000.0);
        multiplierValuesbyIndex.put(5,100000.0);
        multiplierValuesbyIndex.put(6,1000000.0);
        multiplierValuesbyIndex.put(7,10000000.0);
        multiplierValuesbyIndex.put(8,100000000.0);
        multiplierValuesbyIndex.put(9,1000000000.0);
        multiplierValuesbyIndex.put(10,0.1);
        multiplierValuesbyIndex.put(11,0.01);
        
        toleranceValuesbyIndex = new HashMap<Integer, Double>();
        toleranceValuesbyIndex.put(0,0.0);
        toleranceValuesbyIndex.put(1,1.0);
        toleranceValuesbyIndex.put(2,2.0);
        toleranceValuesbyIndex.put(3,0.0);
        toleranceValuesbyIndex.put(4,0.0);
        toleranceValuesbyIndex.put(5,0.5);
        toleranceValuesbyIndex.put(6,0.25);
        toleranceValuesbyIndex.put(7,0.1);
        toleranceValuesbyIndex.put(8,0.05);
        toleranceValuesbyIndex.put(9,0.0);
        toleranceValuesbyIndex.put(10,5.0);
        toleranceValuesbyIndex.put(11,10.0);
        
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
    
    public String calcul5Bandes(List<Integer> colorIndexes){
        String bande1 = String.valueOf(colorIndexes.get(0));
        String bande2 = String.valueOf(colorIndexes.get(1));
        String bande3 = String.valueOf(colorIndexes.get(2));
        
        Double value = Double.parseDouble(bande1+bande2+bande3);
        value = value * multiplierValuesbyIndex.get(colorIndexes.get(3));
        
        String formattedValue = formatResistanceValue(value);

        String tolerance = String.valueOf(toleranceValuesbyIndex.get(colorIndexes.get(4)));

        String result = formattedValue + " ± " + tolerance + "%";
        return result;
    }

    public String calcul4Bandes(List<Integer> colorIndexes){
        String bande1 = String.valueOf(colorIndexes.get(0));
        String bande2 = String.valueOf(colorIndexes.get(1));

        Double value = Double.parseDouble(bande1+bande2);
        value = value * multiplierValuesbyIndex.get(colorIndexes.get(3));

        String formattedValue = formatResistanceValue(value);

        String tolerance = String.valueOf(toleranceValuesbyIndex.get(colorIndexes.get(4)));

        String result = formattedValue + " ± " + tolerance + "%";
        return result;
    }
    
    // Format in k, M, G instead of E3, E6, E9
    public String formatResistanceValue(Double value){
        Double newValue = 0.0;
        String unit = "";
        
        if(value <1000){
            newValue = value;
            unit = "Ω";
        }
        
        else if(value > 1000 && value < 1000000){
            newValue = value / 1000;
            unit = "kΩ";
        }
        
        else if (value>1000000 && value < 1000000000){
            newValue = value / 1000000;
            unit = "MΩ";
        }
        
        else if (value > 1000000000){
            newValue = value / 1000000000;
            unit = "GΩ";
        }

        String pattern = "#.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String formattedNewValue = decimalFormat.format(newValue);

        String result = formattedNewValue + unit;
        return result;
    }
}
