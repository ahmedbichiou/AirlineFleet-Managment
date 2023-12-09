/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OracleSGBD;

/**
 *
 * @author Spray
 */


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleDBInitializer {

    public static void createTables() {
        try (Connection connection = OracleDBConnection.getConnection();
             Statement statement = connection.createStatement()) {

            // Create Avion table
            statement.execute("CREATE TABLE Avion (" +
                  "reference VARCHAR2(50) PRIMARY KEY," +
                  "modele VARCHAR2(50)," +
                  "compagnieFabricante VARCHAR2(50)," +
                  "portee NUMBER," +
                  "capacite NUMBER," +
                  "siege_1ereclass NUMBER," +
                  "capacite_cargo_kg NUMBER," +
                  "owner VARCHAR2(50)" +
                  ")");

String createTableQuery = "CREATE TABLE Vol (" +
                    "refVol VARCHAR2(200) PRIMARY KEY," +
                    "paysDepart VARCHAR2(200)," +
                    "paysDest VARCHAR2(200)," +
                    "aeroportDep VARCHAR2(200)," +
                    "aeroportDest VARCHAR2(200)," +
                    "dateAller DATE," +
                    "refAvion VARCHAR2(200)," +
                    "prix NUMBER," +
                    "typeVol VARCHAR2(200)," +
                    "dateRetour DATE," +
                    "owner VARCHAR2(200)" +
                    ")";

            // Execute the query
            statement.execute(createTableQuery);
            
 String createTableQuery2 = "CREATE TABLE Client (" +
        "nomClt VARCHAR2(50)," +
        "prénomClt VARCHAR2(50)," +
        "dateNaiss DATE," +
        "email VARCHAR2(100) PRIMARY KEY," +
        "mdp VARCHAR2(50)," +
        "myReservation VARCHAR2(255)" +  // Adjust the size accordingly
        ")";

statement.execute(createTableQuery2);

 String createTableQuery3 = "CREATE TABLE Reservation (" +
                    "Pays_depart VARCHAR2(50)," +
                    "Pays_destination VARCHAR2(50)," +
                    "date_aller DATE," +
                    "refavion VARCHAR2(50)," +
                    "refvol VARCHAR2(50)," +
                    "prix NUMBER," +
                    "type VARCHAR2(50)," +
                    "date_retour DATE" +
                    ")";

            statement.execute(createTableQuery3);

            // Create Compagnie_aerienne table
            statement.execute("CREATE TABLE Compagnie_aerienne (" +
                    "nom VARCHAR2(50) PRIMARY KEY," +
                    "mot_pass VARCHAR2(50)," +
                    "paysOrigine VARCHAR2(50)," +
                    "anneeFondation NUMBER" +
                    ")");

            System.out.println("Tables created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createTables();
        OracleDBConnection.closeConnection();
    }
}
