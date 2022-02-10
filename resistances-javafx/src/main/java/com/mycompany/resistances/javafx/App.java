package com.mycompany.resistances.javafx;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javafx.scene.paint.Color;

/**
 * JavaFX App
 */
public class App extends Application {
    private static Scene scene;
    public static Calculs calcul;

    /**
     * Liste de couleurs de type Colors (voir Colors.java) utilisée dans les calculs pour les trois premières bandes.
     */
    public static ObservableList<Colors> colorList;

    /**
     * Liste de couleurs de type Colors (voir Colors.java) utilisée dans les calculs pour les bandes de multiplicateur
     * et de tolérance.
     */
    public static ObservableList<Colors> colorListMultiplierTolerance;

    @Override
    public void start(Stage stage) throws IOException {
        initColorList();
        calcul = new Calculs();
        scene = new Scene(loadFXML("primary"));
        stage.setScene(scene);
        stage.setTitle("Calcul résistance");
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Population des listes de Colors au lancement de l'application.
     */
    public void initColorList(){
        colorList = FXCollections.observableArrayList();
        colorList.add(new Colors(0, Color.BLACK, "BLACK"));
        colorList.add(new Colors(1, Color.BROWN, "BROWN"));
        colorList.add(new Colors(2, Color.RED, "RED"));
        colorList.add(new Colors(3, Color.ORANGE, "ORANGE"));
        colorList.add(new Colors(4, Color.YELLOW, "YELLOW"));
        colorList.add(new Colors(5, Color.GREEN, "GREEN"));
        colorList.add(new Colors(6, Color.BLUE, "BLUE"));
        colorList.add(new Colors(7, Color.PURPLE, "PURPLE"));
        colorList.add(new Colors(8, Color.GRAY, "GRAY"));
        colorList.add(new Colors(9, Color.WHITE, "WHITE"));
        colorListMultiplierTolerance = FXCollections.observableArrayList();
        colorListMultiplierTolerance.add(new Colors(0, Color.BLACK, "BLACK"));
        colorListMultiplierTolerance.add(new Colors(1, Color.BROWN, "BROWN"));
        colorListMultiplierTolerance.add(new Colors(2, Color.RED, "RED"));
        colorListMultiplierTolerance.add(new Colors(3, Color.ORANGE, "ORANGE"));
        colorListMultiplierTolerance.add(new Colors(4, Color.YELLOW, "YELLOW"));
        colorListMultiplierTolerance.add(new Colors(5, Color.GREEN, "GREEN"));
        colorListMultiplierTolerance.add(new Colors(6, Color.BLUE, "BLUE"));
        colorListMultiplierTolerance.add(new Colors(7, Color.PURPLE, "PURPLE"));
        colorListMultiplierTolerance.add(new Colors(8, Color.GRAY, "GRAY"));
        colorListMultiplierTolerance.add(new Colors(9, Color.WHITE, "WHITE"));
        colorListMultiplierTolerance.add(new Colors(10, Color.GOLD, "GOLD"));
        colorListMultiplierTolerance.add(new Colors(11, Color.SILVER, "SILVER"));
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