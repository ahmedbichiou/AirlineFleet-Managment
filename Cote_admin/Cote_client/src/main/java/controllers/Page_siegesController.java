/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import OracleSGBD.CRUD;
import classes.Client;
import classes.ClientManager;
import classes.Reservation;
import classes.Client;
import classes.ClientManager;
import classes.ReservationSimple;
import com.mycompany.cote_client.App;
import static controllers.Page_choix_PaysController.reservation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Spray
 */
public class Page_siegesController implements Initializable {

    @FXML
    private AnchorPane backg;
    @FXML
    private Text Passager1;
    @FXML
    private Text Vol1;
    @FXML
    private Text Datevol;
    @FXML
    private Text Depart1;
    @FXML
    private Text Destination1;
    @FXML
    private Text Prix;
    @FXML
    private Text Type;
    @FXML
    private Text Passager2;
    @FXML
    private Text Vol2;
    @FXML
    private Text Depart2;
    @FXML
    private Text Destination2;
    
    public  static Stage myStage;
    
    public  static  void setStage(Stage s)
    {
        myStage = s;
    }
    
    
          
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(reservation);
        // added NEW COPY TO NEXT IN GITHUB
        CRUD.insertReservation(reservation);
       Client authenticatedClient = ClientManager.getAuthenticatedClient();
       authenticatedClient.setMyReservation(reservation);
       CRUD.updateClientReservation(authenticatedClient.getEmail(), reservation.getRefvol());
        // added NEW COPY TO NEXT IN GITHUB
        Passager1.setText(ClientManager.getAuthenticatedClient().getNomClt()+" "+ClientManager.getAuthenticatedClient().getPrénomClt());
        Vol1.setText(reservation.getRefvol());
        Datevol.setText(reservation.getDate_aller().toString());
        Depart1.setText(reservation.getPays_depart());
        Destination1.setText(reservation.getPays_destination());
        Prix.setText( String.valueOf(reservation.getPrix()));
        Type.setText(((ReservationSimple) reservation).getType());
        Passager2.setText(ClientManager.getAuthenticatedClient().getNomClt()+" "+ClientManager.getAuthenticatedClient().getPrénomClt());
        Vol2.setText(reservation.getRefvol());
        Depart2.setText(reservation.getPays_depart());
        Destination2.setText(reservation.getPays_destination());
    }    
     public void etape_1() throws Exception{
     myStage.close();
    App.openEtape1();
    }
     public void etape_2() throws Exception{
     myStage.close();
    App.openEtape2();
    }
     public void etape_3() throws Exception{
          myStage.close();
         App.openEtape3();
     }
     public void etape_4() throws Exception{
          myStage.close();
         App.openEtape4();
     }
     
     public void confirmerReservation() throws Exception{
        
         //App.openMenuClient();
          myStage.close();
         App.openPageMenu();
        
         
     }
     
     public void annulerReservation() throws Exception{
         App.openPage_choix_Pays();
     }
}
