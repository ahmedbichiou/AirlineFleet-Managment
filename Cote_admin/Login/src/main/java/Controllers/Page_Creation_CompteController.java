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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Spray
 */
public class Page_Creation_CompteController implements Initializable {
    @FXML
    private TextField nom_inscri;
    @FXML
    private TextField password_inscri;
     @FXML
    private TextField annee_inscri;
      @FXML
    private TextField pays_inscri;
      @FXML
    private Button btn_inscri;
       @FXML
    private Button btnback_inscri;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hints();
        styleclasses();
    } 
    
     public void openLogin() throws Exception {
        App.openLogin();
    }
    
    private void hints() 
    {
        nom_inscri.setPromptText("Enter nom entreprise");
        password_inscri.setPromptText("Enter  mot de passe");
        annee_inscri.setPromptText("Enter  annee creation entreprise");
        pays_inscri.setPromptText("Enter pays d'origine");
    }
    private void styleclasses()
    {
        
            btnback_inscri.getStyleClass().add("btnback_inscri");
            btn_inscri.getStyleClass().add("btn_inscri");
           nom_inscri.getStyleClass().add( "text-field-custom");
           password_inscri.getStyleClass().add( "text-field-custom");
           annee_inscri.getStyleClass().add( "text-field-custom");
           pays_inscri.getStyleClass().add( "text-field-custom");
           
    }
    
     public void openConfirmation_inscri() throws Exception {
        App.openConfirmation_inscri();
    }
}
