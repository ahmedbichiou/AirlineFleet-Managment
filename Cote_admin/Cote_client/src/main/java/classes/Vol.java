/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Spray
 */
public class Vol {
    protected String refVol;
    protected String paysDepart;
    protected String paysDest;
    protected String aeroportDep;
    protected String aeroportDest;
    protected LocalDate dateAller;
    protected Avion avion;
    protected float prix;
    protected List<Client> clients;


    // Constructor
    public Vol(String refVol, String paysDepart, String paysDest, String aeroportDep, String aeroportDest,
               LocalDate dateAller, Avion avion, float prix) {
        this.refVol = refVol;
        this.paysDepart = paysDepart;
        this.paysDest = paysDest;
        this.aeroportDep = aeroportDep;
        this.aeroportDest = aeroportDest;
        this.dateAller = dateAller;
        this.avion = avion;
        this.prix = prix;

    }

    // Getters and setters
    public String getRefVol() {
        return refVol;
    }

    public void setRefVol(String refVol) {
        this.refVol = refVol;
    }

    public String getPaysDepart() {
        return paysDepart;
    }

    public void setPaysDepart(String paysDepart) {
        this.paysDepart = paysDepart;
    }

    // Continue with getters and setters for other properties...

    // toString method
    @Override
    public String toString() {
        return "Vol{" +
                "refVol='" + refVol + '\'' +
                ", paysDepart='" + paysDepart + '\'' +
                ", paysDest='" + paysDest + '\'' +
                ", aeroportDep='" + aeroportDep + '\'' +
                ", aeroportDest='" + aeroportDest + '\'' +
                ", dateAller='" + dateAller + '\'' +
                ", ref avion='" + avion.getReference() + '\'' +
                ", prix='" + prix + + '\'' +
                '}';
    }

    public String getPaysDest() {
        return paysDest;
    }

    public void setPaysDest(String paysDest) {
        this.paysDest = paysDest;
    }

    public String getAeroportDep() {
        return aeroportDep;
    }

    public void setAeroportDep(String aeroportDep) {
        this.aeroportDep = aeroportDep;
    }

    public String getAeroportDest() {
        return aeroportDest;
    }

    public void setAeroportDest(String aeroportDest) {
        this.aeroportDest = aeroportDest;
    }

    public LocalDate getDateAller() {
        return dateAller;
    }

    public void setDateAller(LocalDate dateAller) {
        this.dateAller = dateAller;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}

