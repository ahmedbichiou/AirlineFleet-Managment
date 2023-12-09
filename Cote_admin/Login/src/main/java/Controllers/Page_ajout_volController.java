/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Classes.Avion;
import static Classes.Pays_et_Aeroport.Africa;
import static Classes.Pays_et_Aeroport.Asia;
import static Classes.Pays_et_Aeroport.Egypt_Airports;
import static Classes.Pays_et_Aeroport.Europe;
import static Classes.Pays_et_Aeroport.North_america;
import static Classes.Pays_et_Aeroport.Oceania;
import static Classes.Pays_et_Aeroport.Regions;
import static Classes.Pays_et_Aeroport.South_america;
import static Classes.Pays_et_Aeroport.Tunisia_Airports;
import static Classes.Pays_et_Aeroport.northAmerica;
import static Classes.Pays_et_Aeroport.southAmerica;
import Classes.Pays_et_Aeroport;
import static Classes.Pays_et_Aeroport.Australia_Airports;
import static Classes.Pays_et_Aeroport.Brazil_Airports;
import static Classes.Pays_et_Aeroport.Canada_Airports;
import static Classes.Pays_et_Aeroport.China_Airports;
import static Classes.Pays_et_Aeroport.Colombia_Airports;
import static Classes.Pays_et_Aeroport.Ethiopia_Airports;
import static Classes.Pays_et_Aeroport.France_Airports;
import static Classes.Pays_et_Aeroport.Germany_Airports;
import static Classes.Pays_et_Aeroport.Japan_Airports;
import static Classes.Pays_et_Aeroport.Kenya_Airports;
import static Classes.Pays_et_Aeroport.Netherlands_Airports;
import static Classes.Pays_et_Aeroport.Singapore_Airports;
import static Classes.Pays_et_Aeroport.SouthAfrica_Airports;
import static Classes.Pays_et_Aeroport.SouthKorea_Airports;
import static Classes.Pays_et_Aeroport.Spain_Airports;
import static Classes.Pays_et_Aeroport.UAE_Airports;
import static Classes.Pays_et_Aeroport.UK_Airports;
import static Classes.Pays_et_Aeroport.USA_Airports;
import Classes.Vol;
import Classes.VolAllerRetour;
import Classes.VolSimple;
import static Controllers.Page_LoginController.compte_ouvert;
import OracleSGBD.CRUD;
import com.mycompany.login.App;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Jihed
 */
public class Page_ajout_volController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private TextField numero_vol;
    @FXML
    private ComboBox<String> pays_depart;
      @FXML
    private ComboBox<String> Region_depart;
        @FXML
    private ComboBox<String> Region_arrivee;
    @FXML
    private ComboBox<String> pays_arrivee;
    @FXML
    private DatePicker date_depart;

    @FXML
    private ComboBox<String> Type_Avion; // Assuming the ComboBox holds Strings
    @FXML
    private DatePicker Date_de_retour;
    @FXML
    private ToggleButton allerRetourToggleButton;
    @FXML
    private ToggleButton Type_btn;
    @FXML
    private TextField Prix;
    @FXML
    private ComboBox<String> Aeroport_depart; // Assuming the ComboBox holds Strings
    @FXML
    private ComboBox<String> Aeroport_arrivee; // Assuming the ComboBox holds Strings
    @FXML
    private Button addFlight;
    @FXML
    private ComboBox<String> type;
    @FXML
    private Text erreur;
    
    
boolean selected_retour = true;
boolean selected_type = false;
     @FXML
   private void handleAllerRetourToggleButton() {
    Date_de_retour.setVisible(true);
    allerRetourToggleButton.setSelected(false);
     type.setVisible(false);
    Type_btn.setSelected(true);
    selected_retour = true;
    selected_type = false;
    
}

    

    @FXML
   private void handleTypeToggleButton() {
    type.setVisible(true);
    Type_btn.setSelected(false);
    allerRetourToggleButton.setSelected(true);
    Date_de_retour.setVisible(false);
    selected_retour = false;
    selected_type = true;
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Type_btn.setSelected(true);
        compte_ouvert.afficherVols();
        Region_depart.setItems(Regions);
        Region_arrivee.setItems(Regions);
         type.setVisible(false);
         Set<String> keys = compte_ouvert.getList_Avions().keySet();
         ArrayList<String> references = new ArrayList();
         
        for (String key : keys) {
            references.add(key);
        }
       ObservableList<String> References = FXCollections.observableArrayList(references);
        Type_Avion.setItems(References);
         type.getItems().addAll( "1ere class", "Economie");
       
    }
    public void refresh_dep()
    {
        pays_depart.setValue("Pays Depart");
        try{
             switch (Region_depart.getValue()) {
                case "Africa":
                    pays_depart.setItems(Africa);
                    break;
                case "North America":
                    pays_depart.setItems(North_america);
                    break;
                case "South America":
                    pays_depart.setItems(South_america);
                    break;
                case "Oceania":
                    pays_depart.setItems(Oceania);
                    break;
                case "Asia":
                    pays_depart.setItems(Asia);
                    break;
                case "Europe":
                    pays_depart.setItems(Europe);
                    break;
                default:
                    pays_depart.setItems(FXCollections.emptyObservableList());
                    break;
            }}
             catch(Exception e)
                     {
                     
                     }
        
         
         
    }
    
    public void refresh_arriv()
    {
         pays_arrivee.setValue("Pays Arrivee");
        switch (Region_arrivee.getValue()) {
    case "Africa":
        pays_arrivee.setItems(Africa);
        break;
    case "North America":
        pays_arrivee.setItems(North_america);
        break;
    case "South America":
        pays_arrivee.setItems(South_america);
        break;
    case "Oceania":
        pays_arrivee.setItems(Oceania);
        break;
    case "Asia":
        pays_arrivee.setItems(Asia);
        break;
    case "Europe":
        pays_arrivee.setItems(Europe);
        break;
    default:
        pays_arrivee.setItems(FXCollections.emptyObservableList());
        break;
}
  

    }
    public void refresh_aerport_dep()
    {
         Aeroport_depart.setValue("Aeroport Depart");
       switch (pays_depart.getValue()) {
    case "Tunisia":
        Aeroport_depart.setItems(Tunisia_Airports);
        break;
    case "Egypt":
        Aeroport_depart.setItems(Egypt_Airports);
        break;
    case "South Africa":
        Aeroport_depart.setItems(SouthAfrica_Airports);
        break;
    case "Ethiopia":
        Aeroport_depart.setItems(Ethiopia_Airports);
        break;
    case "Kenya":
        Aeroport_depart.setItems(Kenya_Airports);
        break;
    case "UK":
        Aeroport_depart.setItems(UK_Airports);
        break;
    case "France":
        Aeroport_depart.setItems(France_Airports);
        break;
    case "Germany":
        Aeroport_depart.setItems(Germany_Airports);
        break;
    case "Netherlands":
        Aeroport_depart.setItems(Netherlands_Airports);
        break;
    case "Spain":
        Aeroport_depart.setItems(Spain_Airports);
        break;
    case "China":
        Aeroport_depart.setItems(China_Airports);
        break;
    case "Japan":
        Aeroport_depart.setItems(Japan_Airports);
        break;
    case "UAE":
        Aeroport_depart.setItems(UAE_Airports);
        break;
    case "Singapore":
        Aeroport_depart.setItems(Singapore_Airports);
        break;
    case "South Korea":
        Aeroport_depart.setItems(SouthKorea_Airports);
        break;
    case "Australia":
        Aeroport_depart.setItems(Australia_Airports);
        break;
    case "Atlanta, USA":
        Aeroport_depart.setItems(USA_Airports);
        break;
    case "Los Angeles, USA":
        Aeroport_depart.setItems(USA_Airports);
        break;
    case "New York, USA":
        Aeroport_depart.setItems(USA_Airports);
        break;
    case "Toronto, Canada":
        Aeroport_depart.setItems(Canada_Airports);
        break;
    case "Vancouver, Canada":
        Aeroport_depart.setItems(Canada_Airports);
        break;
    case "São Paulo, Brazil":
        Aeroport_depart.setItems(Brazil_Airports);
        break;
    case "Bogotá, Colombia":
        Aeroport_depart.setItems(Colombia_Airports);
        break;
    // Add cases for other countries as needed
    default:
        Aeroport_depart.setItems(FXCollections.emptyObservableList());
        break;
}
    
    }
   public void refresh_aerport_arr()
{
     Aeroport_arrivee.setValue("Aeroport Arrivee");
    switch (pays_arrivee.getValue()) {
        case "Tunisia":
            Aeroport_arrivee.setItems(Tunisia_Airports);
            break;
        case "Egypt":
            Aeroport_arrivee.setItems(Egypt_Airports);
            break;
        case "South Africa":
            Aeroport_arrivee.setItems(SouthAfrica_Airports);
            break;
        case "Ethiopia":
            Aeroport_arrivee.setItems(Ethiopia_Airports);
            break;
        case "Kenya":
            Aeroport_arrivee.setItems(Kenya_Airports);
            break;
        case "UK":
            Aeroport_arrivee.setItems(UK_Airports);
            break;
        case "France":
            Aeroport_arrivee.setItems(France_Airports);
            break;
        case "Germany":
            Aeroport_arrivee.setItems(Germany_Airports);
            break;
        case "Netherlands":
            Aeroport_arrivee.setItems(Netherlands_Airports);
            break;
        case "Spain":
            Aeroport_arrivee.setItems(Spain_Airports);
            break;
        case "China":
            Aeroport_arrivee.setItems(China_Airports);
            break;
        case "Japan":
            Aeroport_arrivee.setItems(Japan_Airports);
            break;
        case "UAE":
            Aeroport_arrivee.setItems(UAE_Airports);
            break;
        case "Singapore":
            Aeroport_arrivee.setItems(Singapore_Airports);
            break;
        case "South Korea":
            Aeroport_arrivee.setItems(SouthKorea_Airports);
            break;
        case "Australia":
            Aeroport_arrivee.setItems(Australia_Airports);
            break;
        case "Atlanta, USA":
            Aeroport_arrivee.setItems(USA_Airports);
            break;
        case "Los Angeles, USA":
            Aeroport_arrivee.setItems(USA_Airports);
            break;
        case "New York, USA":
            Aeroport_arrivee.setItems(USA_Airports);
            break;
        case "Toronto, Canada":
            Aeroport_arrivee.setItems(Canada_Airports);
            break;
        case "Vancouver, Canada":
            Aeroport_arrivee.setItems(Canada_Airports);
            break;
        case "São Paulo, Brazil":
            Aeroport_arrivee.setItems(Brazil_Airports);
            break;
        case "Bogotá, Colombia":
            Aeroport_arrivee.setItems(Colombia_Airports);
            break;
        // Add cases for other countries as needed
        default:
            Aeroport_arrivee.setItems(FXCollections.emptyObservableList());
            break;
    }
    

}

    @FXML
    private void addFlight(ActionEvent event) throws Exception {
        App.addFlight();
        // Implement your logic to add a flight here
        // For example, validate the input and then add the flight to the database
    }
    @FXML
    public void handleBack() throws Exception {
        App.handleBack();
        
        
    }
    
       public void openmenu_principal_admin() throws Exception
      {
          App.openmenu_principal_admin();
      }
        
       public void addVol() {
        try
        {
        String refVol = numero_vol.getText();
        String paysDepart = pays_depart.getValue();;
        String paysDest = pays_arrivee.getValue();
        String aeroportDep = Aeroport_depart.getValue(); 
        String aeroportDest = Aeroport_arrivee.getValue();
        LocalDate dateAller = date_depart.getValue();
        LocalDate dateRetour = Date_de_retour.getValue();
        
           Avion avion = compte_ouvert.getList_Avions().get(Type_Avion.getValue()); 
      
        
        float prix = Float.parseFloat(Prix.getText()); // Assuming Prix is a float value
        String type_vol = type.getValue();
 
      
       
       if(selected_retour)
       {
           if (refVol != null && !refVol.isEmpty() &&
    paysDepart != null && !paysDepart.isEmpty() &&
    paysDest != null && !paysDest.isEmpty() &&
    aeroportDep != null && !aeroportDep.isEmpty() &&
    aeroportDest != null && !aeroportDest.isEmpty() &&
    dateAller != null &&
    dateRetour != null &&
    avion != null &&
    !Type_Avion.getValue().isEmpty() &&
    Prix != null && !Prix.getText().isEmpty()) {

     VolAllerRetour vol = new VolAllerRetour(refVol, paysDepart, paysDest, aeroportDep,
                                               aeroportDest,dateAller,avion, prix,
                                               dateRetour);   
          if (!compte_ouvert.getList_vols().containsKey(refVol)) {
       compte_ouvert.getList_vols().put(refVol, vol);
       CRUD.insertVolIntoDatabase(vol,compte_ouvert.getNom());
        System.out.println("Vol ajouté avec succès. ID : " + refVol + ", Vol : " + vol);
         App.openmenu_principal_admin();
    } else {
        erreur.setText("Un vol avec l'ID " + refVol + " existe déjà.");
        
    }

} else {
    erreur.setText("Tous les cases sont obligatoire.");
}

       
       }else if(selected_type)
       {
           if (refVol != null && !refVol.isEmpty() &&
    paysDepart != null && !paysDepart.isEmpty() &&
    paysDest != null && !paysDest.isEmpty() &&
    aeroportDep != null && !aeroportDep.isEmpty() &&
    aeroportDest != null && !aeroportDest.isEmpty() &&
    dateAller != null &&
    avion != null &&
    !Type_Avion.getValue().isEmpty() &&
    Prix != null && !Prix.getText().isEmpty() &&
    type_vol != null && !type_vol.isEmpty()) {

     VolSimple vol = new VolSimple(refVol, paysDepart, paysDest, aeroportDep,
                                               aeroportDest,dateAller,avion, prix,
                                               type_vol);  
                if (!compte_ouvert.getList_vols().containsKey(refVol)) {
       compte_ouvert.getList_vols().put(refVol, vol);
       CRUD.insertVolIntoDatabase(vol,compte_ouvert.getNom());
        System.out.println("Vol ajouté avec succès. ID : " + refVol + ", Vol : " + vol);
         App.openmenu_principal_admin();
    } else {
        erreur.setText("Un vol avec l'ID " + refVol + " existe déjà.");
        
    }

} else {
    erreur.setText("Tous les cases sont obligatoire.");
}

           
       }
        
          } catch (Exception e)
                {
                   erreur.setText("Erreur d'ajout");
                }
      
       
    }
}
