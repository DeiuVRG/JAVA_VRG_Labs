package exemplu;

/*
   Clasa reprezintă o pereche de numere întregi (x și y).
   Are metode pentru:
   - Verificare dacă cele două numere sunt consecutive în șirul Fibonacci
   - Calculul celui mai mic multiplu comun (LCM)
   - Verificare dacă au suma cifrelor egală
   - Verificare dacă au același număr de cifre pare
*/
public class PerecheNumere {
    private int x;
    private int y;

    // Constructor fără parametri (necesar pentru Jackson)
    public PerecheNumere() {
    }

    // Constructor cu parametri
    public PerecheNumere(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Gettere și settere pentru x și y
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Metodă toString care returnează un text cu cele două valori
    @Override
    public String toString() {
        return "Pereche(" + x + ", " + y + ")";
    }

    /*
       Metodă care returnează true dacă x și y sunt valori consecutive
       în șirul Fibonacci (ex: 3 și 5, 5 și 8, 8 și 13)
    */
    public boolean suntConsecutiveFibonacci() {
        int minVal = Math.min(x, y);
        int maxVal = Math.max(x, y);

        // Eliminăm cazurile în care minVal <= 0
        if (minVal <= 0) {
            return false;
        }

        int a = 1, b = 1;
        // Generăm Fibonacci până depășim maxVal
        while (b <= maxVal) {
            if (a == minVal && b == maxVal) {
                return true;
            }
            int temp = a + b;
            a = b;
            b = temp;
        }
        return false;
    }

    /*
       Metodă care returnează cel mai mic multiplu comun (LCM) pentru x și y.
       Formula de bază: LCM(x,y) = |x * y| / GCD(x,y)
    */
    public int getMicMultipluComun() {
        int gcdValue = gcd(x, y);
        if (gcdValue == 0) {
            return 0;
        }
        return Math.abs(x * y) / gcdValue;
    }

    /*
       Metodă care returnează true dacă suma cifrelor lui x
       este egală cu suma cifrelor lui y.
    */
    public boolean auSumaCifrelorEgala() {
        return sumaCifrelor(x) == sumaCifrelor(y);
    }

    /*
       Metodă care returnează true dacă x și y au același număr de cifre pare.
       De exemplu, 24 are cifre (2,4) -> ambele pare, deci 2 cifre pare.
    */
    public boolean auAcelasiNumarCifrePare() {
        return numarCifrePare(x) == numarCifrePare(y);
    }

    // Metodă privată pentru calculul GCD (cmmdc)
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Metodă privată pentru calculul sumei cifrelor
    private int sumaCifrelor(int n) {
        int val = Math.abs(n);
        int sum = 0;
        while (val > 0) {
            sum += val % 10;
            val /= 10;
        }
        return sum;
    }

    // Metodă privată pentru numărarea cifrelor pare dintr-un număr
    private int numarCifrePare(int n) {
        int val = Math.abs(n);
        int count = 0;
        while (val > 0) {
            int c = val % 10;
            if (c % 2 == 0) {
                count++;
            }
            val /= 10;
        }
        return count;
    }
}
