/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import com.mycompany.cote_client.App;
import static controllers.PageSelectionRegionController.selectedRegionDepart;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Spray
 */
public class PageSelectionRegionDestinationController implements Initializable {

    static public String selectedRegionArrive;

    public static String getSelectedRegionArrive() {
        return selectedRegionArrive;
    }

    public static void setSelectedRegionArrive(String selectedRegionArrive) {
        PageSelectionRegionDestinationController.selectedRegionArrive = selectedRegionArrive;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
     public void america_north_selected() throws Exception{
    selectedRegionArrive = "america_north";
    App.openPage_choix_Pays();
    }
    public void america_south_selected() throws Exception{
    selectedRegionArrive = "america_south";
     App.openPage_choix_Pays();
    }
    public void europe_selected() throws Exception{
    selectedRegionArrive = "europe";
     App.openPage_choix_Pays();
    }
    public void africa_selected() throws Exception{
    selectedRegionArrive = "africa";
     App.openPage_choix_Pays();
    }
    public void asia_selected() throws Exception{
    selectedRegionArrive = "asia";
     App.openPage_choix_Pays();
    }
    public void oceania_selected() throws Exception{
    selectedRegionArrive = "oceania";
     App.openPage_choix_Pays();
    }
    public void etape_1() throws Exception{
    
    App.openClientReservation();
    }
}
