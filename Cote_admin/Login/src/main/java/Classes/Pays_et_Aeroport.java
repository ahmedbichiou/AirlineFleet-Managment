/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.ArrayList;  // Import the ArrayList class
import java.util.Arrays;
import java.util.List;       // Import the List interface
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Spray
 */

public class Pays_et_Aeroport {
    public final  static  List<String> europe = new ArrayList<>();
 static{
europe.add("UK");
europe.add("France");
europe.add("Germany");
europe.add("Netherlands");
europe.add("Spain");

 }
public final static ObservableList<String> Europe = FXCollections.observableArrayList(europe);

 public final  static List<String> africa = new ArrayList<>();
 static{
africa.add("Tunisia");
africa.add("Egypt");
africa.add("South Africa");
africa.add("Ethiopia");
africa.add("Kenya");

 }
public final static ObservableList<String> Africa = FXCollections.observableArrayList(africa);  

 public final  static List<String> asia = new ArrayList<>();
  static{
asia.add("China");
asia.add("Japan");
asia.add("UAE");
asia.add("Singapore");
asia.add("South Korea");

  }
 public final static ObservableList<String> Asia = FXCollections.observableArrayList(asia);
 public final  static List<String> oceania = new ArrayList<>();
  static{
 oceania.add("Australia");




 }
  public final static ObservableList<String> Oceania = FXCollections.observableArrayList(oceania);
public final  static List<String> northAmerica= new ArrayList<>();
 static{
northAmerica.add("Atlanta, USA");
northAmerica.add("Los Angeles, USA");
northAmerica.add("New York, USA");
northAmerica.add("Toronto, Canada");
northAmerica.add("Vancouver, Canada");

 }
 public final static ObservableList<String> North_america = FXCollections.observableArrayList(northAmerica);
public final  static List<String> southAmerica = new ArrayList<>();
 static{
southAmerica.add("São Paulo, Brazil");
southAmerica.add("Bogotá, Colombia");
southAmerica.add("Buenos Aires, Argentina");
southAmerica.add("Santiago, Chile");
southAmerica.add("Lima, Peru");

 }
 public final static ObservableList<String> South_america = FXCollections.observableArrayList(southAmerica); 
 
     public static ObservableList<String> Regions = FXCollections.observableArrayList(
            "North America", "South America", "Oceania", "Asia", "Africa", "Europe"
    );
     
     
     // Adding airports for European countries
    public final static List<String> ukAirports = Arrays.asList("Heathrow Airport", "Gatwick Airport");
    public final static ObservableList<String> UK_Airports = FXCollections.observableArrayList(ukAirports);

    public final static List<String> franceAirports = Arrays.asList("Charles de Gaulle Airport", "Orly Airport");
    public final static ObservableList<String> France_Airports = FXCollections.observableArrayList(franceAirports);

    public final static List<String> germanyAirports = Arrays.asList("Frankfurt Airport", "Munich Airport");
    public final static ObservableList<String> Germany_Airports = FXCollections.observableArrayList(germanyAirports);

    public final static List<String> netherlandsAirports = Arrays.asList("Amsterdam Airport Schiphol", "Rotterdam The Hague Airport");
    public final static ObservableList<String> Netherlands_Airports = FXCollections.observableArrayList(netherlandsAirports);

    public final static List<String> spainAirports = Arrays.asList("Adolfo Suárez Madrid–Barajas Airport", "Barcelona–El Prat Airport");
    public final static ObservableList<String> Spain_Airports = FXCollections.observableArrayList(spainAirports);
    
    //Adding airports for African countries
    public final static List<String> tunisiaAirports = Arrays.asList("Tunis-Carthage Airport", "Enfidha-Hammamet International Airport");
    public final static ObservableList<String> Tunisia_Airports = FXCollections.observableArrayList(tunisiaAirports);

    public final static List<String> egyptAirports = Arrays.asList("Cairo International Airport", "Sharm El Sheikh International Airport");
    public final static ObservableList<String> Egypt_Airports = FXCollections.observableArrayList(egyptAirports);

    public final static List<String> southAfricaAirports = Arrays.asList("O.R. Tambo International Airport", "Cape Town International Airport");
    public final static ObservableList<String> SouthAfrica_Airports = FXCollections.observableArrayList(southAfricaAirports);

    public final static List<String> ethiopiaAirports = Arrays.asList("Addis Ababa Bole International Airport", "Dire Dawa International Airport");
    public final static ObservableList<String> Ethiopia_Airports = FXCollections.observableArrayList(ethiopiaAirports);

    public final static List<String> kenyaAirports = Arrays.asList("Jomo Kenyatta International Airport", "Moi International Airport");
    public final static ObservableList<String> Kenya_Airports = FXCollections.observableArrayList(kenyaAirports);
// Adding airports for Asian countries
    public final static List<String> chinaAirports = Arrays.asList("Beijing Capital International Airport", "Shanghai Pudong International Airport");
    public final static ObservableList<String> China_Airports = FXCollections.observableArrayList(chinaAirports);

    public final static List<String> japanAirports = Arrays.asList("Tokyo Haneda Airport", "Osaka Kansai International Airport");
    public final static ObservableList<String> Japan_Airports = FXCollections.observableArrayList(japanAirports);

    public final static List<String> uaeAirports = Arrays.asList("Dubai International Airport", "Abu Dhabi International Airport");
    public final static ObservableList<String> UAE_Airports = FXCollections.observableArrayList(uaeAirports);

    public final static List<String> singaporeAirports = Arrays.asList("Changi Airport");
    public final static ObservableList<String> Singapore_Airports = FXCollections.observableArrayList(singaporeAirports);

    public final static List<String> southKoreaAirports = Arrays.asList("Incheon International Airport", "Gimpo International Airport");
    public final static ObservableList<String> SouthKorea_Airports = FXCollections.observableArrayList(southKoreaAirports);
     // Adding airports for Oceania
    public final static List<String> australiaAirports = Arrays.asList("Sydney Airport", "Melbourne Airport");
    public final static ObservableList<String> Australia_Airports = FXCollections.observableArrayList(australiaAirports);

    // Adding airports for North American countries
    public final static List<String> usaAirports = Arrays.asList("Hartsfield-Jackson Atlanta International Airport", "Los Angeles International Airport");
    public final static ObservableList<String> USA_Airports = FXCollections.observableArrayList(usaAirports);

    public final static List<String> canadaAirports = Arrays.asList("Toronto Pearson International Airport", "Vancouver International Airport");
    public final static ObservableList<String> Canada_Airports = FXCollections.observableArrayList(canadaAirports);

    // Adding airports for South American countries
    public final static List<String> brazilAirports = Arrays.asList("São Paulo/Guarulhos–Governador André Franco Montoro International Airport", "Congonhas Airport");
    public final static ObservableList<String> Brazil_Airports = FXCollections.observableArrayList(brazilAirports);

    public final static List<String> colombiaAirports = Arrays.asList("El Dorado International Airport");
    public final static ObservableList<String> Colombia_Airports = FXCollections.observableArrayList(colombiaAirports);

}
