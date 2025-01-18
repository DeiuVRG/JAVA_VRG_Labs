package com.exemplu;

public class SistemCalcul extends Echipament {
    private String tipMonitor;
    private double vitezaProcesor;
    private int capacitateHDD;
    private String sistemOperare;

    public SistemCalcul(String denumire, int nrInventar, double pret, String zonaMagazin, Stare stare,
                        String tipMonitor, double vitezaProcesor, int capacitateHDD, String sistemOperare) {
        super(denumire, nrInventar, pret, zonaMagazin, stare);
        this.tipMonitor = tipMonitor;
        this.vitezaProcesor = vitezaProcesor;
        this.capacitateHDD = capacitateHDD;
        this.sistemOperare = sistemOperare;
    }

    // Getter și Setter
    public String getTipMonitor() {
        return tipMonitor;
    }

    public void setTipMonitor(String tipMonitor) {
        this.tipMonitor = tipMonitor;
    }

    public double getVitezaProcesor() {
        return vitezaProcesor;
    }

    public void setVitezaProcesor(double vitezaProcesor) {
        this.vitezaProcesor = vitezaProcesor;
    }

    public int getCapacitateHDD() {
        return capacitateHDD;
    }

    public void setCapacitateHDD(int capacitateHDD) {
        this.capacitateHDD = capacitateHDD;
    }

    public String getSistemOperare() {
        return sistemOperare;
    }

    public void setSistemOperare(String sistemOperare) {
        this.sistemOperare = sistemOperare;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tip Monitor: " + tipMonitor + ", Viteză Procesor: " + vitezaProcesor +
                ", Capacitate HDD: " + capacitateHDD + ", Sistem Operare: " + sistemOperare;
    }
}
