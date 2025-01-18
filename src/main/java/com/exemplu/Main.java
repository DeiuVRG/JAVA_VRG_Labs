package com.exemplu;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Citim echipamentele din fișier
        List<Echipament> echipamente = Utilitati.citesteEchipamenteDinFisier("echipamente.txt");

        // Meniu interactiv
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Meniu Interactiv ---");
            System.out.println("1. Afișează toate echipamentele");
            System.out.println("2. Afișează imprimantele");
            System.out.println("3. Afișează copiatoarele");
            System.out.println("4. Afișează sistemele de calcul");
            System.out.println("5. Modifică starea unui echipament");
            System.out.println("6. Setează un mod de scriere pentru o imprimantă");
            System.out.println("7. Setează un format de copiere pentru un copiator");
            System.out.println("8. Instalează un sistem de operare pentru un sistem de calcul");
            System.out.println("9. Afișează echipamentele vândute");
            System.out.println("10. Salvează colecția în fișier binar");
            System.out.println("11. Ieșire");
            System.out.print("Alege o opțiune: ");

            int optiune = scanner.nextInt();
            scanner.nextLine(); // Consumăm newline

            switch (optiune) {
                case 1 -> afiseazaEchipamente(echipamente);
                case 2 -> afiseazaImprimante(echipamente);
                case 3 -> afiseazaCopiatoare(echipamente);
                case 4 -> afiseazaSistemeCalcul(echipamente);
                case 5 -> modificaStareaEchipament(echipamente, scanner);
                case 6 -> seteazaModScriereImprimanta(echipamente, scanner);
                case 7 -> seteazaFormatCopiereCopiator(echipamente, scanner);
                case 8 -> instaleazaSistemOperare(echipamente, scanner);
                case 9 -> afiseazaEchipamenteVandute(echipamente);
                case 10 -> salveazaInFisier(echipamente, "echip.bin");
                case 11 -> {
                    System.out.println("La revedere!");
                    return;
                }
                default -> System.out.println("Opțiune invalidă. Încearcă din nou.");
            }
        }
    }

    // 1. Afișare toate echipamentele
    public static void afiseazaEchipamente(List<Echipament> echipamente) {
        System.out.println("\nToate echipamentele:");
        echipamente.forEach(System.out::println);
    }

    // 2. Afișare imprimante
    public static void afiseazaImprimante(List<Echipament> echipamente) {
        System.out.println("\nImprimante:");
        echipamente.stream()
                .filter(e -> e instanceof Imprimanta)
                .forEach(System.out::println);
    }

    // 3. Afișare copiatoare
    public static void afiseazaCopiatoare(List<Echipament> echipamente) {
        System.out.println("\nCopiatoare:");
        echipamente.stream()
                .filter(e -> e instanceof Copiator)
                .forEach(System.out::println);
    }

    // 4. Afișare sisteme de calcul
    public static void afiseazaSistemeCalcul(List<Echipament> echipamente) {
        System.out.println("\nSisteme de calcul:");
        echipamente.stream()
                .filter(e -> e instanceof SistemCalcul)
                .forEach(System.out::println);
    }

    // 5. Modificare stare echipament
    public static void modificaStareaEchipament(List<Echipament> echipamente, Scanner scanner) {
        System.out.print("Introdu numărul de inventar: ");
        int nrInventar = scanner.nextInt();
        scanner.nextLine();

        Echipament echipament = echipamente.stream()
                .filter(e -> e.getNrInventar() == nrInventar)
                .findFirst()
                .orElse(null);

        if (echipament != null) {
            System.out.print("Introdu noua stare (ACHIZITIONAT, EXPUS, VANDUT): ");
            String stareNoua = scanner.nextLine().toUpperCase();
            try {
                echipament.setStare(Stare.valueOf(stareNoua));
                System.out.println("Starea a fost actualizată!");
            } catch (IllegalArgumentException e) {
                System.out.println("Stare invalidă.");
            }
        } else {
            System.out.println("Echipamentul nu a fost găsit.");
        }
    }

    //6.
    private static void seteazaModScriereImprimanta(List<Echipament> echipamente, Scanner scanner) {
        System.out.print("Introdu numărul de inventar al imprimantei: ");
        int nrInventar = scanner.nextInt();
        scanner.nextLine(); // Consumăm newline

        // Căutăm imprimanta
        Imprimanta imprimanta = (Imprimanta) echipamente.stream()
                .filter(e -> e instanceof Imprimanta && e.getNrInventar() == nrInventar)
                .findFirst()
                .orElse(null);

        if (imprimanta != null) {
            System.out.print("Introdu modul de scriere (Color / Alb-Negru): ");
            String modulTiparire = scanner.nextLine();

            if (modulTiparire.equalsIgnoreCase("Color") || modulTiparire.equalsIgnoreCase("Alb-Negru")) {
                imprimanta.setModulTiparire(modulTiparire);
                System.out.println("Modul de scriere a fost actualizat cu succes!");
            } else {
                System.out.println("Mod de scriere invalid. Introdu 'Color' sau 'Alb-Negru'.");
            }
        } else {
            System.out.println("Imprimanta nu a fost găsită.");
        }
    }

    //7.
    private static void seteazaFormatCopiereCopiator(List<Echipament> echipamente, Scanner scanner) {
        System.out.print("Introdu numărul de inventar al copiatorului: ");
        int nrInventar = scanner.nextInt();
        scanner.nextLine(); // Consumăm newline

        // Căutăm copiatorul
        Copiator copiator = (Copiator) echipamente.stream()
                .filter(e -> e instanceof Copiator && e.getNrInventar() == nrInventar)
                .findFirst()
                .orElse(null);

        if (copiator != null) {
            System.out.print("Introdu formatul de copiere (A3 / A4): ");
            String formatCopiere = scanner.nextLine();

            if (formatCopiere.equalsIgnoreCase("A3") || formatCopiere.equalsIgnoreCase("A4")) {
                copiator.setFormatCopiere(formatCopiere);
                System.out.println("Formatul de copiere a fost actualizat cu succes!");
            } else {
                System.out.println("Format de copiere invalid. Introdu 'A3' sau 'A4'.");
            }
        } else {
            System.out.println("Copiatorul nu a fost găsit.");
        }
    }

    // 8. Instalează un sistem de operare pentru un sistem de calcul
    private static void instaleazaSistemOperare(List<Echipament> echipamente, Scanner scanner) {
        System.out.print("Introdu numărul de inventar al sistemului de calcul: ");
        int nrInventar = scanner.nextInt();
        scanner.nextLine(); // Consumăm newline

        // Căutăm sistemul de calcul
        SistemCalcul sistemCalcul = (SistemCalcul) echipamente.stream()
                .filter(e -> e instanceof SistemCalcul && e.getNrInventar() == nrInventar)
                .findFirst()
                .orElse(null);

        if (sistemCalcul != null) {
            System.out.print("Introdu noul sistem de operare (Windows/Linux): ");
            String sistemOperare = scanner.nextLine().toLowerCase();

            if (sistemOperare.equals("windows") || sistemOperare.equals("linux")) {
                sistemCalcul.setSistemOperare(sistemOperare);
                System.out.println("Sistemul de operare a fost actualizat cu succes!");
            } else {
                System.out.println("Sistem de operare invalid. Trebuie să fie 'Windows' sau 'Linux'.");
            }
        } else {
            System.out.println("Sistemul de calcul nu a fost găsit.");
        }
    }

    //9.
    private static void afiseazaEchipamenteVandute(List<Echipament> echipamente) {
        System.out.println("\nEchipamente vândute:");
        echipamente.stream()
                .filter(e -> e.getStare() == Stare.VANDUT)
                .forEach(System.out::println);
    }

    //10.
    private static void salveazaInFisier(List<Echipament> echipamente, String numeFisier) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(numeFisier))) {
            oos.writeObject(echipamente);
            System.out.println("Colecția de echipamente a fost salvată în fișierul " + numeFisier);
        } catch (IOException e) {
            System.out.println("Eroare la salvarea colecției: " + e.getMessage());
        }
    }

}
