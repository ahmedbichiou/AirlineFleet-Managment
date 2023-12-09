package Controllers;


import Classes.Vol;
import Classes.VolAllerRetour;
import Classes.VolSimple;
import static Controllers.Page_LoginController.compte_ouvert;
import OracleSGBD.CRUD;
import com.mycompany.login.App;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PageAfficherTousLesVolsController implements Initializable{



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
    
  
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
     Map<Integer, String> exampleHashMap = new HashMap<>();
int key = 0;
  Collection<Vol> volCollection = compte_ouvert.getList_vols().values();
    Vol[] volArray = volCollection.toArray(new Vol[0]);
for (Vol vol : volArray) {
    
        if(vol instanceof VolAllerRetour)
        {
            
            
                    
                exampleHashMap.put(key, vol.toString());
                key++; 
                
        }
    

    else{
        if(vol instanceof VolSimple)
        {
            
           
                    System.out.println("Value: " + vol);
                exampleHashMap.put(key, vol.toString());
                key++; 
                
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
                    private final Button editButton = new Button("Editer ");
                    private final Button deleteButton = new Button("Delete");
                    
                    private final Button negativeButton = new Button("negative");   
                    private final Button negativeButton2 = new Button("negative");  
                    private final Button negativeButton3 = new Button("negative");  
                    private final Button negativeButton4 = new Button("negative");
   @Override
protected void updateItem(Map.Entry<Integer, String> entry, boolean empty) {
    super.updateItem(entry, empty);
    
negativeButton.getStyleClass().add("image-button2");
negativeButton2.getStyleClass().add("image-button2");
negativeButton3.getStyleClass().add("image-button2");
negativeButton4.getStyleClass().add("image-button2");
 editButton.getStyleClass().add("btn_login");
 deleteButton.getStyleClass().add("btn_login2");

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
   String showImage= "Images/Airlines/default2.png";


   
        

         Image image = new Image(showImage);
                            imageView.setImage(image);
                             imageView.setPreserveRatio(false);
                            imageView.setFitWidth(110);
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
                            Vol volTo_modifier =  compte_ouvert.getList_vols().get(extractFromVolString(entry.getValue(),"refVol='"));
                            System.out.println("afficahge avant le passage "+volTo_modifier);
                            App.open_modifier_vol(volTo_modifier);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }                
   }

               


                    private void handleDeleteButton(Map.Entry<Integer, String> entry) {
                      System.out.println("Delete button clicked for item: " + entry);
             
                        compte_ouvert.getList_vols().remove(extractFromVolString(entry.getValue(),"refVol='")) ;
                        CRUD.deleteVol(extractFromVolString(entry.getValue(),"refVol='"));
                        try { 
                            App.open_Affichage_vols();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        } 
                    }

               


   
                };
            }
        }); 

    }
        public void openmenu_principal_admin() throws Exception
      {
          App.openmenu_principal_admin();
      }
        
   }