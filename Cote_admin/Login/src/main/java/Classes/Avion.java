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

    public Avion(String modele, String compagnieFabricante,String reference) {
        this.modele = modele;
        this.compagnieFabricante = compagnieFabricante;
        this.reference = reference;
    }

    // Getters et setters
    // ...

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
}
