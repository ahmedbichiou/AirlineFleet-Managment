/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.time.LocalDate;

/**
 *
 * @author Spray
 */
public class ReservationSimple extends Reservation {
      private String type;
       public ReservationSimple(String pays_depart, String pays_destination, LocalDate date_aller) {
        super(pays_depart, pays_destination, date_aller);
       
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


     @Override
    public String toString() {
        return "ReservationSimple{" +
                "Pays_depart='" + Pays_depart + '\'' +
                ", Pays_destination='" + Pays_destination + '\'' +
                ", date_aller=" + date_aller +
                ", refavion='" + refavion + '\'' +
                ", refvol='" + refvol + '\'' +
                ", prix='" + prix +'\'' +
                ", type=" + type + '}'+ '\'' +
                '}';
    }
       
}
