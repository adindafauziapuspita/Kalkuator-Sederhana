package org.kalkulator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidationTest {

    @Test
    public void testValidasiOperator_Valid() {
        // Tidak ada exception yang diharapkan untuk operator yang valid
        assertDoesNotThrow(() -> Validation.validasiOperator('1'));
        assertDoesNotThrow(() -> Validation.validasiOperator('2'));
        assertDoesNotThrow(() -> Validation.validasiOperator('3'));
        assertDoesNotThrow(() -> Validation.validasiOperator('4'));
    }

    @Test
    public void testValidasiOperator_Invalid() {
        // Exception diharapkan untuk operator yang tidak valid
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Validation.validasiOperator('5');
        });

        String expectedMessage = "Error: operator tidak valid";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testValidasiInput_ValidRange() {
        // Tidak ada exception yang diharapkan untuk input dalam rentang valid
        assertDoesNotThrow(() -> Validation.validasiInput(100, 200));
        assertDoesNotThrow(() -> Validation.validasiInput(-100, 200));
        assertDoesNotThrow(() -> Validation.validasiInput(32767, -32768));
    }

    @Test
    public void testValidasiInput_OutOfRange() {
        // Exception diharapkan untuk input di luar rentang valid
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Validation.validasiInput(40000, 200);
        });

        String expectedMessage = "Error: Bilangan Pertama tidak berada pada rentang";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

        // Pengujian untuk nilai kedua di luar rentang
        exception = assertThrows(IllegalArgumentException.class, () -> {
            Validation.validasiInput(200, -40000);
        });

        assertTrue(exception.getMessage().contains("Error: Bilangan Kedua tidak berada pada rentang"));
    }

    @Test
    public void testValidasiPembagi_NonZero() {
        // Tidak ada exception yang diharapkan untuk pembagi bukan nol
        assertDoesNotThrow(() -> Validation.validasiPembagi(5, '4'));
        assertDoesNotThrow(() -> Validation.validasiPembagi(-5, '4'));
    }

    @Test
    public void testValidasiPembagi_Zero() {
        // Exception diharapkan untuk pembagi nol pada operasi pembagian
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Validation.validasiPembagi(0, '4');
        });

        String expectedMessage = "Error: pembagi tidak boleh nol";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testValidasiPembagi_ZeroButNotDivision() {
        // Tidak ada exception untuk pembagi nol pada operasi selain pembagian
        assertDoesNotThrow(() -> Validation.validasiPembagi(0, '1'));
        assertDoesNotThrow(() -> Validation.validasiPembagi(0, '2'));
        assertDoesNotThrow(() -> Validation.validasiPembagi(0, '3'));
    }

    @Test
    public void testValidasiInputAngka_ValidNumber() {
        // Menguji angka valid
        assertEquals(10.0, Validation.validasiInputAngka("10"));
        assertEquals(-10.0, Validation.validasiInputAngka("-10"));
        assertEquals(10.5, Validation.validasiInputAngka("10.5"));
    }

    @Test
    public void testValidasiInputAngka_InvalidNumber() {
        // Exception diharapkan untuk input yang bukan angka
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Validation.validasiInputAngka("abc");
        });

        String expectedMessage = "Error: Input bukan angka";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
