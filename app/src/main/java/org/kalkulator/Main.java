package org.kalkulator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean lanjut = true;

        System.out.println("======================================");
        System.out.println("Selamat datang di Kalkulator Sederhana");
        System.out.println("======================================");

        while (lanjut) {
            try {
                showMenu();

                String pilihan = getOperatorChoice(scanner);
                
                Validation.validasiOperator(pilihan.charAt(0));

                double num1 = getValidNumber(scanner);
                Validation.validasiInput(num1, 0);
                double num2 = getValidNumber(scanner);
                Validation.validasiInput(num1, num2);

                Validation.validasiPembagi(num2, pilihan.charAt(0));

                double hasil = Calculate.calculate(pilihan.charAt(0), num1, num2);
                System.out.println("======================================");
                System.out.println("Hasil: " + hasil);
                System.out.println("======================================");

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            lanjut = askForContinue(scanner);
            if (!lanjut) {
                System.out.println("======================================");
                System.out.println("Terima kasih telah menggunakan kalkulator!");
                System.out.println("======================================");
            }
        }
        scanner.close();
    }

    public static void showMenu() {
        System.out.println("======================================");
        System.out.println("Pilih operasi yang ingin Anda lakukan:");
        System.out.println("1. Penjumlahan (+)");
        System.out.println("2. Pengurangan (-)");
        System.out.println("3. Perkalian (*)");
        System.out.println("4. Pembagian (/)");
        System.out.println("======================================");
    }

    public static String getOperatorChoice(Scanner scanner) {
        System.out.print("Masukkan pilihan Anda (1/2/3/4): ");
        return scanner.nextLine();
    }

    public static double getValidNumber(Scanner scanner) {
        double num;
        System.out.print("Masukkan bilangan dengan rentang -32768 s.d. 32767: ");
        String input = scanner.nextLine();
        num = Validation.validasiInputAngka(input);
        return num;
    }

    public static boolean askForContinue(Scanner scanner) {
        System.out.print("Apakah Anda ingin melakukan perhitungan lagi? (y/n): ");
        String jawaban = scanner.nextLine();
        return jawaban.equalsIgnoreCase("y");
    }
}