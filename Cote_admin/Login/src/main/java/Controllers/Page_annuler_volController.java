/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import com.mycompany.login.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jihed
 */
public class Page_annuler_volController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtFlightNumber;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML
    public void handleBack() throws Exception {
        App.handleBack();
    } 
    @FXML
    public void confirmCancellation(ActionEvent event) throws Exception {
        String flightNumber = txtFlightNumber.getText();
        System.out.println(flightNumber);
    } 
    
}
