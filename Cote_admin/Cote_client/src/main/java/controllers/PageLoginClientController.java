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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author nezih
 */
public class PageLoginClientController implements Initializable {

    
    @FXML
    private TextField nom_login;
    @FXML
    private TextField password_login;
    @FXML
    private Button btn_login;
    @FXML
    private Rectangle main_rectangle;
    @FXML
    private Button btn_creation;
    @FXML
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
    hints();        
    styleclasses();        
    }
    
    
  //Utilities  
   
  
    public boolean verifClient() throws Exception {
        return true;
    }
   
    public void openMenuClient() throws Exception {
        boolean result= verifClient();  
        if (result) {
            App.openMenuClient();
        }
        else{
            //wrong confidentiels
        }
    }
    public void openClientAccCreation() throws Exception {
        App.openClientAccCreation();
    }
    private void hints() 
    {
        nom_login.setPromptText("Enter votre nom");
        password_login.setPromptText("Enter votre mot de passe");
    }
    private void styleclasses()
    {
            btn_login.getStyleClass().add("btn_login");
            main_rectangle.getStyleClass().add("main_rectangle");
            btn_creation.getStyleClass().add("btn_creation"); 
            nom_login.getStyleClass().add( "text-field-custom");
            password_login.getStyleClass().add( "text-field-custom");
    }
}

