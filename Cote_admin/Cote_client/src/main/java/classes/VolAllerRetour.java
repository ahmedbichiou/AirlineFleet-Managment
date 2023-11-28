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
public class VolAllerRetour extends VolSimple {
    private LocalDate dateRetour;

    public VolAllerRetour(LocalDate dateRetour, String paysDepart, String paysDest, String aeroportDep, String aeroportDest, LocalDate dateAller, String refVol) {
        super(paysDepart, paysDest, aeroportDep, aeroportDest, dateAller, refVol);
        this.dateRetour = dateRetour;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    @Override
    public String toString() {
        return super.toString() + ", dateRetour=" + dateRetour;
    }
    
}
