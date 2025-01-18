package com.exemplu;

import java.io.Serializable;

public abstract class Echipament implements Serializable {
    private String denumire;
    private int nrInventar;
    private double pret;
    private String zonaMagazin;
    private Stare stare;

    public Echipament(String denumire, int nrInventar, double pret, String zonaMagazin, Stare stare) {
        this.denumire = denumire;
        this.nrInventar = nrInventar;
        this.pret = pret;
        this.zonaMagazin = zonaMagazin;
        this.stare = stare;
    }

    // Getter și Setter
    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getNrInventar() {
        return nrInventar;
    }

    public void setNrInventar(int nrInventar) {
        this.nrInventar = nrInventar;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getZonaMagazin() {
        return zonaMagazin;
    }

    public void setZonaMagazin(String zonaMagazin) {
        this.zonaMagazin = zonaMagazin;
    }

    public Stare getStare() {
        return stare;
    }

    public void setStare(Stare stare) {
        this.stare = stare;
    }

    @Override
    public String toString() {
        return "Denumire: " + denumire + ", Nr Inventar: " + nrInventar + ", Preț: " + pret +
                ", Zonă Magazin: " + zonaMagazin + ", Stare: " + stare;
    }
}
