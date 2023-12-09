/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import OracleSGBD.CRUD;
import classes.Client;
import classes.ClientManager;
import com.mycompany.cote_client.App;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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
    private PasswordField mdp;
    @FXML
    private PasswordField mdpConfirmation;
    @FXML
    private DatePicker dateNaissance;
    @FXML
    private TextField emailClt;
    @FXML
    private Button button_Créer;
    @FXML
    private Text error;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hints();
        styleclasses();
    }  
    public void openConfirmationInscritClient() throws Exception {
        String nom = nomClt.getText();
    String prenom = prenomClt.getText();
    LocalDate dateNaiss = dateNaissance.getValue();
    String email = emailClt.getText();
    String password = mdp.getText();
    String confirmPassword = mdpConfirmation.getText();

    if (!password.equals(confirmPassword)) {
        error.setText("Password Confirmation Error");
        return; 
    }

    Client newClient = new Client(nom, prenom, dateNaiss, email, password);
     String resultMessage = ClientManager.addClient(newClient);
     
    if (resultMessage.equals("")) {
        App.openConfirmationInscritClient();
        CRUD.insertClient(newClient);
    } else {
        error.setText(resultMessage);
    }
    }
    
    public void back() throws Exception{
    App.openPageLoginClient();
    }
    
    private void hints() 
    {
        nomClt.setPromptText("Enter votre nom");
        prenomClt.setPromptText("Enter votre prénom");
        mdp.setPromptText("Créer votre mot de passe");
        mdpConfirmation.setPromptText("Confirmer votre mot de passe");
        dateNaissance.setPromptText("Enter votre date de naissance");
        emailClt.setPromptText("Enter votre adresse email");
    }
    
    private void styleclasses()
    {
            button_Créer.getStyleClass().add("btn_creation");
    }
    
   
    
}
