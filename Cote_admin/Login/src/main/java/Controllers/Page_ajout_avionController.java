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

/**
 * FXML Controller class
 *
 * @author Spray
 */


public class Page_ajout_avionController implements Initializable {
public String avion_selected;
   
  @FXML 
  private Button A330_selected;
  @FXML 
  private Button A320_selected;
  @FXML 
  private Button B737_selected;
  @FXML 
  private Button B747_selected;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void A330_selected() throws Exception
            
    {
        avion_selected = "A330";
        App.open_ajout_avion_form(avion_selected);
    }
    public void A340_selected() throws Exception
    {
        avion_selected = "A340";
        App.open_ajout_avion_form(avion_selected);
    }
     public void B737_selected() throws Exception
    {
        avion_selected = "B737";
        App.open_ajout_avion_form(avion_selected);
    }
      public void B747_selected() throws Exception
    {
        avion_selected = "B747";
        App.open_ajout_avion_form(avion_selected);
    }
    
}
