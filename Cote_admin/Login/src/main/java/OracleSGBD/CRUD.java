/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OracleSGBD;

/**
 *
 * @author Spray
 */

import Classes.Avion;
import Classes.AvionGrandeTaille;
import Classes.AvionPetitTaille;
import static OracleSGBD.OracleDBConnection.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class CRUD {
    
    
  
        
                
        

public static void createAvion(Avion avion, String owner) {
    try (Connection connection = OracleDBConnection.getConnection();
         Statement statement = connection.createStatement()) {
        if (avion instanceof AvionGrandeTaille) {
            AvionGrandeTaille avionGrandeTaille = (AvionGrandeTaille) avion;
            String insertQuery = "INSERT INTO Avion " +
                    "(reference, modele, compagnieFabricante, portee, capacite, capacite_cargo_kg, owner,siege_1ereclass) " +
                    "VALUES ('" + avion.getReference() + "', '" + avion.getModele() + "', '" +
                    avion.getCompagnieFabricante() + "', " + avion.getPortee() + ", " +
                    avion.getCapacite() + ", " + avionGrandeTaille.getCapacite_cargo_kg() + ", '" + owner +"' ,"+ 0 + ")";
            statement.execute(insertQuery);
        } else if (avion instanceof AvionPetitTaille) {
            AvionPetitTaille avionPetitTaille = (AvionPetitTaille) avion;
            String insertQuery = "INSERT INTO Avion " +
                    "(reference, modele, compagnieFabricante, portee, capacite, siege_1ereclass, owner, capacite_cargo_kg) " +
                    "VALUES ('" + avion.getReference() + "', '" + avion.getModele() + "', '" +
                    avion.getCompagnieFabricante() + "', " + avion.getPortee() + ", " +
                    avion.getCapacite() + ", " + avionPetitTaille.getSiege_1ereclass() + ", '" + owner + "' ,"+ 0 +  ")";
            statement.execute(insertQuery);
        }
    } catch (SQLException e) {
        System.out.println(e);
    } finally {
        OracleDBConnection.closeConnection();
    }
}

public static void retrieveAvionsFromDatabase(Map<String,Avion> list_Avions,String nom) {
       

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
                if(owner.equals(nom))
                {
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
              

                
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            OracleDBConnection.closeConnection();
        }
    }

public static void deleteAvion(String reference) {
    try (Connection connection = OracleDBConnection.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Avion WHERE reference = ?")) {

        // Set the parameter for the prepared statement
        preparedStatement.setString(1, reference);

        // Execute the query
        preparedStatement.executeUpdate();

    } catch (SQLException e) {
        System.out.println(e);
    } finally {
        OracleDBConnection.closeConnection();
    }
}

public static void updateReference(String oldReference, String newReference) {
    try (Connection connection = OracleDBConnection.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Avion SET reference = ? WHERE reference = ?")) {

        // Set the parameters for the prepared statement
        preparedStatement.setString(1, newReference);
        preparedStatement.setString(2, oldReference);

        // Execute the query
        preparedStatement.executeUpdate();

    } catch (SQLException e) {
        System.out.println(e);
    } finally {
        OracleDBConnection.closeConnection();
    }
}

/*


    public static void updateAvion(Avion avion) {
        // Implement the UPDATE query
        // Example: UPDATE Avion SET modele = ?, compagnieFabricante = ?, portee = ?, capacite = ? WHERE reference = ?
        String updateQuery = "UPDATE Avion SET modele = ?, compagnieFabricante = ?, portee = ?, capacite = ? WHERE reference = ?";
        executeUpdate(updateQuery, avion.getModele(), avion.getCompagnieFabricante(),
                      avion.getPortee(), avion.getCapacite(), avion.getReference());
    }

   

*/
}
