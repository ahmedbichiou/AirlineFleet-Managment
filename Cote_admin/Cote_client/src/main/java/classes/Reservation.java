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
public abstract class Reservation {
    protected  String Pays_depart;
   protected  String Pays_destination;
   protected LocalDate date_aller;
   protected String refavion;
   protected String refvol;
      protected float prix;


    public String getRefavion() {
        return refavion;
    }

    public void setRefavion(String refavion) {
        this.refavion = refavion;
    }

    public String getRefvol() {
        return refvol;
    }

    public void setRefvol(String refvol) {
        this.refvol = refvol;
    }
  
      public Reservation(String pays_depart, String pays_destination, LocalDate date_aller) {
        this.Pays_depart = pays_depart;
        this.Pays_destination = pays_destination;
        this.date_aller = date_aller;
    }

    public String getPays_depart() {
        return Pays_depart;
    }

    public void setPays_depart(String Pays_depart) {
        this.Pays_depart = Pays_depart;
    }

    public String getPays_destination() {
        return Pays_destination;
    }

    public void setPays_destination(String Pays_destination) {
        this.Pays_destination = Pays_destination;
    }

    public LocalDate getDate_aller() {
        return date_aller;
    }

    public void setDate_aller(LocalDate date_aller) {
        this.date_aller = date_aller;
    }

    public String getrefAvion() {
        return refavion;
    }

    public void setrefAvion(String avion) {
        this.refavion = avion;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

  

    @Override
    public String toString() {
        return "Reservation{" +
                "Pays_depart='" + Pays_depart + '\'' +
                ", Pays_destination='" + Pays_destination + '\'' +
                ", date_aller=" + date_aller +
                ", refavion='" + refavion + '\'' +
                ", refvol='" + refvol + '\'' +
                ", prix='" + prix +'\'' +
                '}';}
}
