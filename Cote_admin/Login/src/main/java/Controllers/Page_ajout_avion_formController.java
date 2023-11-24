/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Spray
 */
public class Page_ajout_avion_formController implements Initializable {

     private String avion_selected;

    // Getter and setter for avion_selected
    public String getAvion_selected() {
        return avion_selected;
    }

    public void setAvion_selected(String avion_selected) {
        this.avion_selected = avion_selected;
    }
     

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void setup() {
        
        System.out.println("setup "+avion_selected);
    }
}
