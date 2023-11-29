package com.mycompany.cote_client;

import classes.Avion;
import classes.Vol;
import classes.VolAllerRetour;
import classes.VolSimple;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("PageLoginClient.fxml"));
        scene = new Scene(fxmlLoader.load(), 600, 700);
        
         Image icon = new Image("Images/icon_stage.png");
        stage.getIcons().add(icon);
        stage.setTitle("Flight Booking");
        stage.setScene(scene);
        stage.show();
    }


public static List<Vol> volList = new ArrayList<>();

    public static List<Vol> getVolList() {
        return volList;
    }

    public static void setVolList(List<Vol> volList) {
        App.volList = volList;
    }
    public static void main(String[] args) {
   Avion avionExample = new Avion("ExampleModel", "ExampleManufacturer", "ABC123", 8000.0, 200);


VolSimple volSimpleExample = new VolSimple("ABC001", "France", "Germany", "Paris Airport", "Berlin Airport",
        LocalDate.of(2023, 12, 1), avionExample, 500.0f, "Direct");


VolAllerRetour volAllerRetourExample = new VolAllerRetour("ABC002", "USA", "Canada", "New York Airport", "Toronto Airport",
        LocalDate.of(2023, 11, 15), avionExample, 700.0f, LocalDate.of(2023, 11, 30));


volList.add(volSimpleExample);
volList.add(volAllerRetourExample);
        volList.stream().forEach(System.out::println);
        launch();
    }
    
    public static void openMenuClient() throws Exception {
         
         
         FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("MenuPrincipalClient.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);
         
         
    }
    public static void openClientAccCreation() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CreationCompteClient.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);
    }
    
    public static void openClientReservation() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("PageSelectionRegion.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);
    }
    
    public static void openClientConsulterVol() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ConsulterVolClient.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);
    }
    
    public static void openConfirmationInscritClient() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ConfirmationInscritClient.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);
    }
    
    public static void openPageLoginClient() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("PageLoginClient.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);
    }
    
         public static void openPageSelectionRegionDestination() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("PageSelectionRegionDestination.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);
    }
          public static void openPage_voir_offres() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_voir_offres.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);
    }
         
             public static void openPage_choix_Pays() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_choix_Pays.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);
    }
    
    

}