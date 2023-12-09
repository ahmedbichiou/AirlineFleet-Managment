/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.time.LocalDate;

/**
 *
 * @author nezih
 */

public class ReservationVolAllerRetour extends Reservation {
    private LocalDate date_retour;
       public ReservationVolAllerRetour(String pays_depart, String pays_destination, LocalDate date_aller, LocalDate date_retour) {
        super(pays_depart, pays_destination, date_aller);
        this.date_retour = date_retour;
    }

    public LocalDate getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(LocalDate date_retour) {
        this.date_retour = date_retour;
    }

    @Override
    public String toString() {
        return "Reservation aller-retour{" +
                "Pays_depart='" + Pays_depart + '\'' +
                ", Pays_destination='" + Pays_destination + '\'' +
                ", date_aller=" + date_aller +
                ", refavion='" + refavion + '\'' +
                ", refvol='" + refvol + '\'' +
                ", prix='" + prix +'\'' +
                ", date_retour=" + date_retour + '\'' +
                '}';
    }
       
}
