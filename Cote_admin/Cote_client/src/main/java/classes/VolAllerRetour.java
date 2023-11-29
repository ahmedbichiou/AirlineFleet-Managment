/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author nezih
 */
public class VolAllerRetour extends Vol {
    private LocalDate dateRetour;

    // Constructor
    public VolAllerRetour(String refVol, String paysDepart, String paysDest, String aeroportDep, String aeroportDest,
                          LocalDate dateAller, Avion avion, float prix, LocalDate dateRetour) {
        super(refVol, paysDepart, paysDest, aeroportDep, aeroportDest, dateAller, avion, prix);
        this.dateRetour = dateRetour;
    }

    // Getter and setter for dateRetour
    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }

    // Additional methods as needed...
@Override
    public String toString() {
        return "VolAller/Retour{" +
                "refVol='" + refVol + '\'' +
                ", paysDepart='" + paysDepart + '\'' +
                ", paysDest='" + paysDest + '\'' +
                ", aeroportDep='" + aeroportDep + '\'' +
                ", aeroportDest='" + aeroportDest + '\'' +
                ", dateAller='" + dateAller + '\'' +
                ", dateRetour='" + dateRetour + '\'' + 
                ", ref avion='" + avion.getReference() + '\'' +
                ", prix='" + prix + '\'' +
                '}';
    }
}
    

