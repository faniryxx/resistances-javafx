package com.mycompany.resistances.javafx;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
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
    private TextField resistanceValueTextField;
    @FXML
    private Label resistanceValueLabel;
    @FXML
    private ComboBox<Colors> band1ComboBox;
    @FXML
    private ComboBox<Colors> band2ComboBox;
    @FXML
    private ComboBox<Colors> band3ComboBox;
    @FXML
    private ComboBox<Colors> band4ComboBox;
    @FXML
    private ComboBox<Colors> band5ComboBox;

    public void initialize() {
        initComboBox();
        updateResistanceValue();
    }

    public void initComboBox(){
        ObservableList<Colors> colors = App.colorList;
        band1ComboBox.setItems(colors);
        band2ComboBox.setItems(colors);
        band3ComboBox.setItems(colors);
        ObservableList<Colors> MultiplierToleranceColors = App.colorListMultiplierTolerance;
        band4ComboBox.setItems(MultiplierToleranceColors);
        band5ComboBox.setItems(MultiplierToleranceColors);
        band1ComboBox.setValue(App.colorListMultiplierTolerance.get(5));
        band2ComboBox.setValue(App.colorListMultiplierTolerance.get(6));
        band3ComboBox.setValue(App.colorListMultiplierTolerance.get(0));
        band4ComboBox.setValue(App.colorListMultiplierTolerance.get(2));
        band5ComboBox.setValue(App.colorListMultiplierTolerance.get(3));
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

    public void setBand1ComboBoxUpdated(){
        Slider1.setValue(band1ComboBox.getValue().getIndex());
        Rcouleur1.setFill(band1ComboBox.getValue().getColor());
        updateResistanceValue();
    }

    public void setBand2ComboBoxUpdated(){
        Slider2.setValue(band2ComboBox.getValue().getIndex());
        Rcouleur2.setFill(band2ComboBox.getValue().getColor());
        updateResistanceValue();
    }

    public void setBand3ComboBoxUpdated(){
        Slider3.setValue(band3ComboBox.getValue().getIndex());
        Rcouleur3.setFill(band3ComboBox.getValue().getColor());
        updateResistanceValue();
    }

    public void setBand4ComboBoxUpdated(){
        Slider4.setValue(band4ComboBox.getValue().getIndex());
        Rcouleur4.setFill(band4ComboBox.getValue().getColor());
        updateResistanceValue();
    }

    public void setBand5ComboBoxUpdated(){
        Slider5.setValue(band5ComboBox.getValue().getIndex());
        Rcouleur5.setFill(band5ComboBox.getValue().getColor());
        updateResistanceValue();
    }

    public void updateResistanceValue(){
        // Do calculations
        Calculs calcul = new Calculs();
        List<Integer> sliderValuesbyIndex = updateSliderValues();
        String resistanceValue = calcul.calcul5Bandes(sliderValuesbyIndex);

        resistanceValueLabel.setText(resistanceValue);
    }

    @FXML
    public void changeColor(MouseEvent event){
        Slider slider = (Slider)event.getSource();
        Double sliderValue = slider.getValue();
        Integer sliderValueInt = sliderValue.intValue();
        Colors color = App.colorListMultiplierTolerance.get(sliderValueInt);
        
        if(slider == Slider1) {
            Rcouleur1.setFill(color.getColor());
            band1ComboBox.setValue(new Colors(sliderValueInt, color.getColor(), color.toString()));
        }
        
        else if(slider == Slider2) {
            Rcouleur2.setFill(color.getColor());
            band2ComboBox.setValue(new Colors(sliderValueInt, color.getColor(), color.toString()));
        }
        
        else if(slider == Slider3) {
            Rcouleur3.setFill(color.getColor());
            band3ComboBox.setValue(new Colors(sliderValueInt, color.getColor(), color.toString()));
        }
        
        else if(slider == Slider4) {
            Rcouleur4.setFill(color.getColor());
            band4ComboBox.setValue(new Colors(sliderValueInt, color.getColor(), color.toString()));
        }
        
        else if(slider == Slider5) {
            Rcouleur5.setFill(color.getColor());
            band5ComboBox.setValue(new Colors(sliderValueInt, color.getColor(), color.toString()));
        }

        updateResistanceValue();
    }
}
