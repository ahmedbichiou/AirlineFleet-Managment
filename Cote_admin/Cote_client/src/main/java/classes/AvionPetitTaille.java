/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Spray
 */
public class AvionPetitTaille extends Avion {
 private int siege_1ereclass;


    public AvionPetitTaille(String modele, String compagnieFabricante,String reference, double portee, int capacite,int siege_1ereclass) {
        super(modele, compagnieFabricante,reference,portee,capacite);
       this.siege_1ereclass =siege_1ereclass;
    }

    // Getters et setters
    // ...

    public int getSiege_1ereclass() {
        return siege_1ereclass;
    }

    public void setSiege_1ereclass(int siege_1ereclass) {
        this.siege_1ereclass = siege_1ereclass;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getCompagnieFabricante() {
        return compagnieFabricante;
    }

    public void setCompagnieFabricante(String compagnieFabricante) {
        this.compagnieFabricante = compagnieFabricante;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getPortee() {
        return portee;
    }

    public void setPortee(double portee) {
        this.portee = portee;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @Override
    public String toString() {

        return "AvionPetitTaille{" +
                " modele='" + getModele() + '\'' +
                ", compagnieFabricante='" + getCompagnieFabricante() + '\'' +
                ", reference='" + getReference() + '\'' +
                ", siege_1ereclass='" + siege_1ereclass +'\''+
                  ", capacite='" + capacite + '\''+
                ", portee='" + portee + '\''+
                '}';
    }
    }

   
    



