/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import classes.ReservationSimple;
import classes.ReservationVolAllerRetour;
import classes.Vol;
import classes.VolAllerRetour;
import classes.VolSimple;
import com.mycompany.cote_client.App;
import static com.mycompany.cote_client.App.volList;
import static controllers.Page_choix_PaysController.reservation;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Spray
 */
public class Page_voir_offresController implements Initializable {

  

    
    
       public static String extractFromVolString(String avionToString,String toExtract) {
        int start = avionToString.indexOf(toExtract) + toExtract.length();
        int end = avionToString.indexOf("'", start);

        if (start != -1 && end != -1) {
            return avionToString.substring(start, end);
        } else {
            return null;
        }
    }

    
    
    public static boolean isVolAllerRetour(String volString) {
        return volString.contains("dateRetour");
    }
    
    public static boolean refvolcompagnie(String volString,String type) {
        return volString.contains(type);
    }

    public static boolean isVolSimple(String volString) {
        return !volString.contains("dateRetour");
    }
 
    
      @FXML
    private ListView<Map.Entry<Integer, String>> hashMapListView;
    
  
    public void etape_1() throws Exception{
    
    App.openClientReservation();
    }
     public void etape_2() throws Exception{
    
    App.openPageSelectionRegionDestination();
    }
     public void etape_3() throws Exception{
         App.openPage_choix_Pays();
     }
private boolean compareDates(LocalDate datePickerDate, LocalDate comparisonDate) {
        if (datePickerDate.isEqual(comparisonDate)) {
           return true;
        } else {
           return false;
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
     Map<Integer, String> exampleHashMap = new HashMap<>();
int key = 0;

for (Vol vol : volList) {
    if (reservation instanceof ReservationVolAllerRetour) {
        if(vol instanceof VolAllerRetour)
        {
            
            if( compareDates(((VolAllerRetour) vol).getDateRetour(),((ReservationVolAllerRetour) reservation).getDate_retour())&& vol.getPaysDepart().equals(reservation.getPays_depart()) && vol.getPaysDest().equals(reservation.getPays_destination()) &&compareDates(vol.getDateAller(),reservation.getDate_aller()) )
                {
                    System.out.println("Value: " + vol);
                exampleHashMap.put(key, vol.toString());
                key++; 
                }
        }
    
}
    else{
        if(vol instanceof VolSimple)
        {
            
            if(vol.getPaysDepart().equals(reservation.getPays_depart()) && vol.getPaysDest().equals(reservation.getPays_destination()) &&compareDates(vol.getDateAller(),reservation.getDate_aller()) )
                {
                    System.out.println("Value: " + vol);
                exampleHashMap.put(key, vol.toString());
                key++; 
                }
        }
    }
    
   
}
     


        ObservableList<Map.Entry<Integer, String>> items = FXCollections.observableArrayList(exampleHashMap.entrySet());


        hashMapListView.setItems(items);


        hashMapListView.setCellFactory(new Callback<ListView<Map.Entry<Integer, String>>, ListCell<Map.Entry<Integer, String>>>() {
            @Override
            public ListCell<Map.Entry<Integer, String>> call(ListView<Map.Entry<Integer, String>> param) {
                return new ListCell<Map.Entry<Integer, String>>() {
                    private final ImageView imageView = new ImageView();
                    private final Button editButton = new Button("Choisir");
                    
                    private final Button negativeButton = new Button("negative");   
                    private final Button negativeButton2 = new Button("negative");  
                    private final Button negativeButton3 = new Button("negative");  
                    private final Button negativeButton4 = new Button("negative");
   @Override
protected void updateItem(Map.Entry<Integer, String> entry, boolean empty) {
    super.updateItem(entry, empty);
    
negativeButton.getStyleClass().add("image-button1");
negativeButton2.getStyleClass().add("image-button2");
negativeButton3.getStyleClass().add("image-button2");
negativeButton4.getStyleClass().add("image-button2");
 editButton.getStyleClass().add("btn_login");

    if (empty || entry == null) {
        setText(null);
        setGraphic(null);
    } else {
            String refvol = extractFromVolString(entry.getValue(),"refVol='");
            String pays_dep = extractFromVolString(entry.getValue(),", paysDepart='");
            String paysDestination = extractFromVolString(entry.getValue(), ", paysDest='");
            String aeroportDep = extractFromVolString(entry.getValue(), ", aeroportDep='");
            String aeroportDest = extractFromVolString(entry.getValue(), ", aeroportDest='");
            String type = extractFromVolString(entry.getValue(), ", typeVol='");

            
            String dateAller = extractFromVolString(entry.getValue(), ", dateAller='");
            String dateRetour = extractFromVolString(entry.getValue(), ", dateRetour='"); 
            String avionReference = extractFromVolString(entry.getValue(), ", ref avion='");
            String prixString = extractFromVolString(entry.getValue(), ", prix='");

System.out.println("Référence de l'avion: " + avionReference);
System.out.println("Prix: " + prixString);
        System.out.println("le valeur refvol = " + refvol );
        System.out.println("le valeur pays_dep = " + pays_dep );
        System.out.println("Aeroport de départ: " + aeroportDep);
System.out.println("Aeroport de destination: " + aeroportDest);



System.out.println("Pays_destination: " + paysDestination);
System.out.println("date_aller: " + dateAller);
System.out.println("date_retour: " + dateRetour);
         String valuetoshow;
        valuetoshow = "Reference vol  : "+ refvol + "\n";
        valuetoshow += pays_dep + " -----> " + paysDestination +"\n";
        valuetoshow += aeroportDep + " -----> " + aeroportDest +"\n" ;
        valuetoshow += "Date aller : "+ dateAller+"\n" ;
        if(isVolAllerRetour(entry.getValue()))valuetoshow += "Date Retour  : " + dateRetour+"\n" ;
        if(isVolSimple(entry.getValue()))valuetoshow += "Type  : " +type+"\n" ;
        valuetoshow += "prix: "+ prixString ;
        //setText(entry.getValue());
        setText(valuetoshow);
        //setText(entry.getValue());
   String showImage= "Images/Icons/Transavia.png";


      if (refvolcompagnie(entry.getValue(),"TO")) {
        showImage= "Images/Icons/Transavia.png";
       }
      else if(refvolcompagnie(entry.getValue(),"TU"))
       {
          showImage= "Images/Icons/Tunisair.png";        
        }
        

         Image image = new Image(showImage);
                            imageView.setImage(image);
                             imageView.setPreserveRatio(false);
                            imageView.setFitWidth(110);
                            imageView.setFitHeight(85);


        editButton.setOnAction(event -> handlechoisirButton(entry));
    


        Region spacer = new Region();
        spacer.setMinWidth(10);

        VBox buttonsContainer = new VBox(negativeButton,editButton,negativeButton2);
       
        HBox vBox = new HBox( imageView,negativeButton4,buttonsContainer,negativeButton3);
        HBox.setHgrow(vBox, javafx.scene.layout.Priority.ALWAYS); // Make VBox expand horizontally

        setGraphic(vBox);
    }
}

    private void handlechoisirButton(Map.Entry<Integer, String> entry) {
                  System.out.println("choisir button clicked for item: " + entry);
             reservation.setRefvol(extractFromVolString(entry.getValue(),"refVol='"));
             reservation.setPrix(Float.parseFloat(extractFromVolString(entry.getValue(), ", prix='")));
             reservation.setrefAvion(extractFromVolString(entry.getValue(), ", ref avion='"));
             if (reservation instanceof ReservationVolAllerRetour) {
                 
                 if(isVolAllerRetour(entry.getValue()))   
                 {
                     LocalDate  retourDate = null;
                     try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    retourDate = LocalDate.parse(extractFromVolString(entry.getValue(), ", dateRetour='"), formatter);
                     }
                       catch (Exception e) {
                                System.err.println("Error parsing the string to LocalDate: " + e.getMessage());
                            }
                     ((ReservationVolAllerRetour) reservation).setDate_retour(retourDate);
                 }
                 
             }
              if (reservation instanceof ReservationSimple) {
              ((ReservationSimple) reservation).setType(extractFromVolString(entry.getValue(), ", typeVol='"));
              }
              
                        try { 
                          App.openPageSieges();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
   }

               


   
                };
            }
        }); 

    }
   }

    

