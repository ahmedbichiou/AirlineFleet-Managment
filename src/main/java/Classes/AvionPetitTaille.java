/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Spray
 */
public class AvionPetitTaille extends Avion {
    private double portee;
    private int capacite;

    public AvionPetitTaille(String modele, String compagnieFabricante,String reference, double portee, int capacite) {
        super(modele, compagnieFabricante,reference);
        this.portee = portee;
        this.capacite = capacite;
    }

    // Getters et setters
    // ...

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
    public String getModele() {
        return modele;
    }

    @Override
    public void setModele(String modele) {
        this.modele = modele;
    }

    @Override
    public String getCompagnieFabricante() {
        return compagnieFabricante;
    }

    @Override
    public void setCompagnieFabricante(String compagnieFabricante) {
        this.compagnieFabricante = compagnieFabricante;
    }
    
}


