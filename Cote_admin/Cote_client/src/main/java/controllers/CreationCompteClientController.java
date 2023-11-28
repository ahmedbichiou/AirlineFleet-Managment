/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import com.mycompany.cote_client.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author nezih
 */
public class CreationCompteClientController implements Initializable {

    @FXML
    private TextField nomClt;
    @FXML
    private TextField prenomClt;
    @FXML
    private TextField mdp;
    @FXML
    private DatePicker dateNaissance;
    @FXML
    private TextField emailClt;
    @FXML
    private Button button_Créer;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hints();
    }  
    public void openConfirmationInscritClient() throws Exception {
        App.openConfirmationInscritClient();
    }
    
    private void hints() 
    {
        nomClt.setPromptText("Enter votre nom");
        prenomClt.setPromptText("Enter votre prénom");
        mdp.setPromptText("Créer votre mot de passe");
        dateNaissance.setPromptText("Enter votre date de naissance");
        emailClt.setPromptText("Enter votre adresse email");
    }
    
    
}
