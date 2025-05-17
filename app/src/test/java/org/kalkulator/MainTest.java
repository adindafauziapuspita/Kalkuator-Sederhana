package org.kalkulator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MainTest {

    private final InputStream standardIn = System.in;
    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    public void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(standardIn);
        System.setOut(standardOut);
    }

    @Test
    public void testShowMenu() {
        // Memanggil metode showMenu
        Main.showMenu();

        // Memeriksa output yang dihasilkan
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Pilih operasi yang ingin Anda lakukan:"));
        assertTrue(output.contains("1. Penjumlahan (+)"));
        assertTrue(output.contains("2. Pengurangan (-)"));
        assertTrue(output.contains("3. Perkalian (*)"));
        assertTrue(output.contains("4. Pembagian (/)"));
    }

    @Test
    public void testGetOperatorChoice() {
        // Menyiapkan input pengguna simulasi
        String input = "1\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);

        // Memanggil metode getOperatorChoice
        String result = Main.getOperatorChoice(scanner);

        // Memeriksa hasil
        assertEquals("1", result);
    }

    @Test
    public void testGetValidNumber() {
        // Menyiapkan input pengguna simulasi
        String input = "10\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);

        // Memanggil metode getValidNumber
        double result = Main.getValidNumber(scanner);

        // Memeriksa hasil
        assertEquals(10.0, result);
    }

    @Test
    public void testAskForContinue_Yes() {
        // Menyiapkan input pengguna simulasi untuk jawaban "y"
        String input = "y\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);

        // Memanggil metode askForContinue
        boolean result = Main.askForContinue(scanner);

        // Memeriksa hasil
        assertTrue(result);
    }

    @Test
    public void testAskForContinue_No() {
        // Menyiapkan input pengguna simulasi untuk jawaban "n"
        String input = "n\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);

        // Memanggil metode askForContinue
        boolean result = Main.askForContinue(scanner);

        // Memeriksa hasil
        assertFalse(result);
    }

    @Test
    public void testMain_HappyPath_Addition() {
        // Menyiapkan input untuk skenario penjumlahan yang berhasil
        String input = "1\n10\n5\nn\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Menjalankan metode main
        Main.main(new String[] {});

        // Memeriksa output
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Hasil: 15.0"));
    }

    @Test
    public void testMain_HappyPath_Subtraction() {
        // Menyiapkan input untuk skenario pengurangan yang berhasil
        String input = "2\n10\n5\nn\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Menjalankan metode main
        Main.main(new String[] {});

        // Memeriksa output
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Hasil: 5.0"));
    }

    @Test
    public void testMain_HappyPath_Multiplication() {
        // Menyiapkan input untuk skenario perkalian yang berhasil
        String input = "3\n10\n5\nn\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Menjalankan metode main
        Main.main(new String[] {});

        // Memeriksa output
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Hasil: 50.0"));
    }

    @Test
    public void testMain_HappyPath_Division() {
        // Menyiapkan input untuk skenario pembagian yang berhasil
        String input = "4\n10\n5\nn\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Menjalankan metode main
        Main.main(new String[] {});

        // Memeriksa output
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Hasil: 2.0"));
    }

    @Test
    public void testMain_InvalidOperator() {
        // Menyiapkan input dengan operator tidak valid
        String input = "9\n1\n10\n5\nn\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Menjalankan metode main
        Main.main(new String[] {});

        // Memeriksa output untuk pesan kesalahan
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Error: operator tidak valid"));
    }

    @Test
    public void testMain_DivisionByZero() {
        // Menyiapkan input untuk skenario pembagian dengan nol
        String input = "4\n10\n0\n5\nn\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Menjalankan metode main
        Main.main(new String[] {});

        // Memeriksa output untuk pesan kesalahan
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Error: pembagi tidak boleh nol"));
    }

    @Test
    public void testMain_MultipleCalculations() {
        // Menyiapkan input untuk beberapa perhitungan berturut-turut
        String input = "1\n10\n5\ny\n2\n20\n8\nn\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Menjalankan metode main
        Main.main(new String[] {});

        // Memeriksa output
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Hasil: 15.0"));
        assertTrue(output.contains("Hasil: 12.0"));
    }
}
