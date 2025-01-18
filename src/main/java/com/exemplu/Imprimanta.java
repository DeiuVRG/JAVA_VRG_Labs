package com.exemplu;

public class Imprimanta extends Echipament {
    private int ppm;
    private String rezolutie;
    private int paginiCartus;
    private String modulTiparire;

    public Imprimanta(String denumire, int nrInventar, double pret, String zonaMagazin, Stare stare,
                      int ppm, String rezolutie, int paginiCartus, String modulTiparire) {
        super(denumire, nrInventar, pret, zonaMagazin, stare);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.paginiCartus = paginiCartus;
        this.modulTiparire = modulTiparire;
    }

    // Getter și Setter
    public int getPpm() {
        return ppm;
    }

    public void setPpm(int ppm) {
        this.ppm = ppm;
    }

    public String getRezolutie() {
        return rezolutie;
    }

    public void setRezolutie(String rezolutie) {
        this.rezolutie = rezolutie;
    }

    public int getPaginiCartus() {
        return paginiCartus;
    }

    public void setPaginiCartus(int paginiCartus) {
        this.paginiCartus = paginiCartus;
    }

    public String getModulTiparire() {
        return modulTiparire;
    }

    public void setModulTiparire(String modulTiparire) {
        this.modulTiparire = modulTiparire;
    }

    @Override
    public String toString() {
        return super.toString() + ", PPM: " + ppm + ", Rezoluție: " + rezolutie +
                ", Pagini/Cartuș: " + paginiCartus + ", Modul Tipărire: " + modulTiparire;
    }
}
