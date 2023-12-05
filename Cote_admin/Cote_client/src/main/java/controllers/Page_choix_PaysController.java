/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import classes.Reservation;
import classes.ReservationSimple;
import classes.ReservationVolAllerRetour;
import com.mycompany.cote_client.App;
import static controllers.PageSelectionRegionController.selectedRegionDepart;
import static controllers.PageSelectionRegionDestinationController.selectedRegionArrive;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Spray
 */
public class Page_choix_PaysController implements Initializable {
    @FXML
   private ComboBox<String> dep_combo;
    @FXML
   private ComboBox<String> dest_combo;
   @FXML
private CheckBox allerRetourCheckbox;
    @FXML
  private  DatePicker retour;
     @FXML
  private  DatePicker aller;
    @FXML
    private Text retour_label;
  @FXML
  private Text erreur;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
List<String> europeAirports = new ArrayList<>();
europeAirports.add("UK");
europeAirports.add("France");
europeAirports.add("Germany");
europeAirports.add("Netherlands");
europeAirports.add("Spain");
ObservableList<String> europe_airports = FXCollections.observableArrayList(europeAirports);

List<String> africaAirports = new ArrayList<>();
africaAirports.add("Tunisia");
africaAirports.add("Egypt");
africaAirports.add("South Africa");
africaAirports.add("Ethiopia");
africaAirports.add("Kenya");
ObservableList<String> africa_airports = FXCollections.observableArrayList(africaAirports);

List<String> asiaAirports = new ArrayList<>();
asiaAirports.add("China");
asiaAirports.add("Japan");
asiaAirports.add("UAE");
asiaAirports.add("Singapore");
asiaAirports.add("South Korea");
ObservableList<String> asia_airports = FXCollections.observableArrayList(asiaAirports);

List<String> oceaniaAirports = new ArrayList<>();
oceaniaAirports.add("Australia");

ObservableList<String> oceania_airports = FXCollections.observableArrayList(oceaniaAirports);

List<String> northAmericaAirports = new ArrayList<>();
northAmericaAirports.add("Atlanta, USA");
northAmericaAirports.add("Los Angeles, USA");
northAmericaAirports.add("New York, USA");
northAmericaAirports.add("Toronto, Canada");
northAmericaAirports.add("Vancouver, Canada");
ObservableList<String> north_america_airports = FXCollections.observableArrayList(northAmericaAirports);

List<String> southAmericaAirports = new ArrayList<>();
southAmericaAirports.add("São Paulo, Brazil");
southAmericaAirports.add("Bogotá, Colombia");
southAmericaAirports.add("Buenos Aires, Argentina");
southAmericaAirports.add("Santiago, Chile");
southAmericaAirports.add("Lima, Peru");
ObservableList<String> south_america_airports = FXCollections.observableArrayList(southAmericaAirports);

// ... (rest of your code)

switch (selectedRegionDepart) {
    case "europe":
        dep_combo.setItems(europe_airports);
        break;
    case "africa":
        dep_combo.setItems(africa_airports);
        break;
    case "asia":
        dep_combo.setItems(asia_airports);
        break;
    case "oceania":
        dep_combo.setItems(oceania_airports);
        break;
    case "america_north":
        dep_combo.setItems(north_america_airports);
        break;
    case "america_south":
        dep_combo.setItems(south_america_airports);
        break;
    default:
        // Handle the case when the region is not recognized
        break;
}
switch (selectedRegionArrive) {
    case "europe":
        dest_combo.setItems(europe_airports);
        break;
    case "africa":
        dest_combo.setItems(africa_airports);
        break;
    case "asia":
        dest_combo.setItems(asia_airports);
        break;
    case "oceania":
        dest_combo.setItems(oceania_airports);
        break;
    case "america_north":
        dest_combo.setItems(north_america_airports);
        break;
    case "america_south":
        dest_combo.setItems(south_america_airports);
        break;
    default:
        // Handle the case when the region is not recognized
        break;
}
    
    }    
    public void etape_1() throws Exception{
    
    App.openClientReservation();
    }
     public void etape_2() throws Exception{
    
    App.openPageSelectionRegionDestination();
    }
     
   @FXML
    private ToggleButton allerRetourToggleButton;
 boolean isSelected = false ;
     @FXML
    private void handleAllerRetourToggleButton() {
         isSelected = allerRetourToggleButton.isSelected();
        retour.setVisible(!isSelected);
        retour_label.setVisible(!isSelected);
    }
   
   public static Reservation  reservation;
     public void rechercherOffre() throws Exception{
      String Pays_depart = dep_combo.getValue();
        String Pays_destination = dest_combo.getValue();
       LocalDate date_aller = aller.getValue();
      if(isSelected == false)
      {
       LocalDate  date_retour = retour.getValue();
           reservation = new ReservationVolAllerRetour(Pays_depart,Pays_destination,date_aller,date_retour);
           if(Pays_depart != null && Pays_destination != null && date_aller != null && retour.getValue() != null)
      {
         App.openPage_voir_offres();  
      }
            else
      {
          erreur.setText("Tous les champs sont obligatoire");
      }
      }else if(isSelected == true){
          reservation = new ReservationSimple(Pays_depart,Pays_destination,date_aller);
               if(Pays_depart != null && Pays_destination != null && date_aller != null)
      {
         App.openPage_voir_offres();  
      }
            else
      {
          erreur.setText("Tous les champs sont obligatoire");
      }
      }
      System.out.println(reservation);
    
    
      
     
     
    }
}
