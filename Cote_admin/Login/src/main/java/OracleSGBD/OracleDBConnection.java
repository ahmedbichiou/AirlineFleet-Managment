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
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDBConnection {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "PROJETJAVA";
    private static final String PASSWORD = "123456";
    public static Connection connection;

    

    public static Connection getConnection() {
     
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the Oracle database.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

