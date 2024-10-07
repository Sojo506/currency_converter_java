package com.currencyconverted.ui;

import com.currencyconverted.utils.ExchangeConverter;

import java.util.*;

public class Menu {
    public static void start(Map<String, Double> rates) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        int amount;
        double convertedCurrency;
        String fromCurrency;
        String toCurrency;
        List<String> conversionHistory = new ArrayList<>();

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
            System.out.println("7) Custom Conversion (Choose your own currencies)");
            System.out.println("8) Show history of conversions");
            System.out.println("9) Exit");
            System.out.println("---------------------------------------------");
            System.out.print("Please select an option (1-9): ");

            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Enter only numbers please!");
                scanner.nextLine();
            }

            // Aquí se llamaría a las funciones de conversión según la opción seleccionada
            switch (option) {
                case 1:
                    // Call conversion function from USD to ARS
                    fromCurrency = "USD";
                    toCurrency = "ARS";

                    System.out.print("Enter the value you want to convert: ");
                    amount = scanner.nextInt();
                    convertedCurrency = ExchangeConverter.convertCurrency(rates, fromCurrency, toCurrency, amount);
                    conversionHistory.add(fromCurrency + " to " + toCurrency + ": " + amount + " " + fromCurrency + " = " + convertedCurrency + " " + toCurrency);
                    break;
                case 2:
                    // Call conversion function from ARS to USD
                    fromCurrency = "ARS";
                    toCurrency = "USD";

                    System.out.print("Enter the value you want to convert: ");
                    amount = scanner.nextInt();
                    convertedCurrency = ExchangeConverter.convertCurrency(rates, fromCurrency, toCurrency, amount);
                    conversionHistory.add(fromCurrency + " to " + toCurrency + ": " + amount + " " + fromCurrency + " = " + convertedCurrency + " " + toCurrency);
                    break;
                case 3:
                    // Call conversion function from USD to BRL
                    fromCurrency = "USD";
                    toCurrency = "BRL";

                    System.out.print("Enter the value you want to convert: ");
                    amount = scanner.nextInt();
                    convertedCurrency = ExchangeConverter.convertCurrency(rates, fromCurrency, toCurrency, amount);
                    conversionHistory.add(fromCurrency + " to " + toCurrency + ": " + amount + " " + fromCurrency + " = " + convertedCurrency + " " + toCurrency);
                    break;
                case 4:
                    // Call conversion function from BRL to USD
                    fromCurrency = "BRL";
                    toCurrency = "USD";

                    System.out.print("Enter the value you want to convert: ");
                    amount = scanner.nextInt();
                    convertedCurrency = ExchangeConverter.convertCurrency(rates, fromCurrency, toCurrency, amount);
                    conversionHistory.add(fromCurrency + " to " + toCurrency + ": " + amount + " " + fromCurrency + " = " + convertedCurrency + " " + toCurrency);
                    break;
                case 5:
                    // Call conversion function from USD to COP
                    fromCurrency = "USD";
                    toCurrency = "COP";

                    System.out.print("Enter the value you want to convert: ");
                    amount = scanner.nextInt();
                    convertedCurrency = ExchangeConverter.convertCurrency(rates, fromCurrency, toCurrency, amount);
                    conversionHistory.add(fromCurrency + " to " + toCurrency + ": " + amount + " " + fromCurrency + " = " + convertedCurrency + " " + toCurrency);
                    break;
                case 6:
                    // Call conversion function from COP to USD
                    fromCurrency = "COP";
                    toCurrency = "USD";

                    System.out.print("Enter the value you want to convert: ");
                    amount = scanner.nextInt();
                    convertedCurrency = ExchangeConverter.convertCurrency(rates, fromCurrency, toCurrency, amount);
                    conversionHistory.add(fromCurrency + " to " + toCurrency + ": " + amount + " " + fromCurrency + " = " + convertedCurrency + " " + toCurrency);
                    break;
                case 7:
                    // Call conversion function from selected to selected currency
                    scanner.nextLine(); // to clean the buffer

                    System.out.print("Enter the currency you want to convert from (e.g. USD, CRC): ");
                    fromCurrency = scanner.nextLine().toUpperCase();
                    System.out.print("Enter the currency you want to convert to (e.g. CRC, COP): ");
                    toCurrency = scanner.nextLine().toUpperCase();

                    System.out.print("Enter the value you want to convert: ");
                    amount = scanner.nextInt();

                    try {
                        convertedCurrency = ExchangeConverter.convertCurrency(rates, fromCurrency, toCurrency, amount);
                        conversionHistory.add(fromCurrency + " to " + toCurrency + ": " + amount + " " + fromCurrency + " = " + convertedCurrency + " " + toCurrency);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 8:
                    if (conversionHistory.isEmpty()) {
                        System.out.println("No conversions have been made yet.");
                    } else {
                        System.out.println("Conversion History:");
                        for (String record : conversionHistory) {
                            System.out.println(record);
                        }
                    }
                    break;
                case 9:
                    System.out.println("Exiting the converter. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 9);

        scanner.close();
    }
}
