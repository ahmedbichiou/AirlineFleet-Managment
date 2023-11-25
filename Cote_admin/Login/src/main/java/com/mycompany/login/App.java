package com.mycompany.login;

import Classes.Avion;
import Controllers.Page_ajout_avion_formController;
import Controllers.Page_ajout_avoin_finalController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
  

    @Override
     public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_Login.fxml"));
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
    
     public static void openInscrir() throws Exception {
         
         
         FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_Creation_Compte.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);
         
         
    }
     public static void openLogin() throws Exception {
         
         
         FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_Login.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);
         
         
    }
     
      public static void openConfirmation_inscri() throws Exception {
         
         
         FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_confirmation_inscri.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);
         
         
    }
      
       public static void openmenu_principal_admin() throws Exception {
         
         
         FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Menu_principal_admin.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);
         
         
    }
       
       //MENUS AVIONS
        public static void open_ajout_avion() throws Exception {
         
         
         FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_ajout_avion.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);
         
         
    }
        
        public static void open_ajout_vol() throws Exception {
         
         
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_ajout_vol.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);
         
         
    }
        
         
                  
    public static void open_Ajout_avion_final(Avion avion_selected) throws Exception {
         
         
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_ajout_avoin_final.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Page_ajout_avoin_finalController controller = fxmlLoader.getController();
        controller.setAvion_selected(avion_selected);
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);
        controller.setup();
         
         
    }
    
        
         public static void open_ajout_avion_form(Avion avion_selected) throws Exception {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_ajout_avion_form.fxml"));
    Parent newSceneRoot = fxmlLoader.load();

    // Access the controller and set the avion_selected value
    Page_ajout_avion_formController controller = fxmlLoader.getController();
    controller.setAvion_selected(avion_selected);

    Parent currentRoot = scene.getRoot();
    scene.setRoot(newSceneRoot);

    // Call the setup method explicitly
    controller.setup();
}
public static void addFlight() throws Exception {

    }
         public static void handleBack() throws Exception {


        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Menu_principal_admin.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);


    }
        

}