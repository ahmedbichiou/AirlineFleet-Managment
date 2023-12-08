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
import Classes.Compagnie_aerienne;
import Classes.Vol;
import Classes.VolAllerRetour;
import Classes.VolSimple;
import static Controllers.Page_LoginController.compte_ouvert;
import static OracleSGBD.OracleDBConnection.connection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
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
//-----------------------------------------------------------COMPAGNIES
public static void insertIntoDatabase(Compagnie_aerienne compagnie) {
    
        PreparedStatement preparedStatement = null;
     try (Connection connection = OracleDBConnection.getConnection();
             Statement statement = connection.createStatement()) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String sql = "INSERT INTO Compagnie_aerienne (nom, mot_pass, paysOrigine, anneeFondation) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, compagnie.getNom());
            preparedStatement.setString(2, compagnie.getmot_pass());
            preparedStatement.setString(3, compagnie.getPaysOrigine());
            preparedStatement.setInt(4, compagnie.getAnneeFondation());
            preparedStatement.executeUpdate();
            System.out.println("Data inserted successfully into the Compagnie_aerienne table.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


 public static void loadCompagniesFromDatabase(List<Compagnie_aerienne> compagniesList) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

 try (Connection connection = OracleDBConnection.getConnection();) {
 
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String sql = "SELECT * FROM Compagnie_aerienne";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String mot_pass = resultSet.getString("mot_pass");
                String paysOrigine = resultSet.getString("paysOrigine");
                int anneeFondation = resultSet.getInt("anneeFondation");
                Compagnie_aerienne compagnie = new Compagnie_aerienne(nom, mot_pass, paysOrigine, anneeFondation);
                compagniesList.add(compagnie);
            }
            System.out.println("Compagnies loaded successfully from the database.");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
 
 
 
 
 
 
    public static void insertVolIntoDatabase(Vol vol, String owner) {

        PreparedStatement preparedStatement = null;

    try (Connection connection = OracleDBConnection.getConnection();) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
       

            // Common SQL statement for both VolAllerRetour and VolSimple
            String sql = "INSERT INTO Vol (refVol, paysDepart, paysDest, aeroportDep, aeroportDest, dateAller, refAvion, prix, typeVol, dateRetour, owner) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(sql);

            // Set values based on the type of Vol
            preparedStatement.setString(1, vol.getRefVol());
            preparedStatement.setString(2, vol.getPaysDepart());
            preparedStatement.setString(3, vol.getPaysDest());
            preparedStatement.setString(4, vol.getAeroportDep());
            preparedStatement.setString(5, vol.getAeroportDest());
            preparedStatement.setDate(6, Date.valueOf(vol.getDateAller()));
            preparedStatement.setString(7, vol.getAvion().getReference());
            preparedStatement.setFloat(8, vol.getPrix());

            if (vol instanceof VolAllerRetour) {
                // Handle VolAllerRetour specific fields
                VolAllerRetour volAllerRetour = (VolAllerRetour) vol;
                preparedStatement.setString(9, "0");  // typeVol is set to "0"
                preparedStatement.setDate(10, Date.valueOf(volAllerRetour.getDateRetour()));
            } else if (vol instanceof VolSimple) {
                // Handle VolSimple specific fields
                VolSimple volSimple = (VolSimple) vol;
                preparedStatement.setString(9, volSimple.getTypeVol());
                preparedStatement.setNull(10, java.sql.Types.DATE);  // dateRetour is set to null
            }

            preparedStatement.setString(11, owner);  // Set the owner

            // Execute the insertion
            preparedStatement.executeUpdate();

            System.out.println("Vol inserted successfully into the Vol table.");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void retrieveDataFromDB(String owner, Map<String, Vol> list_vols) {
    
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

       try (Connection connection = OracleDBConnection.getConnection();) {
        Class.forName("oracle.jdbc.driver.OracleDriver");
       

        String selectQuery = "SELECT * FROM Vol WHERE owner = ?";
        preparedStatement = connection.prepareStatement(selectQuery);
        preparedStatement.setString(1, owner);

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

            Avion avion = compte_ouvert.getList_Avions().get(refAvion);

            if (dateRetour == null) {
                // Instance of VolSimple
                VolSimple volSimple = new VolSimple(refVol, paysDepart, paysDest, aeroportDep, aeroportDest,
                        dateAller, avion, prix, typeVol);

                list_vols.put(refVol, volSimple);
            } else {
                // Instance of VolAllerRetour
                VolAllerRetour volAllerRetour = new VolAllerRetour(refVol, paysDepart, paysDest, aeroportDep, aeroportDest,
                        dateAller, avion, prix, dateRetour);

                list_vols.put(refVol, volAllerRetour);
            }
        }

    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

   public static void deleteVol(String refVol) {
      
        PreparedStatement preparedStatement = null;

          try (Connection connection = OracleDBConnection.getConnection();) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
           

            String deleteQuery = "DELETE FROM Vol WHERE refVol = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, refVol);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Vol with refVol " + refVol + " deleted successfully.");
            } else {
                System.out.println("Vol with refVol " + refVol + " not found or not deleted.");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
 
   public static void updateDateAller(String refVol, LocalDate newDateAller) {
     
        PreparedStatement preparedStatement = null;

    try (Connection connection = OracleDBConnection.getConnection();) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
           

            String updateQuery = "UPDATE Vol SET dateAller = ? WHERE refVol = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setDate(1, Date.valueOf(newDateAller));
            preparedStatement.setString(2, refVol);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("DateAller for Vol with refVol " + refVol + " updated successfully.");
            } else {
                System.out.println("Vol with refVol " + refVol + " not found or not updated.");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
