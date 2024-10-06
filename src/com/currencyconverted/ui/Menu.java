package com.currencyconverted.ui;

import com.currencyconverted.utils.ExchangeConverter;

import java.util.Map;
import java.util.Scanner;

public class Menu {
    public static void start(Map<String, Double> rates) {
        Scanner scanner = new Scanner(System.in);
        int option;
        int amount;
        double convertedCurrency;
        String fromCurrency;
        String toCurrency;

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
                    fromCurrency = "USD";
                    toCurrency = "ARS";

                    System.out.print("Enter the value you want to convert: ");
                    amount = scanner.nextInt();
                    convertedCurrency = ExchangeConverter.convertCurrency(rates, fromCurrency, toCurrency, amount);
                    break;
                case 2:
                    // Call conversion function from ARS to USD
                    fromCurrency = "ARS";
                    toCurrency = "USD";

                    System.out.print("Enter the value you want to convert: ");
                    amount = scanner.nextInt();
                    convertedCurrency = ExchangeConverter.convertCurrency(rates, fromCurrency, toCurrency, amount);
                    break;
                case 3:
                    // Call conversion function from USD to BRL
                    fromCurrency = "USD";
                    toCurrency = "BRL";

                    System.out.print("Enter the value you want to convert: ");
                    amount = scanner.nextInt();
                    convertedCurrency = ExchangeConverter.convertCurrency(rates, fromCurrency, toCurrency, amount);
                    break;
                case 4:
                    // Call conversion function from BRL to USD
                    fromCurrency = "BRL";
                    toCurrency = "USD";

                    System.out.print("Enter the value you want to convert: ");
                    amount = scanner.nextInt();
                    convertedCurrency = ExchangeConverter.convertCurrency(rates, fromCurrency, toCurrency, amount);
                    break;
                case 5:
                    // Call conversion function from USD to COP
                    fromCurrency = "USD";
                    toCurrency = "COP";

                    System.out.print("Enter the value you want to convert: ");
                    amount = scanner.nextInt();
                    convertedCurrency = ExchangeConverter.convertCurrency(rates, fromCurrency, toCurrency, amount);
                    break;
                case 6:
                    // Call conversion function from COP to USD
                    fromCurrency = "COP";
                    toCurrency = "USD";

                    System.out.print("Enter the value you want to convert: ");
                    amount = scanner.nextInt();
                    convertedCurrency = ExchangeConverter.convertCurrency(rates, fromCurrency, toCurrency, amount);
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
