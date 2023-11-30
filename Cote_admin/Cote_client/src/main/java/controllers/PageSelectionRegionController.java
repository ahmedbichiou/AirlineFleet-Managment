/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import com.mycompany.cote_client.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author nezih
 */
public class PageSelectionRegionController implements Initializable {

    static public String selectedRegionDepart;

    public static String getSelectedRegionDepart() {
        return selectedRegionDepart;
    }

    public static void setSelectedRegionDepart(String selectedRegionDepart) {
        PageSelectionRegionController.selectedRegionDepart = selectedRegionDepart;
    }
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void america_north_selected() throws Exception{
    
        selectedRegionDepart = "america_north";
        App.openPageSelectionRegionDestination();
    }
    public void america_south_selected() throws Exception{
        selectedRegionDepart = "america_south";
     App.openPageSelectionRegionDestination();
    }
    public void europe_selected() throws Exception{
        selectedRegionDepart = "europe";
     App.openPageSelectionRegionDestination();
    }
    public void africa_selected() throws Exception{
        selectedRegionDepart = "africa";
     App.openPageSelectionRegionDestination();
    }
    public void asia_selected() throws Exception{
        selectedRegionDepart = "asia";
     App.openPageSelectionRegionDestination();
    }
    public void oceania_selected() throws Exception{
        selectedRegionDepart = "oceania";
     App.openPageSelectionRegionDestination();
    }
     public void back() throws Exception{
    App.openMenuClient();
    }
    
}
