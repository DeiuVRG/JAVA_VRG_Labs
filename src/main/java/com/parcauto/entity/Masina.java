package com.parcauto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "masini")
public class Masina {

    @Id
    private String nrInmatriculare;
    private String marca;
    private String model;
    private String culoare;
    private int anFabricatie;
    private int capacitateCilindrica;
    private String tipCombustibil;
    private int putere;
    private int cuplu;
    private int volumPortbagaj;
    private int pret;

    // Getter și Setter pentru nrInmatriculare
    public String getNrInmatriculare() {
        return nrInmatriculare;
    }

    public void setNrInmatriculare(String nrInmatriculare) {
        this.nrInmatriculare = nrInmatriculare;
    }

    // Getter și Setter pentru marca
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    // Getter și Setter pentru model
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Getter și Setter pentru culoare
    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    // Getter și Setter pentru anFabricatie
    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    // Getter și Setter pentru capacitateCilindrica
    public int getCapacitateCilindrica() {
        return capacitateCilindrica;
    }

    public void setCapacitateCilindrica(int capacitateCilindrica) {
        this.capacitateCilindrica = capacitateCilindrica;
    }

    // Getter și Setter pentru tipCombustibil
    public String getTipCombustibil() {
        return tipCombustibil;
    }

    public void setTipCombustibil(String tipCombustibil) {
        this.tipCombustibil = tipCombustibil;
    }

    // Getter și Setter pentru putere
    public int getPutere() {
        return putere;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    // Getter și Setter pentru cuplu
    public int getCuplu() {
        return cuplu;
    }

    public void setCuplu(int cuplu) {
        this.cuplu = cuplu;
    }

    // Getter și Setter pentru volumPortbagaj
    public int getVolumPortbagaj() {
        return volumPortbagaj;
    }

    public void setVolumPortbagaj(int volumPortbagaj) {
        this.volumPortbagaj = volumPortbagaj;
    }

    // Getter și Setter pentru pret
    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }
}
