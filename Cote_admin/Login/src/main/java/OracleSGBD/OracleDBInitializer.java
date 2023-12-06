/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OracleSGBD;

/**
 *
 * @author Spray
 */

/*
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
                    "capacite NUMBER" +
                    ")");

            // Create Vol table
            statement.execute("CREATE TABLE Vol (" +
                    "refVol VARCHAR2(50) PRIMARY KEY," +
                    "paysDepart VARCHAR2(50)," +
                    "paysDest VARCHAR2(50)," +
                    "aeroportDep VARCHAR2(50)," +
                    "aeroportDest VARCHAR2(50)," +
                    "dateAller DATE," +
                    "refAvion VARCHAR2(50) REFERENCES Avion(reference)," +
                    "prix NUMBER" +
                    ")");

            // Create VolSimple table
            statement.execute("CREATE TABLE VolSimple (" +
                    "refVol VARCHAR2(50) PRIMARY KEY REFERENCES Vol(refVol)," +
                    "typeVol VARCHAR2(50)" +
                    ")");

            // Create VolAllerRetour table
            statement.execute("CREATE TABLE VolAllerRetour (" +
                    "refVol VARCHAR2(50) PRIMARY KEY REFERENCES Vol(refVol)," +
                    "dateRetour DATE" +
                    ")");

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
*/