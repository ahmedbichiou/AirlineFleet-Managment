/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Classes.Avion;
import Classes.AvionGrandeTaille;
import Classes.AvionPetitTaille;
import com.mycompany.login.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import Controllers.Page_LoginController;
import static Controllers.Page_LoginController.compte_ouvert;
import OracleSGBD.CRUD;
/**
 * FXML Controller class
 *
 * @author Spray
 */
public class Page_ajout_avoin_finalController implements Initializable {

      private Avion avion_selected;
    @FXML
    private Text type;
    @FXML
    private Text reference;
    @FXML
    private Text modele;
    @FXML
    private Text portee;
    @FXML
    private Text nbSieges;
    @FXML
    private Text valeur_grand;
    @FXML
    private Text valeur_petit;
    @FXML
    private Text valeur_speciale;
    @FXML
    private ImageView Image_Avion;
   
    // Getter and setter for avion_selected
    public Avion getAvion_selected() {
        return avion_selected;
    }

    public void setAvion_selected(Avion avion_selected) {
        this.avion_selected = avion_selected;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      public void setup() {
        
        System.out.println(avion_selected);
        setAvionText(avion_selected);
    }
      
       public void setAvionText(Avion avion) {
        // Check the type of Avion and set text accordingly
        if (avion instanceof AvionPetitTaille) {
            type.setText("Avion Petit Taille");
             valeur_speciale.setText("" + ((AvionPetitTaille) avion).getSiege_1ereclass());
             valeur_grand.setOpacity(0);
            // Set other properties specific to AvionPetitTaille
        } else if (avion instanceof AvionGrandeTaille) {
            type.setText("Avion Grande Taille");
             valeur_speciale.setText("" + ((AvionGrandeTaille) avion).getCapacite_cargo_kg());
             valeur_petit.setOpacity(0);
            // Set other properties specific to AvionGrandeTaille
        } else {
            // Handle other types of Avion if needed
        }

        
        reference.setText("" + avion.getReference());
        modele.setText("" + avion.getModele());
        
        portee.setText("" + avion.getPortee()+"km");
        nbSieges.setText("" + avion.getCapacite());
        switch (avion.getModele()) {
    case "A320":
        showImage("Images/Icons/Airbus_A320.png");
        
        break;
    case "A330":
        showImage("Images/Icons/Airbus_A330.png");
       
        break;
    case "B737":
        showImage("Images/Icons/Boeing_737.png");
      
        break;
    case "B747":
        showImage("Images/Icons/Boeing_747.png");
     
        break;
    default:
        // Default case if modele does not match any known cases
        System.out.println("Unknown modele.");
        break;
}
    }
public void showImage(String img) {
    try {

        Image image = new Image(img);
        Image_Avion.setImage(image);
       
      
    } catch (Exception e) {
       System.out.println(e.getMessage());
    }
}
  public void openmenu_principal_admin() throws Exception
      {
          
       try {
    Page_LoginController.getCompte_ouvert().ajouterAvion(avion_selected.getReference(), avion_selected);
    CRUD.createAvion(avion_selected,compte_ouvert.getNom());
    App.openmenu_principal_admin();
} catch (Exception e) {
    
    System.err.println("An error occurred: " + e.getMessage());

}
          
      }
     public void open_ajout_avion_form() throws Exception
      {
          App.open_ajout_avion_form(avion_selected);
      }
        public void open_ajout_avion() throws Exception
      {
          App.open_ajout_avion();
      }
}

