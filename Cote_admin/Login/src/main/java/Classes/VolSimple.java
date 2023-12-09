/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author nezih
 */
public class VolSimple extends Vol {
    private String typeVol;

    // Constructor
    
    
    
    public VolSimple(String refVol, String paysDepart, String paysDest, String aeroportDep, String aeroportDest,
                     LocalDate dateAller, Avion avion, float prix, String typeVol) {
        super(refVol, paysDepart, paysDest, aeroportDep, aeroportDest, dateAller, avion, prix);
        this.typeVol = typeVol;
    }

    // Getter and setter for typeVol
    public String getTypeVol() {
        return typeVol;
    }

    public void setTypeVol(String typeVol) {
        this.typeVol = typeVol;
    }

    // Additional methods as needed...

    // toString method
 @Override
    public String toString() {
        return "Vol Simple{" +
                "refVol='" + refVol + '\'' +
                ", paysDepart='" + paysDepart + '\'' +
                ", paysDest='" + paysDest + '\'' +
                ", aeroportDep='" + aeroportDep + '\'' +
                ", aeroportDest='" + aeroportDest + '\'' +
                ", dateAller='" + dateAller + '\'' +
                ", typeVol='" + typeVol + '\'' +
                ", ref avion='" + avion.getReference() + '\'' +
                ", prix='" + prix + '\'' +
                '}';
    }
}