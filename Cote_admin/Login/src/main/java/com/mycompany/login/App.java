package com.mycompany.login;

import Classes.Avion;
import Classes.Compagnie_aerienne;
import Classes.Vol;
import Controllers.Page_afficher_modifier_avionController;
import Controllers.Page_ajout_avion_formController;
import Controllers.Page_ajout_avoin_finalController;
import Controllers.Page_modifier_volController;
import OracleSGBD.CRUD;
import static OracleSGBD.OracleDBInitializer.createTables;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class App extends Application {
    public static List<Compagnie_aerienne> compagnies = new ArrayList<>();
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
        //added by ahmed 11/25 3.32
        Compagnie_aerienne Tunisair = new Compagnie_aerienne("Tunisair","1","Tunisie",1996);
        Compagnie_aerienne Tunisair2 = new Compagnie_aerienne("AirFrance", "1", "Tunisie", 1996);
        Compagnie_aerienne Tunisair3 = new Compagnie_aerienne("TurkishAirlines", "1", "Tunisie", 1996);
        Compagnie_aerienne Tunisair4 = new Compagnie_aerienne("Transavia", "1", "Tunisie", 1996);
        Compagnie_aerienne yes2 = new Compagnie_aerienne("11","11","11",11);
        compagnies.add(Tunisair);
        compagnies.add(Tunisair2);
        compagnies.add(Tunisair3);
        compagnies.add(Tunisair4);
        
        compagnies.add(yes2);
        
        //createTables();
        //end added by ahmed 11/25 3.32
        CRUD.loadCompagniesFromDatabase(compagnies);
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
    //added code here jihed
    public static void open_modifier_vol() throws Exception {
         
         
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_modifier_vol.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);
         
         
    }
    public static void open_annuler_vol() throws Exception {
         
         
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_annuler_vol.fxml"));
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
        //added code here jihed
        public static void addFlight() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Menu_principal_admin.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);

        }
         public static void handleBack() throws Exception {


        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Menu_principal_admin.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);


        }
        
//added by ahmed 11/25 3:31
         
      public static Compagnie_aerienne searchCompagnieByNom(String nom) {
        for (Compagnie_aerienne compagnie : compagnies) {
            if (compagnie.getNom().equals(nom)) {
                return compagnie;
            }
        }
        return null; // Not found
    }

    // Add Compagnie method
    public static void addCompagnie(Compagnie_aerienne newCompagnie) {
        compagnies.add(newCompagnie);
        System.out.println("Compagnie added successfully: " + newCompagnie);
    }

    // Delete Compagnie by nom method
    public static void deleteCompagnieByNom(String nom) {
        Iterator<Compagnie_aerienne> iterator = compagnies.iterator();
        while (iterator.hasNext()) {
            Compagnie_aerienne compagnie = iterator.next();
            if (compagnie.getNom().equals(nom)) {
                iterator.remove();
                System.out.println("Compagnie deleted successfully: " + compagnie);
                return; // Assuming each nom is unique
            }
        }
        System.out.println("Compagnie with nom " + nom + " not found.");
    }   
    
    public static List<Compagnie_aerienne> getCompagnies() {
        return compagnies;
    }
    public static void showAllCompagnies() {
        System.out.println("List of Compagnies:");
        for (Compagnie_aerienne compagnie : compagnies) {
            System.out.println(compagnie);
        }
    }
    // Set Compagnies
    public static void setCompagnies(List<Compagnie_aerienne> newCompagnies) {
        compagnies = newCompagnies;
    }
    
   
      
         public static void open_afficher_avion() throws Exception {
         
         
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_affichage_avion.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);
         
         
    }
        public static void open_Affichage_vols() throws Exception {
         
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_afficher_tous_les_vols.fxml"));
        Parent newSceneRoot = fxmlLoader.load();
        Parent currentRoot = scene.getRoot();
        scene.setRoot(newSceneRoot);
    }
         
         
        
      public static void open_afficher_modifier_avion(Avion avionTo_modifier) throws Exception {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_afficher_modifier_avion.fxml"));
    Parent newSceneRoot = fxmlLoader.load();
    Page_afficher_modifier_avionController controller = fxmlLoader.getController();
    controller.setAvion_selected(avionTo_modifier);

    Stage newStage = new Stage();
    newStage.setTitle("Modifier");

    Scene newScene = new Scene(newSceneRoot);
    newStage.setScene(newScene);

    Image icon = new Image("Images/icon_stage.png");
    newStage.getIcons().add(icon);
    newStage.setTitle("Flight Booking");

    // Set the stage and call setup
    controller.setStageAndSetup(newStage);

    newStage.show();
}
    public static void open_modifier_vol(Vol VolTo_modifier) throws Exception {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Page_modifier_vol.fxml"));
    Parent newSceneRoot = fxmlLoader.load();
    Page_modifier_volController controller = fxmlLoader.getController();
    controller.setVol_selected(VolTo_modifier);

    Stage newStage = new Stage();
    newStage.setTitle("Modifier");

    Scene newScene = new Scene(newSceneRoot);
    newStage.setScene(newScene);

    Image icon = new Image("Images/icon_stage.png");
    newStage.getIcons().add(icon);
    newStage.setTitle("Flight Booking");

    // Set the stage and call setup
    controller.setStageAndSetup(newStage);

    newStage.show();
}
    
 //end added by ahmed 11/25 3:31 by ahmed     
}