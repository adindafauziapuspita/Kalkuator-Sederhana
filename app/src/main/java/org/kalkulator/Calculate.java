package org.kalkulator;

public class Calculate {

    // Method untuk memilih operator berdasarkan input pilihan
    public static double calculate(char pilihan, double num1, double num2) {
        switch (pilihan) {
            case '1':
                return tambah(num1, num2);
            case '2':
                return kurang(num1, num2);
            case '3':
                 return kali(num1, num2);
            case '4':
                return bagi(num1, num2);
            default:
            return Double.NaN; 
        }
    }

    private static double tambah(double num1, double num2) {
        return num1 + num2;
    }

    private static double kurang(double num1, double num2) {
        return num1 - num2;
    }

    private static double kali(double num1, double num2) {
        return num1 * num2;
    }

    private static double bagi(double num1, double num2) {
        return num1 / num2;
    }
}