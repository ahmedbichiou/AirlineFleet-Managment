/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

/**
 *
 * @author Spray
 */
public class Compagnie_aerienne {


    private String nom;
    private String mot_pass;
    private String paysOrigine;
    private int anneeFondation;

    public Compagnie_aerienne(String nom, String mot_pass, String paysOrigine, int anneeFondation) {
        this.nom = nom;
        this.mot_pass = mot_pass;
        this.paysOrigine = paysOrigine;
        this.anneeFondation = anneeFondation;
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




}

