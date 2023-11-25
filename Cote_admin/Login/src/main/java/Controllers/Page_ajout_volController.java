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
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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
    private TextField txtFlightNumber;
    
    @FXML
    private TextField txtDepartureCity;
    
    @FXML
    private TextField txtArrivalCity;
    
    @FXML
    private DatePicker datePickerDeparture;
    
    @FXML
    private DatePicker datePickerArrival;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void addFlight(ActionEvent event) {
        // Implement your logic to add a flight here
        // For example, validate the input and then add the flight to the database
    }
    @FXML
    public void handleBack() throws Exception {
        App.handleBack();
        
        
    }
}
