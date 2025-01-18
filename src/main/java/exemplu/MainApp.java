package exemplu;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
   Clasa principală pentru demonstratie.
   Are metode statice scriere() și citire() pentru fișiere JSON,
   plus un main cu exemplu de utilizare.
*/
public class MainApp {

    // Metodă care încarcă (citește) lista de PerecheNumere din perechi.json
    public static List<PerecheNumere> citire() {
        File file = new File("src/main/resources/perechi.json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<PerecheNumere> lista = mapper.readValue(
                    file,
                    new TypeReference<List<PerecheNumere>>() {}
            );
            return lista;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Metodă care salvează (scrie) lista de PerecheNumere în perechi.json
    public static void scriere(List<PerecheNumere> lista) {
        File file = new File("src/main/resources/perechi.json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metoda main pentru test
    public static void main(String[] args) {
        // 1) Citim lista inițială din JSON
        List<PerecheNumere> perechi = citire();

        // 2) Afișăm lista
        System.out.println("== Lista inițială citită ==");
        for (PerecheNumere p : perechi) {
            System.out.println(p);
        }

        // 3) Adăugăm 3 perechi noi
        perechi.add(new PerecheNumere(8, 13));
        perechi.add(new PerecheNumere(12, 18));
        perechi.add(new PerecheNumere(123, 321));

        // 4) Scriem lista în JSON (se va actualiza perechi.json)
        scriere(perechi);

        // 5) Citim din nou pentru a confirma că datele s-au salvat
        System.out.println("\n== Lista după adăugare ==");
        List<PerecheNumere> perechi2 = citire();
        for (PerecheNumere p : perechi2) {
            System.out.println(p);
        }
    }
}
