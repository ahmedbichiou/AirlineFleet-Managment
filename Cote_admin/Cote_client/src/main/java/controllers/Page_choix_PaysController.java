/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import com.mycompany.cote_client.App;
import static controllers.PageSelectionRegionController.selectedRegionDepart;
import static controllers.PageSelectionRegionDestinationController.selectedRegionArrive;
import java.net.URL;
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
    private Text retour_label;
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
List<String> europeAirports = new ArrayList<>();
europeAirports.add("Heathrow Airport (LHR), London, UK");
europeAirports.add("Charles de Gaulle Airport (CDG), Paris, France");
europeAirports.add("Frankfurt Airport (FRA), Frankfurt, Germany");
europeAirports.add("Amsterdam Airport Schiphol (AMS), Amsterdam, Netherlands");
europeAirports.add("Barcelona-El Prat Airport (BCN), Barcelona, Spain");
ObservableList<String> europe_airports = FXCollections.observableArrayList(europeAirports);

List<String> africaAirports = new ArrayList<>();
africaAirports.add("Tunis-Carthage International Airport (TUN), Tunis, Tunisia");
africaAirports.add("Cairo International Airport (CAI), Cairo, Egypt");
africaAirports.add("OR Tambo International Airport (JNB), Johannesburg, South Africa");
africaAirports.add("Addis Ababa Bole International Airport (ADD), Addis Ababa, Ethiopia");
africaAirports.add("Jomo Kenyatta International Airport (NBO), Nairobi, Kenya");
ObservableList<String> africa_airports = FXCollections.observableArrayList(africaAirports);

List<String> asiaAirports = new ArrayList<>();
asiaAirports.add("Beijing Capital International Airport (PEK), Beijing, China");
asiaAirports.add("Tokyo Haneda Airport (HND), Tokyo, Japan");
asiaAirports.add("Dubai International Airport (DXB), Dubai, UAE");
asiaAirports.add("Singapore Changi Airport (SIN), Singapore");
asiaAirports.add("Incheon International Airport (ICN), Seoul, South Korea");
ObservableList<String> asia_airports = FXCollections.observableArrayList(asiaAirports);

List<String> oceaniaAirports = new ArrayList<>();
oceaniaAirports.add("Sydney Airport (SYD), Sydney, Australia");
oceaniaAirports.add("Auckland Airport (AKL), Auckland, New Zealand");
oceaniaAirports.add("Brisbane Airport (BNE), Brisbane, Australia");
oceaniaAirports.add("Melbourne Airport (MEL), Melbourne, Australia");
oceaniaAirports.add("Honolulu International Airport (HNL), Honolulu, USA");
ObservableList<String> oceania_airports = FXCollections.observableArrayList(oceaniaAirports);

List<String> northAmericaAirports = new ArrayList<>();
northAmericaAirports.add("Hartsfield-Jackson Atlanta International Airport (ATL), Atlanta, USA");
northAmericaAirports.add("Los Angeles International Airport (LAX), Los Angeles, USA");
northAmericaAirports.add("John F. Kennedy International Airport (JFK), New York, USA");
northAmericaAirports.add("Toronto Pearson International Airport (YYZ), Toronto, Canada");
northAmericaAirports.add("Vancouver International Airport (YVR), Vancouver, Canada");
ObservableList<String> north_america_airports = FXCollections.observableArrayList(northAmericaAirports);

List<String> southAmericaAirports = new ArrayList<>();
southAmericaAirports.add("São Paulo/Guarulhos–Governador André Franco Montoro International Airport (GRU), São Paulo, Brazil");
southAmericaAirports.add("El Dorado International Airport (BOG), Bogotá, Colombia");
southAmericaAirports.add("Ministro Pistarini International Airport (EZE), Buenos Aires, Argentina");
southAmericaAirports.add("Comodoro Arturo Merino Benítez International Airport (SCL), Santiago, Chile");
southAmericaAirports.add("Jorge Chávez International Airport (LIM), Lima, Peru");
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

     @FXML
    private void handleAllerRetourToggleButton() {
        boolean isSelected = allerRetourToggleButton.isSelected();
        retour.setVisible(!isSelected);
        retour_label.setVisible(!isSelected);
    }
     public void rechercherOffre() throws Exception{
    
     App.openPage_voir_offres();
    }
}
