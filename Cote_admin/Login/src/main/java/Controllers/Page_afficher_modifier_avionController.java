/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Classes.Avion;
import static Controllers.Page_LoginController.compte_ouvert;
import static Controllers.Page_affichage_avionController.extractFromAvionString;
import OracleSGBD.CRUD;
import com.mycompany.login.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Spray
 */
public class Page_afficher_modifier_avionController implements Initializable {
    Avion avionTo_modify;
    @FXML
    private TextField avion_reference;
    @FXML
    private Text  Error_text;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       setup();
    } 
    
     public void setAvion_selected(Avion avionTo_modify) {
        this.avionTo_modify = avionTo_modify;
    }

   public void setup() {
        
        System.out.println("print at setup modifyref"+avionTo_modify);
        
    }
   
   public void modifyref()
           
   {
       if(avion_reference.getText().toString().equals(""))
        {
           Error_text.setText("Le champ reference est obligatoire");
        }else{
            if(Page_LoginController.getCompte_ouvert().getList_Avions().get(avion_reference.getText())== null)
                    {
                CRUD.updateReference(avionTo_modify.getReference(),avion_reference.getText().toString());
                compte_ouvert.getList_Avions().remove(avionTo_modify.getReference()) ;
                
                avionTo_modify.setReference(avion_reference.getText().toString());
                compte_ouvert.ajouterAvion(avionTo_modify.getReference(),avionTo_modify);
                
           
              
                        try { 
                           stage.close();
                            App.open_afficher_avion();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
           
            }else
            {
                 Error_text.setText("Reference déja utilisé");
            }
            
             
        }
      
   }
   
     private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void closeStage() {
        if (stage != null) {
            stage.close();
        }
    }

    public void setStageAndSetup(Stage stage) {
        setStage(stage);
        setup();
    }
    
}
