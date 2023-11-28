package com.mycompany.cote_client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
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



    public static void main(String[] args) {
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
         
             public static void openPage_choix_Pays() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_choix_Pays.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);
    }
    
    

}