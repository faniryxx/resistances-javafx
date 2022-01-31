package com.mycompany.resistances.javafx;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import javafx.scene.paint.Color;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static Calculs calcul;
    public static HashMap<Integer, Color> colorValuesbyIndex;

    @Override
    public void start(Stage stage) throws IOException {
        calcul = new Calculs();
        colorValuesbyIndex = calcul.colorValuesbyIndex;
        scene = new Scene(loadFXML("primary"));
        stage.setScene(scene);
        stage.setTitle("Calcul résistance");
        stage.setResizable(false);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}