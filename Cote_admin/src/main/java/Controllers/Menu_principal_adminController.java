/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import com.mycompany.login.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

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
    public Button avion_supprimer;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        styleclasses();
        showImage();
        Initbackgrounds();
        
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
            avion_supprimer.getStyleClass().add("button_under");
            avion_afficher.getStyleClass().add("button_under");
            vol_settings.getStyleClass().add("avion_settings");
            account_settings.getStyleClass().add("avion_settings");
           
    }
    
    public void showImage() {
    try {

        Image image = new Image("Images/Tunisair.png");
        Image_utilisateur.setImage(image);
       
      
    } catch (Exception e) {
       System.out.println(e.getMessage());
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
    
}
