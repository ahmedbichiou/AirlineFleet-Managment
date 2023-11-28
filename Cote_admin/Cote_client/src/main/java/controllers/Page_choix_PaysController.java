/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import com.mycompany.cote_client.App;
import static controllers.PageSelectionRegionController.selectedRegionDepart;
import static controllers.PageSelectionRegionDestinationController.selectedRegionArrive;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Spray
 */
public class Page_choix_PaysController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         System.out.println("depart "+selectedRegionDepart);
        System.out.println("arrive "+selectedRegionArrive);
       
    }    
    public void etape_1() throws Exception{
    
    App.openClientReservation();
    }
     public void etape_2() throws Exception{
    
    App.openPageSelectionRegionDestination();
    }
}
