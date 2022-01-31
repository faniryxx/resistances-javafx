package com.mycompany.resistances.javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
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
    
    public void initialize(URL location, ResourceBundle resources) {
        image.setVisible(true);
    }
   
}
