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
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author nezih
 */
public class PageLoginClientController implements Initializable {

    
    @FXML
    private TextField email;
    @FXML
    private TextField password_login;
    @FXML
    private Button btn_login;
    @FXML
    private Rectangle main_rectangle;
    @FXML
    private Button btn_creation;
    @FXML
    private Text error;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
    hints();        
    styleclasses();        
    }
    
    
  //Utilities  
   
  
    public boolean verifClient() throws Exception {
         String userEmail = email.getText();
        String userPassword = password_login.getText();
        CRUD.retrieveClientsFromDB(ClientManager.getClientsByEmail());
       
        Client client = ClientManager.getClientByEmail(userEmail);

        if (client != null && client.getMdp().equals(userPassword)) {
            ClientManager.setAuthenticatedClient(client);
            return true; 
        }

        // Wrong credentials
        return false;
    }

    public void openMenuClient() throws Exception {
        boolean result = verifClient();
        if (result) {
            App.openMenuClient();
        } else {
            error.setText("email ou mot de passe incorrect!");
        }
    }
    public void openClientAccCreation() throws Exception {
        App.openClientAccCreation();
    }
    
    private void hints() 
    {
        email.setPromptText("Enter votre adresse email");
        password_login.setPromptText("Enter votre mot de passe");
    }
    private void styleclasses()
    {
            btn_login.getStyleClass().add("btn_login");
            main_rectangle.getStyleClass().add("main_rectangle");
            btn_creation.getStyleClass().add("btn_creation"); 
            email.getStyleClass().add( "text-field-custom");
            password_login.getStyleClass().add( "text-field-custom");
    }
}

