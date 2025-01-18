package teste;

import exemplu.PerecheNumere;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPerecheNumere {

    // Test pentru metoda suntConsecutiveFibonacci()
    @Test
    void test_suntConsecutiveFibonacci() {
        PerecheNumere p1 = new PerecheNumere(3, 5);
        assertTrue(p1.suntConsecutiveFibonacci());

        PerecheNumere p2 = new PerecheNumere(5, 8);
        assertTrue(p2.suntConsecutiveFibonacci());

        PerecheNumere p3 = new PerecheNumere(4, 6);
        assertFalse(p3.suntConsecutiveFibonacci());
    }

    // Test pentru metoda getMicMultipluComun()
    @Test
    void test_getMicMultipluComun() {
        PerecheNumere p1 = new PerecheNumere(12, 18);
        assertEquals(36, p1.getMicMultipluComun());

        PerecheNumere p2 = new PerecheNumere(5, 0);
        assertEquals(0, p2.getMicMultipluComun());

        PerecheNumere p3 = new PerecheNumere(3, 5);
        assertEquals(15, p3.getMicMultipluComun());
    }

    // Test pentru metoda auSumaCifrelorEgala()
    @Test
    void test_auSumaCifrelorEgala() {
        PerecheNumere p1 = new PerecheNumere(12, 30);
        assertTrue(p1.auSumaCifrelorEgala());

        PerecheNumere p2 = new PerecheNumere(123, 51);
        assertTrue(p2.auSumaCifrelorEgala());

        PerecheNumere p3 = new PerecheNumere(99, 66);
        assertFalse(p3.auSumaCifrelorEgala());
    }

    // Test pentru metoda auAcelasiNumarCifrePare()
    @Test
    void test_auAcelasiNumarCifrePare() {
        PerecheNumere p1 = new PerecheNumere(24, 86);
        assertTrue(p1.auAcelasiNumarCifrePare());

        PerecheNumere p2 = new PerecheNumere(11, 202);
        assertFalse(p2.auAcelasiNumarCifrePare());

        PerecheNumere p3 = new PerecheNumere(70, 32);
        assertTrue(p3.auAcelasiNumarCifrePare());
    }
}
