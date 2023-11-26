package Controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import Classes.Flight;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PageAfficherTousLesVolsController {

    @FXML
    private VBox vboxFlightsContainer;

    public void initialize() {
        List<Flight> flights = loadFlights(); // This should call your method to get the flights
        for (Flight flight : flights) {
            vboxFlightsContainer.getChildren().add(createFlightCard(flight));
        }
    }

    private Node createFlightCard(Flight flight) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/login/FlightCard.fxml"));
            Node card = loader.load();
            FlightCardController controller = loader.getController();
            controller.setFlight(flight);
            return card;
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception, log it, or show an error message
            return null;
        }
    }

    private List<Flight> loadFlights() {
    // Dummy data for flights
    List<Flight> flights = new ArrayList<>();
    flights.add(new Flight("AF1385", "Tunis", "Paris", LocalDateTime.of(2023, 6, 1, 5, 30), LocalDateTime.of(2023, 6, 1, 8, 10)));
    flights.add(new Flight("TO8859", "Tunis", "Paris", LocalDateTime.of(2023, 6, 1, 5, 50), LocalDateTime.of(2023, 6, 1, 8, 30)));
    flights.add(new Flight("BJ510", "Tunis", "Paris", LocalDateTime.of(2023, 6, 1, 8, 0), LocalDateTime.of(2023, 6, 1, 10, 35)));
    // Add more flights as needed
    return flights;
}

}
