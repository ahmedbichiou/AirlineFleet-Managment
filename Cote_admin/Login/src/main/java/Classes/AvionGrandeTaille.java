/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Spray
 */
public class AvionGrandeTaille extends Avion {
private double porteeMaximale;
    private int capaciteMaximale;

    public AvionGrandeTaille(String modele, String compagnieFabricante,String reference, double porteeMaximale, int capaciteMaximale) {
        super(modele, compagnieFabricante,reference);
        this.porteeMaximale = porteeMaximale;
        this.capaciteMaximale = capaciteMaximale;
    }

    // Getters et setters
    // ...

    public double getPorteeMaximale() {
        return porteeMaximale;
    }

    public void setPorteeMaximale(double porteeMaximale) {
        this.porteeMaximale = porteeMaximale;
    }

    public int getCapaciteMaximale() {
        return capaciteMaximale;
    }

    public void setCapaciteMaximale(int capaciteMaximale) {
        this.capaciteMaximale = capaciteMaximale;
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


