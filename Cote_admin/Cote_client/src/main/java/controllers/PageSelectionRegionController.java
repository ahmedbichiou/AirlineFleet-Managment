/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBar;

/**
 * FXML Controller class
 *
 * @author nezih
 */
public class PageSelectionRegionController implements Initializable {

    public String selectedRegion;
   
  @FXML 
  private ButtonBar america_selected;
  @FXML 
  private ButtonBar europe_selected;
  @FXML 
  private ButtonBar africa_selected;
  @FXML 
  private ButtonBar asia_selected;
  @FXML 
  private ButtonBar oceania_selected;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void america_selected() throws Exception{
    
    }
    public void europe_selected() throws Exception{
    
    }
    public void africa_selected() throws Exception{
    
    }
    public void asia_selected() throws Exception{
    
    }
    public void oceania_selected() throws Exception{
    
    }
}
