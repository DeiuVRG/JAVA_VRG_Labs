package com.exemplu;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Utilitati {
    public static List<Echipament> citesteEchipamenteDinFisier(String fisier) {
        List<Echipament> echipamente = new ArrayList<>();

        // Folosim ClassLoader pentru a încărca fișierul din resources
        try (InputStream inputStream = Utilitati.class.getClassLoader().getResourceAsStream(fisier);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            String linie;
            while ((linie = br.readLine()) != null) {
                String[] campuri = linie.split(";");
                String denumire = campuri[0];
                int nrInventar = Integer.parseInt(campuri[1]);
                double pret = Double.parseDouble(campuri[2]);
                String zonaMagazin = campuri[3];
                Stare stare = Stare.valueOf(campuri[4].toUpperCase());
                String tip = campuri[5];

                switch (tip.toLowerCase()) {
                    case "imprimanta" -> {
                        int ppm = Integer.parseInt(campuri[6]);
                        String rezolutie = campuri[7];
                        int paginiCartus = Integer.parseInt(campuri[8]);
                        String modulTiparire = campuri[9];
                        echipamente.add(new Imprimanta(denumire, nrInventar, pret, zonaMagazin, stare, ppm, rezolutie, paginiCartus, modulTiparire));
                    }
                    case "copiator" -> {
                        int paginiToner = Integer.parseInt(campuri[6]);
                        String formatCopiere = campuri[7];
                        echipamente.add(new Copiator(denumire, nrInventar, pret, zonaMagazin, stare, paginiToner, formatCopiere));
                    }
                    case "sistem de calcul" -> {
                        String tipMonitor = campuri[6];
                        double vitezaProcesor = Double.parseDouble(campuri[7]);
                        int capacitateHDD = Integer.parseInt(campuri[8]);
                        String sistemOperare = campuri[9];
                        echipamente.add(new SistemCalcul(denumire, nrInventar, pret, zonaMagazin, stare, tipMonitor, vitezaProcesor, capacitateHDD, sistemOperare));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Eroare la citirea fișierului: " + e.getMessage());
        }

        return echipamente;
    }
}
