package com.exemplu;

public class Copiator extends Echipament {
    private int paginiToner;
    private String formatCopiere;

    public Copiator(String denumire, int nrInventar, double pret, String zonaMagazin, Stare stare,
                    int paginiToner, String formatCopiere) {
        super(denumire, nrInventar, pret, zonaMagazin, stare);
        this.paginiToner = paginiToner;
        this.formatCopiere = formatCopiere;
    }

    // Getter și Setter
    public int getPaginiToner() {
        return paginiToner;
    }

    public void setPaginiToner(int paginiToner) {
        this.paginiToner = paginiToner;
    }

    public String getFormatCopiere() {
        return formatCopiere;
    }

    public void setFormatCopiere(String formatCopiere) {
        this.formatCopiere = formatCopiere;
    }

    @Override
    public String toString() {
        return super.toString() + ", Pagini/Toner: " + paginiToner + ", Format Copiere: " + formatCopiere;
    }
}
