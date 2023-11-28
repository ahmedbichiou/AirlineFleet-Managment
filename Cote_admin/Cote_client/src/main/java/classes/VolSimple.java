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
public class VolSimple {
    private String paysDepart;
    private String paysDest;
    private String aeroportDep;
    private String aeroportDest;
    private LocalDate dateAller;
    private String refVol;

    public VolSimple(String paysDepart, String paysDest, String aeroportDep, String aeroportDest, LocalDate dateAller, String refVol) {
        this.paysDepart = paysDepart;
        this.paysDest = paysDest;
        this.aeroportDep = aeroportDep;
        this.aeroportDest = aeroportDest;
        this.dateAller = dateAller;
        this.refVol = refVol;
    }

    public String getPaysDepart() {
        return paysDepart;
    }

    public String getPaysDest() {
        return paysDest;
    }

    public String getAeroportDep() {
        return aeroportDep;
    }

    public String getAeroportDest() {
        return aeroportDest;
    }

    public LocalDate getDateAller() {
        return dateAller;
    }

    public String getRefVol() {
        return refVol;
    }

    @Override
    public String toString() {
        return "VolSimple{" + "paysDepart=" + paysDepart + ", paysDest=" + paysDest + ", aeroportDep=" + aeroportDep + ", aeroportDest=" + aeroportDest + ", dateAller=" + dateAller + ", refVol=" + refVol + '}';
    }
    
    
}
