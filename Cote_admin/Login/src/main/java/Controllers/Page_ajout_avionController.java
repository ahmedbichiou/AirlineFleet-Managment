/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Classes.AvionGrandeTaille;
import Classes.AvionPetitTaille;
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
public String marque_avion;
public int nbr_siege;
private double portee;
   
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
        marque_avion = "Airbus";
        nbr_siege =260;
        portee = 11750;
        AvionGrandeTaille  v = new AvionGrandeTaille(avion_selected,marque_avion,"",portee, nbr_siege,10000.0);
        App.open_ajout_avion_form(v);
    }
    public void A320_selected() throws Exception
    {
        avion_selected = "A320";
        marque_avion = "Airbus";
         nbr_siege =170;
         portee = 6150;
        AvionPetitTaille  v = new AvionPetitTaille(avion_selected,marque_avion,"",portee, nbr_siege,30);
        App.open_ajout_avion_form(v);
    }
     public void B737_selected() throws Exception
    {
        avion_selected = "B737";
        marque_avion = "Boeing";
         nbr_siege =215;
         portee = 7084;
         AvionPetitTaille  v = new AvionPetitTaille(avion_selected,marque_avion,"",portee, nbr_siege,30);
        App.open_ajout_avion_form(v);
    }
      public void B747_selected() throws Exception
    {
        avion_selected = "B747";
        marque_avion = "Boeing";
         nbr_siege =467;
         portee = 14430;
          AvionGrandeTaille  v = new AvionGrandeTaille(avion_selected,marque_avion,"",portee, nbr_siege,15000.0);
        App.open_ajout_avion_form(v);
    }
      public void openmenu_principal_admin() throws Exception
      {
          App.openmenu_principal_admin();
      }
    
}
