/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hints();
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
        /*
            btn_login.getStyleClass().add("btn_login");
            main_rectangle.getStyleClass().add("main_rectangle");
            btn_creation.getStyleClass().add("btn_creation"); */
           
    }
}
