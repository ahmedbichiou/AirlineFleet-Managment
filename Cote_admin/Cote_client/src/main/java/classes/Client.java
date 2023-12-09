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
public class Client {
    private String nomClt;
    private String prénomClt;
    private LocalDate dateNaiss;
    private String email;
    private String mdp;
    private Reservation myReservation;

    public Client(String nomClt, String prénomClt, LocalDate dateNaiss, String email, String mdp) {
        this.nomClt = nomClt;
        this.prénomClt = prénomClt;
        this.dateNaiss = dateNaiss;
        this.email = email;
        this.mdp = mdp;
        myReservation = null;
    }

    public Reservation getMyReservation() {
        return myReservation;
    }

    public void setMyReservation(Reservation myReservation) {
        this.myReservation = myReservation;
    }

    public String getNomClt() {
        return nomClt;
    }

    public void setNomClt(String nomClt) {
        this.nomClt = nomClt;
    }

    public String getPrénomClt() {
        return prénomClt;
    }

    public void setPrénomClt(String prénomClt) {
        this.prénomClt = prénomClt;
    }

    public LocalDate getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(LocalDate dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        return "Client{" + "nomClt=" + nomClt + ", prenomClt=" + prénomClt + ", dateNaiss=" + dateNaiss + ", email=" + email + ", mdp=" + mdp + '}';
    }
    
    
    
}
