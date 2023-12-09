/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import classes.Client;
import classes.ClientManager;
import com.mycompany.cote_client.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author nezih
 */
public class MenuPrincipalClientController implements Initializable {

    @FXML
    private Text nomClt;
    @FXML
    private Button button_reserver;
    @FXML
    private Button button_consulter;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        styleclasses();
        Client authenticatedClient = ClientManager.getAuthenticatedClient();
        if (authenticatedClient != null) {
            nomClt.setText("Bonjour, " + authenticatedClient.getNomClt()+" !");
            System.out.println( authenticatedClient.getMyReservation());
        }
        
    } 
    
    public void openClientReservation() throws Exception {
        App.openClientReservation();
    }
    
    public void openClientConsulterVol() throws Exception {
        App.openPageConsulter();
    }
    
    public void back() throws Exception{
    App.openPageLoginClient();
    }
    
    private void styleclasses()
    {
            button_reserver.getStyleClass().add("buttton_choix");
            nomClt.getStyleClass().add("bonj_client");
    }
    
}
