/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 *
 * @author nezih
 */
public class ClientManager {
 private static Map<String, Client> clientsByEmail = new HashMap<>();
 private static Client authenticatedClient;

    public static Map<String, Client> getClientsByEmail() {
        return clientsByEmail;
    }

    public static void setClientsByEmail(Map<String, Client> clientsByEmail) {
        ClientManager.clientsByEmail = clientsByEmail;
    }
 
    static {
        clientsByEmail.put("mohammed@gmail.com", new Client("mohammed", "karim", LocalDate.of(1990, 5, 15), "mohammed@gmail.com", "1911300401"));
        clientsByEmail.put("0123", new Client("yassine", "lamouchi", LocalDate.of(2001, 4, 30), "lamouchiYassine@gmail.com", "0123"));
    }
    
    public static String addClient(Client client) {
        if (clientsByEmail.containsKey(client.getEmail())) {
            return "Client with email " + client.getEmail() + " already exists.";
        } else if (!isEmailValid(client.getEmail())) {
            return "Invalid email format.";
        } else if (calculateAge(client.getDateNaiss()) < 18) {
            return "You must be 18 years old or older! ";
        } else {
            clientsByEmail.put(client.getEmail(), client);
        }
        return "";
    }
    
     public static Client getClientByEmail(String email) {
        return clientsByEmail.get(email);
    }
     
      public static Client getAuthenticatedClient() {
        return authenticatedClient;
    }

    public static void setAuthenticatedClient(Client authenticatedClient) {
        ClientManager.authenticatedClient = authenticatedClient;
    }
     
    private static boolean isEmailValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
    
    private static int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }


}
