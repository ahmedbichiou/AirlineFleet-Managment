package Controllers;

import Classes.Vol;
import Classes.VolAllerRetour;
import static Controllers.Page_LoginController.compte_ouvert;
import OracleSGBD.CRUD;
import com.mycompany.login.App;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class Page_modifier_volController implements Initializable {

  
    
    @FXML
    private DatePicker datePickerDeparture;
    
  
    
    
    
    public Vol VolTo_modify;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialization logic here
       
       
    }

    @FXML
    private void handleSaveChanges(ActionEvent event) {
        // Logic to save the modifications of the flight
    }
    @FXML
    private void handleBack(ActionEvent event) throws Exception {
        // Logic to save the modifications of the flight
        App.handleBack();
    }
      public void setVol_selected(Vol VolTo_modify) {
        this.VolTo_modify = VolTo_modify;
    }
       public void setup() {
        
        System.out.println("print at setup modifyref"+VolTo_modify);
        
    }
       
     public void modifyref()   
   {
       boolean arrivee = false ,depart =false ,Avionref = false;
         
           if (datePickerDeparture.getValue() != null) {
               depart = true;
           }
          
         
                CRUD.updateDateAller(VolTo_modify.getRefVol(),datePickerDeparture.getValue());
                compte_ouvert.getList_vols().remove(VolTo_modify.getRefVol()) ;
              
              
                LocalDate selectedDate = datePickerDeparture.getValue();
                if( depart ) VolTo_modify.setDateAller(selectedDate);
               
                
                compte_ouvert.ajouterVol(VolTo_modify.getRefVol(),VolTo_modify);
                
           
              
                        try { 
                           stage.close();
                            App.open_Affichage_vols();
                        } catch (Exception ex) {
                            ex.printStackTrace();
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
