package problema1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.Math.hypot;

class Parabola {
    // Membrii clasei care sunt coeficienții a, b, c
    private final int a, b, c;

    // Constructorul care primește 3 parametri
    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Calculeaza și returneaza coordonatele varfului parabolei
    public double[] calculeazaVarf() {
        double x = -b / (2.0 * a);
        double y = (-b * b + 4 * a * c) / (4.0 * a);
        return new double[]{x, y};
    }

    // Redefinirea metodei toString() pentru a afișa ecuația parabolei
    @Override
    public String toString() {
        return "f(x) = " + a + "x^2 + " + b + "x + " + c;
    }

    // Funcție care primește o parabolă si calculeaza coordonatele mijlocului segmentului de dreapta
    public double[] calculeazaMijlocul(Parabola p) {
        double[] varfCurent = this.calculeazaVarf();
        double[] varfAlt = p.calculeazaVarf();
        double xMijloc = (varfCurent[0] + varfAlt[0]) / 2.0;
        double yMijloc = (varfCurent[1] + varfAlt[1]) / 2.0;
        return new double[]{xMijloc, yMijloc};
    }

    // Funcție statica pentru a calcula mijlocul segmentului dintre doua parabole
    public static double[] calculeazaMijloculStatic(Parabola p1, Parabola p2) {
        double[] varf1 = p1.calculeazaVarf();
        double[] varf2 = p2.calculeazaVarf();
        double xMijloc = (varf1[0] + varf2[0]) / 2.0;
        double yMijloc = (varf1[1] + varf2[1]) / 2.0;
        return new double[]{xMijloc, yMijloc};
    }

    // Funcție pentru a calcula lungimea segmentului de dreapta dintre doua parabole
    public double calculeazaLungimeaSegmentului(Parabola p) {
        double[] varfCurent = this.calculeazaVarf();
        double[] varfAlt = p.calculeazaVarf();
        return hypot(varfAlt[0] - varfCurent[0], varfAlt[1] - varfCurent[1]);
    }

    // Funcție statica pentru a calcula lungimea segmentului dintre doua parabole
    public static double calculeazaLungimeaSegmentuluiStatic(Parabola p1, Parabola p2) {
        double[] varf1 = p1.calculeazaVarf();
        double[] varf2 = p2.calculeazaVarf();
        return hypot(varf2[0] - varf1[0], varf2[1] - varf1[1]);
    }

    // Citirea parabolelor din fișierul "in.txt"
    public static List<Parabola> citesteParaboleDinFisier(Scanner scanner) {
        List<Parabola> parabole = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] coeficienti = scanner.nextLine().trim().split(" ");
            if (coeficienti.length == 3) {  // linia trebe sa aiba 3 coeficienți
                int a = Integer.parseInt(coeficienti[0]);
                int b = Integer.parseInt(coeficienti[1]);
                int c = Integer.parseInt(coeficienti[2]);
                parabole.add(new Parabola(a, b, c));
            } else {
                System.out.println("Linia nu conține 3 coeficienți valizi. A fost ignorata.");
            }
        }
        return parabole;
    }

    public static void main(String[] args) {
        try {
            // Citire si noi  din fișierul in.txt
            File file = new File("/Users/deiuvrg/Library/CloudStorage/OneDrive-UniversitateaPolitehnicaTimisoara/IS AN 3/SEM 1/ProgramareJava/Lab3/src/problema1/in.txt");
            Scanner scanner = new Scanner(file);  // Citire din fișierul in.txt
            List<Parabola> parabole = citesteParaboleDinFisier(scanner);

            // Verifica daca exista parabole
            if (parabole.isEmpty()) {
                System.out.println("Nu exista parabole valide in fișierul de intrare.");
                return;
            }

            // Afișare parabole
            for (Parabola p : parabole) {
                System.out.println(p);
                System.out.println("Varf: (" + p.calculeazaVarf()[0] + ", " + p.calculeazaVarf()[1] + ")");
            }

            // Verifica dacă există cel puțin două parabole pentru calcule
            if (parabole.size() >= 2) {
                Parabola p1 = parabole.get(0);
                Parabola p2 = parabole.get(1);

                // Apelarea metodei non-statice 'calculeazaMijlocul'
                double[] mijlocNonStatic = p1.calculeazaMijlocul(p2);
                System.out.println("Mijlocul segmentului (non-static) dintre primele două parabole: ("
                        + mijlocNonStatic[0] + ", " + mijlocNonStatic[1] + ")");

                // Apelarea metodei non-statice 'calculeazaLungimeaSegmentului'
                double lungimeNonStatic = p1.calculeazaLungimeaSegmentului(p2);
                System.out.println("Lungimea segmentului (non-static) dintre primele doua parabole: " + lungimeNonStatic);
            } else {
                System.out.println("Nu sunt suficiente parabole pentru calculele dintre doua parabole.");
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Fișierul nu a fost gssit.");
            e.printStackTrace();
        }
    }
}
