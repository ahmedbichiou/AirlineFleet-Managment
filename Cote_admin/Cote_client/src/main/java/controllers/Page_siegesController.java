/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import OracleSGBD.CRUD;
import classes.Client;
import classes.ClientManager;
import classes.Reservation;
import com.mycompany.cote_client.App;
import static controllers.Page_choix_PaysController.reservation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Spray
 */
public class Page_siegesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(reservation);
        // added NEW COPY TO NEXT IN GITHUB
        CRUD.insertReservation(reservation);
       Client authenticatedClient = ClientManager.getAuthenticatedClient();
       authenticatedClient.setMyReservation(reservation);
       CRUD.updateClientReservation(authenticatedClient.getEmail(), reservation.getRefvol());
        // added NEW COPY TO NEXT IN GITHUB
    }    
     public void etape_1() throws Exception{
    
    App.openClientReservation();
    }
     public void etape_2() throws Exception{
    
    App.openPageSelectionRegionDestination();
    }
     public void etape_3() throws Exception{
         App.openPage_choix_Pays();
     }
     public void etape_4() throws Exception{
         App.openPage_voir_offres();
     }
}
