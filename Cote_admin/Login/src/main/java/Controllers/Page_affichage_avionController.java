/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Classes.Avion;
import static Controllers.Page_LoginController.compte_ouvert;
import OracleSGBD.CRUD;
import com.mycompany.login.App;
import java.net.URL;
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
public class Page_affichage_avionController implements Initializable {

    
    
       public static String extractFromAvionString(String avionToString,String toExtract) {
        int start = avionToString.indexOf(toExtract) + toExtract.length();
        int end = avionToString.indexOf("'", start);

        if (start != -1 && end != -1) {
            return avionToString.substring(start, end);
        } else {
            return null;
        }
    }

    
    
    
    
      @FXML
    private ListView<Map.Entry<Integer, String>> hashMapListView;
    
  
    
     public void openmenu_principal_admin() throws Exception
      {
          App.openmenu_principal_admin();
      }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Map<Integer, String> exampleHashMap = new HashMap<>();
          int key = 0;
for (Avion value : compte_ouvert.getList_Avions().values()) {
            System.out.println("Value: " + value);
            exampleHashMap.put(key, value.toString());
            key++;
        }
     


        ObservableList<Map.Entry<Integer, String>> items = FXCollections.observableArrayList(exampleHashMap.entrySet());


        hashMapListView.setItems(items);


        hashMapListView.setCellFactory(new Callback<ListView<Map.Entry<Integer, String>>, ListCell<Map.Entry<Integer, String>>>() {
            @Override
            public ListCell<Map.Entry<Integer, String>> call(ListView<Map.Entry<Integer, String>> param) {
                return new ListCell<Map.Entry<Integer, String>>() {
                    private final ImageView imageView = new ImageView();
                    private final Button editButton = new Button("Editer ");
                    private final Button deleteButton = new Button("Delete");
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
 deleteButton.getStyleClass().add("btn_login2");
    if (empty || entry == null) {
        setText(null);
        setGraphic(null);
    } else {

        
        String valuetoshow;
        valuetoshow = "Reference : "+extractFromAvionString(entry.getValue(),"reference='")+"\n";
        valuetoshow += "Modele : "+extractFromAvionString(entry.getValue()," modele='")+"           "+"capacite : "+extractFromAvionString(entry.getValue(),", capacite='")+"\n";
        valuetoshow += "portee : "+extractFromAvionString(entry.getValue(),", portee='")+"           "+"Fabriquant : "+extractFromAvionString(entry.getValue()," compagnieFabricante='")+"\n";
        
        //setText(entry.getValue());
        setText(valuetoshow);
   String showImage= "Images/Icons/Airbus_A320.png";

        switch (extractFromAvionString(entry.getValue()," modele='")) {
    case "A320":
        showImage= "Images/Icons/Airbus_A320.png";
        
        break;
    case "A330":
        showImage="Images/Icons/Airbus_A330.png";
       
        break;
    case "B737":
        showImage="Images/Icons/Boeing_737.png";
      
        break;
    case "B747":
        showImage="Images/Icons/Boeing_747.png";
     
        break;
    default:
        // Default case if modele does not match any known cases
        System.out.println("Unknown modele.");
        break;
}
         Image image = new Image(showImage);
                            imageView.setImage(image);
                             imageView.setPreserveRatio(false);
                            imageView.setFitWidth(170);
                            imageView.setFitHeight(85);


        editButton.setOnAction(event -> handleEditButton(entry));
        deleteButton.setOnAction(event -> handleDeleteButton(entry));


        Region spacer = new Region();
        spacer.setMinWidth(10);

        VBox buttonsContainer = new VBox(negativeButton,editButton,negativeButton2, deleteButton);
        HBox vBox = new HBox(imageView,negativeButton3, buttonsContainer,negativeButton4);
        HBox.setHgrow(vBox, javafx.scene.layout.Priority.ALWAYS); // Make VBox expand horizontally

        setGraphic(vBox);
    }
}
    private void handleEditButton(Map.Entry<Integer, String> entry) {
                       System.out.println("edit button clicked for item: " + entry);
                      
                        try { 
                            Avion avionTo_modifer =  compte_ouvert.getList_Avions().get(extractFromAvionString(entry.getValue(),"reference='"));
                            System.out.println("afficahge avant le passage "+avionTo_modifer);
                            App.open_afficher_modifier_avion(avionTo_modifer);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
   }

               


                    private void handleDeleteButton(Map.Entry<Integer, String> entry) {
                        System.out.println("Delete button clicked for item: " + entry);
                        CRUD.deleteAvion(extractFromAvionString(entry.getValue(),"reference='"));
                        compte_ouvert.getList_Avions().remove(extractFromAvionString(entry.getValue(),"reference='")) ;
                        try { 
                            App.open_afficher_avion();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                };
            }
        });
    }
    

  
}
    

