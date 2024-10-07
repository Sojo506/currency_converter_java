package com.currencyconverted.ui;

import com.currencyconverted.services.ConversionService;
import com.currencyconverted.utils.InputHandler;

import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final ConversionService conversionService;
    private final InputHandler inputHandler;

    public Menu(Map<String, Double> rates) {
        this.conversionService = new ConversionService(rates);
        this.inputHandler = new InputHandler();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            showMenu();
            option = inputHandler.getUserOption(scanner);

            switch (option) {
                case 1:
                    conversionService.performConversion(scanner, "USD", "ARS");
                    break;
                case 2:
                    conversionService.performConversion(scanner, "ARS", "USD");
                    break;
                case 3:
                    conversionService.performConversion(scanner, "USD", "BRL");
                    break;
                case 4:
                    conversionService.performConversion(scanner, "BRL", "USD");
                    break;
                case 5:
                    conversionService.performConversion(scanner, "USD", "COP");
                    break;
                case 6:
                    conversionService.performConversion(scanner, "COP", "USD");
                    break;
                case 7:
                    conversionService.performCustomConversion(scanner);
                    break;
                case 8:
                    conversionService.showConversionHistory();
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

    // Displays the menu options
    private void showMenu() {
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
    }
}

