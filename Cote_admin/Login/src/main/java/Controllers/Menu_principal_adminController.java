/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Classes.AvionGrandeTaille;
import Classes.Vol;
import Classes.VolSimple;
import com.mycompany.login.App;
import Controllers.Page_LoginController;
import static Controllers.Page_LoginController.compte_ouvert;
import OracleSGBD.CRUD;

import java.net.URL;
import java.time.LocalDate;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Spray
 */
public class Menu_principal_adminController implements Initializable {

    @FXML
    public Rectangle avion_settings;
    @FXML
    public Rectangle account_settings;
    @FXML
    public Rectangle vol_settings;
    @FXML
    public Button avion_ajouter;
   
    @FXML
    public Button vol_ajouter;
     @FXML
    public Button vol_supprimer;
      @FXML
    public Button vol_afficher;
       @FXML
    public Button vol_modifier;
    @FXML
    public Button avion_afficher;
    @FXML 
    public ImageView Image_utilisateur;
    @FXML 
    public Text nom_utilisateur;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        styleclasses();
        showAccount();
        Initbackgrounds();
       // Page_LoginController.getCompte_ouvert().afficherAvions();
       /*
           AvionGrandeTaille avionGrandeTaille = new AvionGrandeTaille(
                "B737",
                "Boeing",
                "5",
                8000.0, // Replace with the actual portee value
                500,    // Replace with the actual capacite value
                200000  // Replace with the actual cargo capacity in kilograms
        );
        compte_ouvert.ajouterAvion("5", avionGrandeTaille);
            VolSimple volSimple = new VolSimple(
                "V123",
                "USA",
                "France",
                "JFK",
                "CDG",
                LocalDate.of(2023, 12, 1), // Replace with the actual date value
                avionGrandeTaille,
                1500.0f, // Replace with the actual price value
                "Direct"
        );
          compte_ouvert.ajouterVol("V123", volSimple);*/
       CRUD.retrieveAvionsFromDatabase(compte_ouvert.getList_Avions(),compte_ouvert.getNom());
       CRUD.retrieveDataFromDB(compte_ouvert.getNom(), compte_ouvert.getList_vols());
    }  
    private void Initbackgrounds()
            
    {
        Image image = new Image("Images/avion_M.png");
        avion_settings.setFill(new ImagePattern(image));
        Image image2 = new Image("Images/vol_background.jpg");
        vol_settings.setFill(new ImagePattern(image2));
    }
    
    private void styleclasses()
    {
        
            avion_settings.getStyleClass().add("avion_settings");
            avion_ajouter.getStyleClass().add("button_under");
          
            avion_afficher.getStyleClass().add("button_under");
            vol_settings.getStyleClass().add("avion_settings");
            account_settings.getStyleClass().add("avion_settings");
           
    }
    
    public void showAccount() {
        
    try {
        nom_utilisateur.setText(Page_LoginController.getCompte_ouvert().getNom());
       image_username();
       
      
    } catch (Exception e) {
       System.out.println(e.getMessage());
    }
}
    public  void image_username()
    {
        
      switch (Page_LoginController.getCompte_ouvert().getNom()) {
    case "Tunisair":
        if(App.searchCompagnieByNom("Tunisair") != null)
        {
       
        Image imageTunisair = new Image("Images/Tunisair.png");
        Image_utilisateur.setImage(imageTunisair);
        Image_utilisateur.setPreserveRatio(false);
        Image_utilisateur.setFitWidth(120);
        Image_utilisateur.setFitHeight(120);
        }
       
        break;

    case "AirFrance":
        if(App.searchCompagnieByNom("AirFrance") != null)
        {
     
        Image imageAirFrance = new Image("Images/Airlines/AirFrance.png");
        Image_utilisateur.setImage(imageAirFrance);
        Image_utilisateur.setPreserveRatio(false);
        Image_utilisateur.setFitWidth(120);
        Image_utilisateur.setFitHeight(120);
        }
        break;

    case "Transavia":
        if(App.searchCompagnieByNom("Transavia") != null)
        {
    
        Image imageTransavia = new Image("Images/Airlines/Transavia.png");
       Image_utilisateur.setImage(imageTransavia);
       Image_utilisateur.setPreserveRatio(false);
        Image_utilisateur.setFitWidth(110);
        Image_utilisateur.setFitHeight(110);
        Image_utilisateur.setStyle("-fx-background-size: stretch;" );
        }
        break;

    case "TurkishAirlines":
        if(App.searchCompagnieByNom("TurkishAirlines") != null)
        {
       
        Image imageTurkishAirlines = new Image("Images/Airlines/TurkishAirlines.png");
        Image_utilisateur.setImage(imageTurkishAirlines);
        Image_utilisateur.setPreserveRatio(false);
        Image_utilisateur.setFitWidth(110);
        Image_utilisateur.setFitHeight(110);
        Image_utilisateur.setStyle("-fx-background-size: stretch; ");
        }
        break;

    default:
        Image imageTurkishAirlines = new Image("Images/Airlines/default.png");
        Image_utilisateur.setImage(imageTurkishAirlines);
          Image_utilisateur.setPreserveRatio(false);
        Image_utilisateur.setFitWidth(120);
        Image_utilisateur.setFitHeight(120);
        break;
}
    }
    
    
    //--------------------------------------->routes
    public void openLogin() throws Exception {
        App.openLogin();
        
        
    }
    public void open_ajout_avion() throws Exception {
     
    App.open_ajout_avion();

        
        
    }
    
    public void open_ajout_vol() throws Exception {
        App.open_ajout_vol();
        
        
    }
    public void open_modifier_vol() throws Exception {
        App.open_modifier_vol();
        
        
    }
    public void open_annuler_vol() throws Exception {
        App.open_annuler_vol();
        
        
    }
    
     public void open_afficher_avion() throws Exception {
    
    App.open_afficher_avion(); 
        
    }
     
    public void open_Affichage_vols() throws Exception {
    App.open_Affichage_vols();
    }
    
}
