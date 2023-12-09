/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import classes.ClientManager;
import classes.ReservationSimple;
import com.mycompany.cote_client.App;
import static controllers.Page_choix_PaysController.reservation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nezih
 */
public class ConsulterVolClientController implements Initializable {

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
    @FXML
    private ImageView imageTicket;
    @FXML
    private Text msg;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (ClientManager.getAuthenticatedClient().getMyReservation()!=null){
        Passager1.setText(ClientManager.getAuthenticatedClient().getNomClt()+" "+ClientManager.getAuthenticatedClient().getPrénomClt());
        Vol1.setText(ClientManager.getAuthenticatedClient().getMyReservation().getRefvol());
        Datevol.setText(ClientManager.getAuthenticatedClient().getMyReservation().getDate_aller().toString());
        Depart1.setText(ClientManager.getAuthenticatedClient().getMyReservation().getPays_depart());
        Destination1.setText(ClientManager.getAuthenticatedClient().getMyReservation().getPays_destination());
        Prix.setText( String.valueOf(ClientManager.getAuthenticatedClient().getMyReservation().getPrix()));
        Type.setText(((ReservationSimple) ClientManager.getAuthenticatedClient().getMyReservation()).getType());
        Passager2.setText(ClientManager.getAuthenticatedClient().getNomClt()+" "+ClientManager.getAuthenticatedClient().getPrénomClt());
        Vol2.setText(ClientManager.getAuthenticatedClient().getMyReservation().getRefvol());
        Depart2.setText(ClientManager.getAuthenticatedClient().getMyReservation().getPays_depart());
        Destination2.setText(ClientManager.getAuthenticatedClient().getMyReservation().getPays_destination());
        }
        else{
            imageTicket.setVisible(false);
            msg.setText("Vous n'avez pas de réservations!");
        }
    }    
    
    public void back() throws Exception{
    App.openMenuClient();
    }
}
