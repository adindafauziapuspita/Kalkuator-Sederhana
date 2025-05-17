package org.kalkulator;

public class Validation {

    public static double validasiInputAngka(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error: Input bukan angka.");
        }
    }

    public static void validasiInput(double num1, double num2){
        if (num1 < -32768 || num1 > 32767){
            throw new IllegalArgumentException("Error: Bilangan Pertama tidak berada pada rentang.");
        }
        if (num2 < -32768 || num2 > 32767){
            throw new IllegalArgumentException("Error: Bilangan Kedua tidak berada pada rentang.");
        }
    }

    public static void validasiOperator(char pilihan){
        if (pilihan != ('1') && pilihan != ('2') && pilihan != ('3') && pilihan !=('4')) {
            throw new IllegalArgumentException( "Error: operator tidak valid");
        }
    }

    public static void validasiPembagi(double num2, char pilihan) {
        if (pilihan == '4' && num2 == 0) {
            throw new IllegalArgumentException("Error: pembagi tidak boleh nol");
        }
    }
}