package com.currencyconverted.ui;

import java.util.Map;
import java.util.Scanner;

public class Menu {
    public static void start(Map<String, Double> rates) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("=============================================");
            System.out.println("|         Currency Exchange Converter       |");
            System.out.println("=============================================");
            System.out.println("1) USD to ARS  (Dollar to Argentine Peso)");
            System.out.println("2) ARS to USD  (Argentine Peso to Dollar)");
            System.out.println("3) USD to BRL  (Dollar to Brazilian Real)");
            System.out.println("4) BRL to USD  (Brazilian Real to Dollar)");
            System.out.println("5) USD to COP  (Dollar to Colombian Peso)");
            System.out.println("6) COP to USD  (Colombian Peso to Dollar)");
            System.out.println("7) Exit");
            System.out.println("---------------------------------------------");
            System.out.print("Please select an option (1-7): ");

            option = scanner.nextInt();

            // Aquí se llamaría a las funciones de conversión según la opción seleccionada
            switch (option) {
                case 1:
                    // Call conversion function from USD to ARS
                    break;
                case 2:
                    // Call conversion function from ARS to USD
                    break;
                case 3:
                    // Call conversion function from USD to BRL
                    break;
                case 4:
                    // Call conversion function from BRL to USD
                    break;
                case 5:
                    // Call conversion function from USD to COP
                    break;
                case 6:
                    // Call conversion function from COP to USD
                    break;
                case 7:
                    System.out.println("Exiting the converter. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 7);

        scanner.close();
    }
}
