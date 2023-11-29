/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Spray
 */
public class AvionGrandeTaille extends Avion {
 private double capacite_cargo_kg;

    public AvionGrandeTaille(String modele, String compagnieFabricante,String reference, double portee,int capacite,double cargo) {
        super(modele, compagnieFabricante,reference,portee,capacite);
       this.capacite_cargo_kg= cargo;
    }

    // Getters et setters
    // ...

    public double getCapacite_cargo_kg() {
        return capacite_cargo_kg;
    }

    public void setCapacite_cargo_kg(double capcite_cargo_kg) {
        this.capacite_cargo_kg = capcite_cargo_kg;
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

    @Override
    public String toString() {
          return "AvionGrandeTaille{" +
                " modele='" + getModele() + '\'' +
                ", compagnieFabricante='" + getCompagnieFabricante() + '\'' +
                ", reference='" + getReference() + '\'' +
                ", capacite_cargo_kg='" + capacite_cargo_kg +'\''+
                ", capacite='" + capacite + '\''+
                ", portee='" + portee + '\''+
                '}';
    }
    }

    

    



