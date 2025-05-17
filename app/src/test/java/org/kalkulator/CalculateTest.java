package org.kalkulator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculateTest {

    @Test
    public void testTambah() {
        // Menguji operasi penambahan
        double hasil = Calculate.calculate('1', 5, 3);
        assertEquals(8, hasil, "5 + 3 harus sama dengan 8");

        // Pengujian dengan angka negatif
        hasil = Calculate.calculate('1', -5, 3);
        assertEquals(-2, hasil, "-5 + 3 harus sama dengan -2");

        // Pengujian dengan angka desimal
        hasil = Calculate.calculate('1', 2.5, 3.5);
        assertEquals(6.0, hasil, "2.5 + 3.5 harus sama dengan 6.0");
    }

    @Test
    public void testKurang() {
        // Menguji operasi pengurangan
        double hasil = Calculate.calculate('2', 5, 3);
        assertEquals(2, hasil, "5 - 3 harus sama dengan 2");

        // Pengujian dengan angka negatif
        hasil = Calculate.calculate('2', -5, 3);
        assertEquals(-8, hasil, "-5 - 3 harus sama dengan -8");

        // Pengujian dengan angka desimal
        hasil = Calculate.calculate('2', 5.5, 2.5);
        assertEquals(3.0, hasil, "5.5 - 2.5 harus sama dengan 3.0");
    }

    @Test
    public void testKali() {
        // Menguji operasi perkalian
        double hasil = Calculate.calculate('3', 5, 3);
        assertEquals(15, hasil, "5 * 3 harus sama dengan 15");

        // Pengujian dengan angka negatif
        hasil = Calculate.calculate('3', -5, 3);
        assertEquals(-15, hasil, "-5 * 3 harus sama dengan -15");

        // Pengujian dengan angka desimal
        hasil = Calculate.calculate('3', 2.5, 2);
        assertEquals(5.0, hasil, "2.5 * 2 harus sama dengan 5.0");
    }

    @Test
    public void testBagi() {
        // Menguji operasi pembagian
        double hasil = Calculate.calculate('4', 6, 3);
        assertEquals(2, hasil, "6 / 3 harus sama dengan 2");

        // Pengujian dengan angka negatif
        hasil = Calculate.calculate('4', -6, 3);
        assertEquals(-2, hasil, "-6 / 3 harus sama dengan -2");

        // Pengujian dengan angka desimal
        hasil = Calculate.calculate('4', 5, 2);
        assertEquals(2.5, hasil, "5 / 2 harus sama dengan 2.5");
    }

    @Test
    public void testPilihanTidakValid() {
        // Menguji pilihan yang tidak valid
        double hasil = Calculate.calculate('9', 5, 3);
        assertTrue(Double.isNaN(hasil), "Pilihan tidak valid harus mengembalikan NaN");
    }

    @Test
    public void testBagiDenganNol() {
        // Menguji pembagian dengan nol (khusus untuk Java, menghasilkan Infinity)
        double hasil = Calculate.calculate('4', 5, 0);
        assertTrue(Double.isInfinite(hasil), "Pembagian dengan nol harus mengembalikan Infinity");
    }
}
