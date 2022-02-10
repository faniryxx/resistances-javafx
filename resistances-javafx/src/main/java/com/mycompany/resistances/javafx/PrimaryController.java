package com.mycompany.resistances.javafx;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;
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
    @FXML
    private ToggleGroup nombreBandes;
    @FXML
    private RadioButton radioButton4Bands;
    @FXML
    private RadioButton radioButton5Bands;

    /**
     * Ajout d'un listener pour détecter les changements de nombre de bandes.
     */
    public void addListenerToToggles(){
        nombreBandes.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                if ((RadioButton) nombreBandes.getSelectedToggle() == radioButton4Bands) {
                    RadioButton button = (RadioButton) nombreBandes.getSelectedToggle();
                    System.out.println("Button: " + button.getText());
                    Slider3.setVisible(false);
                    Rcouleur3.setVisible(false);
                    band3ComboBox.setDisable(true);
                }
                else {
                    RadioButton button = (RadioButton) nombreBandes.getSelectedToggle();
                    System.out.println("Button: " + button.getText());
                    Slider3.setVisible(true);
                    Rcouleur3.setVisible(true);
                    band3ComboBox.setDisable(false);
                }
                updateResistanceValue();
            }
        });
    }

    /**
     * Initialisation des composants fxml.
     */
    public void initialize() {
        initComboBox();
        updateResistanceValue();
        addListenerToToggles();
    }

    /**
     * Initialisation des des ComboBox et affectation des valeurs par défaut au lancement de l'application.
     */
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

    /**
     * Fonction qui récupère les valeurs actuelles des sliders.
     * @return Une liste d'int qui correspond aux valeurs des sliders. L'index de chaque valeur correspond au numéro de
     * la bande.
     */
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

    /**
     * Fonction de callback appellée à chaque fois qu'une ComboBox est modifiée.
     * Les sliders sont mis à jour à chaque changement de valeur des ComboBox.
     * @param actionEvent
     */
    @FXML
    public void comboBoxUpdated(ActionEvent actionEvent){
        ComboBox comboBox = (ComboBox) actionEvent.getSource();
        if(comboBox == band1ComboBox){
            Slider1.setValue(band1ComboBox.getValue().getIndex());
            Rcouleur1.setFill(band1ComboBox.getValue().getColor());
        }
        else if(comboBox == band2ComboBox){
            Slider2.setValue(band2ComboBox.getValue().getIndex());
            Rcouleur2.setFill(band2ComboBox.getValue().getColor());
        }
        else if(comboBox == band3ComboBox){
            Slider3.setValue(band3ComboBox.getValue().getIndex());
            Rcouleur3.setFill(band3ComboBox.getValue().getColor());
        }
        else if(comboBox == band4ComboBox){
            Slider4.setValue(band4ComboBox.getValue().getIndex());
            Rcouleur4.setFill(band4ComboBox.getValue().getColor());
        }
        else {
            Slider5.setValue(band5ComboBox.getValue().getIndex());
            Rcouleur5.setFill(band5ComboBox.getValue().getColor());
        }
        updateResistanceValue();
    }

    /**
     * Actualisation de la valeur affichée de la résistance.
     * Appellée à chaque modification des ComboBox ou des sliders.
     */
    public void updateResistanceValue(){
        String resistanceValue = "";
        Calculs calcul = new Calculs();
        List<Integer> sliderValuesbyIndex = updateSliderValues();
        if ((RadioButton) nombreBandes.getSelectedToggle() == radioButton4Bands) {
            resistanceValue = calcul.calcul4Bandes(sliderValuesbyIndex);
        }
        else {
            resistanceValue = calcul.calcul5Bandes(sliderValuesbyIndex);
        }
        resistanceValueLabel.setText(resistanceValue);
    }

    /**
     * Fonction qui change les couleurs de chaque bande au fur et à mesure que les valeurs des sliders changent.
     * @param event
     */
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

    /**
     * Ouvre le projet sur Github quand on clique sur le logo Github.
     * Source: https://stackoverflow.com/a/47645799
     */
    public void openGithubPage(){
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/faniryxx/resistances-javafx").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
