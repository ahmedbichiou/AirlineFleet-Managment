/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Classes.Avion;
import com.mycompany.login.App;
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
public class Page_ajout_avion_formController implements Initializable {

     private Avion avion_selected;

    // Getter and setter for avion_selected
    public Avion getAvion_selected() {
        return avion_selected;
    }

    public void setAvion_selected(Avion avion_selected) {
        this.avion_selected = avion_selected;
    }
     
    @FXML
    private TextField avion_reference; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hints();
        
    }    
    
    public void setup() {
        
        System.out.println(avion_selected);
    }
    
    public void etape2()throws Exception
    {
        if(avion_reference.getText().toString().equals(""))
        {
           
        }else{
             avion_selected.setReference(avion_reference.getText().toString());
              System.out.println(avion_selected);
              App.open_Ajout_avion_final(avion_selected);
        }
        
    }
    private void hints() 
    {
        avion_reference.setPromptText("Enter reference interne de l'avion");
        
    }
    public void open_Ajout_avion() throws Exception {
        App.open_ajout_avion();
        
        
    }
   
}
