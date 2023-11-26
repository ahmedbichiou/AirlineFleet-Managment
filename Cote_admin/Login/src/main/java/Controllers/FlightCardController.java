package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import Classes.Flight;

public class FlightCardController {

    @FXML
    private Label labelFlightNumber;
    @FXML
    private Label labelDepartureArrival;
    @FXML
    private Label labelTimeDuration;

    private Flight flight;

    public void initialize() {
        // Initialization if necessary
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
        updateFlightDetails();
    }

    private void updateFlightDetails() {
        labelFlightNumber.setText(flight.getFlightNumber());
        labelDepartureArrival.setText(flight.getDepartureCity() + " - " + flight.getArrivalCity());
        labelTimeDuration.setText(flight.getDepartureTime() + " - " + flight.getArrivalTime());
    }

    @FXML
    private void handleEditAction() {
        // Handle edit action
    }

    @FXML
    private void handleDeleteAction() {
        // Handle delete action
    }
}
