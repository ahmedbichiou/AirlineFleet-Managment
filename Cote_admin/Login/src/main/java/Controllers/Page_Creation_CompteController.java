/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Classes.Compagnie_aerienne;
import OracleSGBD.CRUD;
import com.mycompany.login.App;
import static com.mycompany.login.App.compagnies;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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
       @FXML
       private Text Error_text;
        @FXML
    private TextField password_inscri_1;
     
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
        password_inscri_1.setPromptText("Enter password à nouveau");
    }
    private void styleclasses()
    {
        
            btnback_inscri.getStyleClass().add("btnback_inscri");
            btn_inscri.getStyleClass().add("btn_inscri");
           nom_inscri.getStyleClass().add( "text-field-custom");
           password_inscri.getStyleClass().add( "text-field-custom");
           annee_inscri.getStyleClass().add( "text-field-custom");
           pays_inscri.getStyleClass().add( "text-field-custom");
           password_inscri_1.getStyleClass().add( "text-field-custom");
           
    }
    
     public void openConfirmation_inscri() throws Exception {
         
         try {
    Compagnie_aerienne v= new Compagnie_aerienne(
            nom_inscri.getText(),
            password_inscri.getText(),
            pays_inscri.getText(),
            Integer.parseInt(annee_inscri.getText())
    );
    
    //verifcation des champs
    if((nom_inscri.getText().equals("")) || (pays_inscri.getText().equals(""))||(password_inscri.getText().equals("")) || (annee_inscri.getText().equals("")) ){
             Error_text.setText("Tous les champs sont obligatoire");
            }
    else if((!password_inscri_1.getText().equals(password_inscri.getText())))
    {
        Error_text.setText("Entrer le même mot de passe");
    }
    else if(App.searchCompagnieByNom(nom_inscri.getText()) == null)
    {
       compagnies.add(v); 
       CRUD.insertIntoDatabase(v);
       App.showAllCompagnies();
       App.openConfirmation_inscri();
    } else{
       Error_text.setText("Compagnie existe"); 
    }
    //end verifcation des champs
   
} catch (NumberFormatException e) {
    
    Error_text.setText("année non valide"); 
    
} catch (Exception e) {
    
    System.err.println("An error occurred: " + e.getMessage());
    e.printStackTrace(); 
}
       
         
    }
     
     
     
     
    
}
