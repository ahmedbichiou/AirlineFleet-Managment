/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Spray
 */
public class Compagnie_aerienne {


    private String nom;
    private String mot_pass;
    private String paysOrigine;
    private int anneeFondation;
    private Map<String,Avion> list_Avions;
   
     private Map<String,Vol> list_vols;


    public Compagnie_aerienne(String nom, String mot_pass, String paysOrigine, int anneeFondation) {
        this.nom = nom;
        this.mot_pass = mot_pass;
        this.paysOrigine = paysOrigine;
        this.anneeFondation = anneeFondation;
        this.list_Avions = new HashMap<>();
        this.list_vols= new HashMap<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getmot_pass() {
        return mot_pass;
    }

    public void setmot_pass(String mot_pass) {
        this.mot_pass = mot_pass;
    }

    public String getPaysOrigine() {
        return paysOrigine;
    }

    public void setPaysOrigine(String paysOrigine) {
        this.paysOrigine = paysOrigine;
    }

    public int getAnneeFondation() {
        return anneeFondation;
    }

    public void setAnneeFondation(int anneeFondation) {
        this.anneeFondation = anneeFondation;
    }

 
    public void afficherInfos() {
        System.out.println("Nom de la compagnie: " + nom);
        System.out.println("Pays d'origine: " + paysOrigine);
        System.out.println("Année de fondation: " + anneeFondation);
    }

    // Méthode pour afficher tous les avions
    public void afficherAvions() {
        System.out.println("Liste des avions :");
        for (Map.Entry<String, Avion> entry : list_Avions.entrySet()) {
            System.out.println("ID : " + entry.getKey() + ", Avion : " + entry.getValue());
        }
        System.out.println();
    }
public void afficherVols() {
    System.out.println("Liste des vols :");
    for (Map.Entry<String, Vol> entry : list_vols.entrySet()) {
        System.out.println("ID : " + entry.getKey() + ", Vol : " + entry.getValue());
    }
    System.out.println();
}

    public Map<String, Vol> getList_vols() {
        return list_vols;
    }

    public void setList_vols(Map<String, Vol> list_vols) {
        this.list_vols = list_vols;
    }

    public Map<String, Avion> getList_Avions() {
        return list_Avions;
    }

    public void setList_Avions(Map<String, Avion> list_Avions) {
        this.list_Avions = list_Avions;
    }

    // Méthode pour ajouter un avion
    public void ajouterAvion(String reference, Avion avion) {
        list_Avions.put(reference, avion);
        //System.out.println("Avion ajouté avec succès. ID : " + reference + ", Avion : " + avion);
    }
    public void ajouterVol(String reference, Vol vol) {
    list_vols.put(reference, vol);
    //System.out.println("Vol ajouté avec succès. ID : " + reference + ", Vol : " + vol);
}

    // Méthode pour supprimer un avion
    public void supprimerAvion(String reference) {
        if (list_Avions.containsKey(reference)) {
            Avion avionSupprime = list_Avions.remove(reference);
            System.out.println("Avion supprimé avec succès. ID : " + reference + ", Avion : " + avionSupprime);
        } else {
            System.out.println("Avion avec l'ID " + reference + " non trouvé.");
        }
    }
    
    public void supprimerVol(String reference) {
    if (list_vols.containsKey(reference)) {
        Vol volSupprime = list_vols.remove(reference);
        System.out.println("Vol supprimé avec succès. ID : " + reference + ", Vol : " + volSupprime);
    } else {
        System.out.println("Vol avec l'ID " + reference + " non trouvé.");
    }
}


    @Override
    public String toString() {
        return "Compagnie_aerienne{" + "nom=" + nom + ", mot_pass=" + mot_pass + ", paysOrigine=" + paysOrigine + ", anneeFondation=" + anneeFondation  + '}';
    }




}

