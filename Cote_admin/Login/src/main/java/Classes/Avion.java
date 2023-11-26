/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Spray
 */
public class Avion {
     protected String modele;
    protected String compagnieFabricante;
    protected String reference;
    protected double portee;
    protected int capacite;


    public Avion(String modele, String compagnieFabricante,String reference,double portee,int capacite) {
        this.modele = modele;
        this.compagnieFabricante = compagnieFabricante;
        this.reference = reference;
        this.portee = portee;
        this.capacite = capacite;
       
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    // Getters et setters
    // ...

    public String getModele() {
        return modele;
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

    @Override
        public String toString() {
        return "Avion{" +
                " modele='" + modele + '\'' +
                ", compagnieFabricante='" + compagnieFabricante + '\'' +
                ", reference='" + reference + '\'' +
                ", capacite='" + capacite + '\''+
                ", portee='" + portee + '\''+
                '}';
    
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
}
