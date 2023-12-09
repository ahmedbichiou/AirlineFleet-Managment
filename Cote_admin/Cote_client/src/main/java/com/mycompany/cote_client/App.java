package com.mycompany.cote_client;

import OracleSGBD.CRUD;
import classes.Avion;
import classes.Client;
import classes.Vol;
import classes.VolAllerRetour;
import classes.VolSimple;
import controllers.Page_siegesController;
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
import java.util.Map;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage  myStage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("PageLoginClient.fxml"));
        scene = new Scene(fxmlLoader.load(), 600, 700);
        
         Image icon = new Image("Images/icon_stage.png");
        stage.getIcons().add(icon);
        stage.setTitle("Flight Booking");
        stage.setScene(scene);
        stage.show();
        myStage = stage;
    }


public static List<Vol> volList = new ArrayList<>();

    public static List<Vol> getVolList() {
        return volList;
    }

    public static void setVolList(List<Vol> volList) {
        App.volList = volList;
    }
    public static void main(String[] args) {


CRUD.retrieveDataFromDB(volList);

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
    
             
             
             
             /*
          public static void openPageSieges() throws Exception {
              
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_sieges.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
       
        scene.setRoot(newSceneRoot);
    } */

         public static  void openPageSieges() throws Exception {
       
       
            
           FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_sieges.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage anotherStage = new Stage();
             Page_siegesController p = new Page_siegesController();
        p.setStage(anotherStage);
          Image icon = new Image("Images/icon_stage.png");
       anotherStage.getIcons().add(icon);
       anotherStage.setTitle("Flight Booking");
            anotherStage.setScene(scene);
            anotherStage.show();
         }
          public static  void openPageMenu() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("MenuPrincipalClient.fxml"));
        scene = new Scene(fxmlLoader.load(), 600, 700);
       
         Image icon = new Image("Images/icon_stage.png");
        myStage.getIcons().add(icon);
        myStage.setTitle("Flight Booking");
        myStage.setScene(scene);
        myStage.show();
     }
          
              public static  void openEtape1() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("PageSelectionRegion.fxml"));
        scene = new Scene(fxmlLoader.load(), 600, 700);
        
         Image icon = new Image("Images/icon_stage.png");
        myStage.getIcons().add(icon);
        myStage.setTitle("Flight Booking");
        myStage.setScene(scene);
        myStage.show();
     }
        public static  void openEtape2() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("PageSelectionRegionDestination.fxml"));
        scene = new Scene(fxmlLoader.load(), 600, 700);
        
         Image icon = new Image("Images/icon_stage.png");
        myStage.getIcons().add(icon);
        myStage.setTitle("Flight Booking");
        myStage.setScene(scene);
        myStage.show();
     }
        public static  void openEtape3() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_choix_Pays.fxml"));
        scene = new Scene(fxmlLoader.load(), 600, 700);
        
         Image icon = new Image("Images/icon_stage.png");
        myStage.getIcons().add(icon);
        myStage.setTitle("Flight Booking");
        myStage.setScene(scene);
        myStage.show();
     }
                public static  void openEtape4() throws Exception {
          FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_voir_offres.fxml"));
        scene = new Scene(fxmlLoader.load(), 600, 700);
        
         Image icon = new Image("Images/icon_stage.png");
        myStage.getIcons().add(icon);
        myStage.setTitle("Flight Booking");
        myStage.setScene(scene);
        myStage.show();
     }
             
                public static  void openPageConsulter() throws Exception {
       
       
            
          FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ConsulterVolClient.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage anotherStage = new Stage();
           
      
         Image icon = new Image("Images/icon_stage.png");
       anotherStage.getIcons().add(icon);
       anotherStage.setTitle("Reservation");
            anotherStage.setScene(scene);
            anotherStage.show();
         } 
                 
}