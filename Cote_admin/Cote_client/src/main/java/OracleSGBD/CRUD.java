/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OracleSGBD;

/**
 *
 * @author Spray
 */


import static OracleSGBD.OracleDBConnection.connection;
import classes.Avion;
import classes.AvionGrandeTaille;
import classes.AvionPetitTaille;
import classes.Client;
import classes.Reservation;
import classes.ReservationSimple;
import classes.ReservationVolAllerRetour;
import classes.Vol;
import classes.VolAllerRetour;
import classes.VolSimple;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CRUD {
    
    
  
        
                
  public static void retrieveAvionsFromDatabase(Map<String,Avion> list_Avions) {
       

        try (Connection connection = OracleDBConnection.getConnection();
             Statement statement = connection.createStatement()) {

            String selectQuery = "SELECT * FROM Avion";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                String reference = resultSet.getString("reference");
                String modele = resultSet.getString("modele");
                String compagnieFabricante = resultSet.getString("compagnieFabricante");
                int portee = resultSet.getInt("portee");
                int capacite = resultSet.getInt("capacite");
                int siege_1ereclass = resultSet.getInt("siege_1ereclass");
                double capacite_cargo_kg = resultSet.getDouble("capacite_cargo_kg");
                String owner = resultSet.getString("owner");

                // Check if it's AvionGrandeTaille or AvionPetitTaille based on columns
               
                      Avion avion;
                if (capacite_cargo_kg == 0) {
                    
                    avion = new AvionPetitTaille(modele, compagnieFabricante, reference, portee, capacite, siege_1ereclass);
                } else if (siege_1ereclass == 0 ) {
                   
                    avion = new AvionGrandeTaille(modele, compagnieFabricante, reference, portee, capacite, capacite_cargo_kg);
                } else {
                    // Handle other cases if needed
                    avion = null; // Replace with appropriate handling
                }
                list_Avions.put(reference, avion);
                
              

                
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            OracleDBConnection.closeConnection();
        }
    }      








//-----------------------------------------------------------VOL

 
 
 
    
   public static void retrieveDataFromDB(List<Vol> volList) {
        Map<String, Avion> list_Avions = new HashMap<>();
        retrieveAvionsFromDatabase(list_Avions);

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try (Connection connection = OracleDBConnection.getConnection()) {
            String selectQuery = "SELECT * FROM Vol";
            preparedStatement = connection.prepareStatement(selectQuery);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String refVol = resultSet.getString("refVol");
                String paysDepart = resultSet.getString("paysDepart");
                String paysDest = resultSet.getString("paysDest");
                String aeroportDep = resultSet.getString("aeroportDep");
                String aeroportDest = resultSet.getString("aeroportDest");
                LocalDate dateAller = resultSet.getDate("dateAller").toLocalDate();
                String refAvion = resultSet.getString("refAvion");
                float prix = resultSet.getFloat("prix");
                String typeVol = resultSet.getString("typeVol");
                LocalDate dateRetour = resultSet.getDate("dateRetour") != null ?
                        resultSet.getDate("dateRetour").toLocalDate() : null;

                Avion avion = list_Avions.get(refAvion);

                if (dateRetour == null) {
                    // Instance of VolSimple
                    VolSimple volSimple = new VolSimple(refVol, paysDepart, paysDest, aeroportDep, aeroportDest,
                            dateAller, avion, prix, typeVol);

                    volList.add(volSimple);
                 
                } else {
                    // Instance of VolAllerRetour
                    VolAllerRetour volAllerRetour = new VolAllerRetour(refVol, paysDepart, paysDest, aeroportDep, aeroportDest,
                            dateAller, avion, prix, dateRetour);

                    volList.add(volAllerRetour);
                
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


 //---------------------------------------------------------Clients  
    public static void insertClient(Client client) {
    try (Connection connection = OracleDBConnection.getConnection()) {
        String insertQuery = "INSERT INTO Client (nomClt, prénomClt, dateNaiss, email, mdp, myReservation) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, client.getNomClt());
            preparedStatement.setString(2, client.getPrénomClt());
            preparedStatement.setDate(3, Date.valueOf(client.getDateNaiss()));
            preparedStatement.setString(4, client.getEmail());
            preparedStatement.setString(5, client.getMdp());
            preparedStatement.setNull(6, java.sql.Types.VARCHAR);  // Assuming myReservation is a VARCHAR

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Client inserted successfully.");
            } else {
                System.out.println("Failed to insert client.");
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    
    public static void retrieveClientsFromDB(Map<String, Client> clientsByEmail) {
    try (Connection connection = OracleDBConnection.getConnection()) {
        String selectQuery = "SELECT * FROM Client";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String nomClt = resultSet.getString("nomClt");
                String prénomClt = resultSet.getString("prénomClt");
                LocalDate dateNaiss = resultSet.getDate("dateNaiss").toLocalDate();
                String email = resultSet.getString("email");
                String mdp = resultSet.getString("mdp");
                String myReservationRef = resultSet.getString("myReservation"); // Update if needed

                Client client = new Client(nomClt, prénomClt, dateNaiss, email, mdp);

                // Retrieve reservation for the client
                Reservation reservation = readReservationFromDB(myReservationRef);
                client.setMyReservation(reservation);

                clientsByEmail.put(email, client);
            }

            System.out.println("Clients retrieved from the database and inserted into the map.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

     
    public static void updateClientReservation(String clientEmail, String newReservation) {
        try (Connection connection = OracleDBConnection.getConnection()) {
            String updateQuery = "UPDATE Client SET myReservation = ? WHERE email = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, newReservation);
                preparedStatement.setString(2, clientEmail);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Client reservation updated successfully.");
                } else {
                    System.out.println("Failed to update client reservation.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
     
     
     
    //---------------------------------------------------Reservation  
     
public static void insertReservation(Reservation reservation) {
        try (Connection connection = OracleDBConnection.getConnection()) {
            String insertQuery = "INSERT INTO Reservation (Pays_depart, Pays_destination, date_aller, refavion, refvol, prix, type, date_retour) " +
                                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, reservation.getPays_depart());
                preparedStatement.setString(2, reservation.getPays_destination());
                preparedStatement.setDate(3, java.sql.Date.valueOf(reservation.getDate_aller()));
                preparedStatement.setString(4, reservation.getRefavion());
                preparedStatement.setString(5, reservation.getRefvol());
                preparedStatement.setFloat(6, reservation.getPrix());

                if (reservation instanceof ReservationVolAllerRetour) {
                    ReservationVolAllerRetour reservationVolAllerRetour = (ReservationVolAllerRetour) reservation;
                    preparedStatement.setString(7, "0"); // Type for ReservationVolAllerRetour
                    preparedStatement.setDate(8, java.sql.Date.valueOf(reservationVolAllerRetour.getDate_retour()));
                } else if (reservation instanceof ReservationSimple) {
                    preparedStatement.setString(7, ((ReservationSimple) reservation).getType()); // Type for ReservationVolAllerRetour
                    preparedStatement.setNull(8, java.sql.Types.DATE); // Null for ReservationSimple date_retour
                }

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Reservation inserted successfully.");
                } else {
                    System.out.println("Failed to insert reservation.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public  static Reservation readReservationFromDB(String refVol) {
    try (Connection connection = OracleDBConnection.getConnection()) {
        String selectQuery = "SELECT * FROM Reservation WHERE refvol = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, refVol);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String paysDepart = resultSet.getString("Pays_depart");
                    String paysDestination = resultSet.getString("Pays_destination");
                    LocalDate dateAller = resultSet.getDate("date_aller").toLocalDate();
                    String refAvion = resultSet.getString("refavion");
                    float prix = resultSet.getFloat("prix");
                    String type = resultSet.getString("type");
                    LocalDate dateRetour = resultSet.getDate("date_retour") != null ?
                            resultSet.getDate("date_retour").toLocalDate() : null;

                    if (type.equals("0")) {
                        // ReservationVolAllerRetour
                        ReservationVolAllerRetour reservation = new ReservationVolAllerRetour(paysDepart, paysDestination, dateAller, dateRetour);
                        reservation.setRefavion(refAvion);
                        reservation.setRefvol(refVol);
                        reservation.setPrix(prix);
                        return reservation;
                    } else {
                        // ReservationSimple
                        ReservationSimple reservation = new ReservationSimple(paysDepart, paysDestination, dateAller);
                        reservation.setRefavion(refAvion);
                        reservation.setRefvol(refVol);
                        reservation.setPrix(prix);
                        reservation.setType(type);
                        // Set other missing items using setters if needed
                        return reservation;
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null; // Return null if no reservation is found for the given refVol
}

}
