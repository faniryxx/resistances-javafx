package com.mycompany.resistances.javafx;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PrimaryController {

    private ImageView image;
    @FXML
    private ImageView ImageRes;
    @FXML
    private Rectangle Rcouleur1;
    @FXML
    private Rectangle Rcouleur5;
    @FXML
    private Rectangle Rcouleur4;
    @FXML
    private Rectangle Rcouleur3;
    @FXML
    private Rectangle Rcouleur2;
    @FXML
    private Slider Slider5;
    @FXML
    private Slider Slider4;
    @FXML
    private Slider Slider3;
    @FXML
    private Slider Slider2;
    @FXML
    private Slider Slider1;
    @FXML
    private Pane Global;
    @FXML
    private Pane PaneResistance;
    @FXML
    private TextField resistanceValueTextField;
        
    public void initialize(URL location, ResourceBundle resources) {
        image.setVisible(true);
    }
    
    public List<Integer> updateSliderValues(){
        List<Integer> sliderValuesbyIndex = new ArrayList<>();
        Double sliderValue = Slider1.getValue();
        sliderValuesbyIndex.add(sliderValue.intValue());
        sliderValue = Slider2.getValue();
        sliderValuesbyIndex.add(sliderValue.intValue());
        sliderValue = Slider3.getValue();
        sliderValuesbyIndex.add(sliderValue.intValue());
        sliderValue = Slider4.getValue();
        sliderValuesbyIndex.add(sliderValue.intValue());
        sliderValue = Slider5.getValue();
        sliderValuesbyIndex.add(sliderValue.intValue());
        return sliderValuesbyIndex;
    }
   
    @FXML
    public void changeColor(MouseEvent event){
        Slider slider = (Slider)event.getSource();
        Double sliderValue = slider.getValue();
        Integer sliderValueInt = sliderValue.intValue();
        Color color = App.colorValuesbyIndex.get(sliderValueInt);
        
        if(slider == Slider1) 
            Rcouleur1.setFill(color);
        
        else if(slider == Slider2) 
            Rcouleur2.setFill(color);
        
        else if(slider == Slider3) 
            Rcouleur3.setFill(color);
        
        else if(slider == Slider4) 
            Rcouleur4.setFill(color);
        
        else if(slider == Slider5)
            Rcouleur5.setFill(color);
        
        // Do calculations
        Calculs calcul = new Calculs();
        List<Integer> sliderValuesbyIndex = updateSliderValues();
        String resistanceValue = calcul.calcul5Bandes(sliderValuesbyIndex);
        
        resistanceValueTextField.setText(resistanceValue);
    }
}
