package Controllers;

import com.mycompany.login.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;

public class Page_modifier_volController implements Initializable {

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
    
    @FXML
    private ComboBox<String> comboBoxPlaneType;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialization logic here
        comboBoxPlaneType.getItems().addAll("Airbus A330", "Boeing 737", "Airbus A320", "Boeing 747");
    }

    @FXML
    private void handleSaveChanges(ActionEvent event) {
        // Logic to save the modifications of the flight
    }
    @FXML
    private void handleBack(ActionEvent event) throws Exception {
        // Logic to save the modifications of the flight
        App.handleBack();
    }
}
