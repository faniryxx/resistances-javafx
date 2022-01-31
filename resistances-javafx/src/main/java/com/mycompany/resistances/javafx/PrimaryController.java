package com.mycompany.resistances.javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class PrimaryController {

    @FXML
    private Rectangle rectangle1;
    @FXML
    private ImageView image;
    
    public void initialize(URL location, ResourceBundle resources) {
        image.setVisible(true);
    }
   
}
