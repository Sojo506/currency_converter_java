package com.currencyconverted.services;

import com.currencyconverted.utils.ExchangeConverter;
import com.currencyconverted.utils.InputHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConversionService {
    private final Map<String, Double> rates;
    private final List<String> conversionHistory;

    public ConversionService(Map<String, Double> rates) {
        this.rates = rates;
        this.conversionHistory = new ArrayList<>();
    }

    // Performs a conversion between two fixed currencies
    public void performConversion(Scanner scanner, String fromCurrency, String toCurrency) {
        int amount = InputHandler.getAmount(scanner);
        double convertedCurrency = ExchangeConverter.convertCurrency(rates, fromCurrency, toCurrency, amount);
        String record = fromCurrency + " to " + toCurrency + ": " + amount + " " + fromCurrency + " = " + convertedCurrency + " " + toCurrency;
        System.out.println("Converted amount: " + convertedCurrency);
        conversionHistory.add(record);
    }

    // Allows a custom conversion between any two currencies chosen by the user
    public void performCustomConversion(Scanner scanner) {
        scanner.nextLine();  // Clears the buffer
        System.out.print("Enter the currency you want to convert from (e.g. USD, CRC): ");
        String fromCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the currency you want to convert to (e.g. CRC, COP): ");
        String toCurrency = scanner.nextLine().toUpperCase();

        int amount = InputHandler.getAmount(scanner);

        try {
            double convertedCurrency = ExchangeConverter.convertCurrency(rates, fromCurrency, toCurrency, amount);
            String record = fromCurrency + " to " + toCurrency + ": " + amount + " " + fromCurrency + " = " + convertedCurrency + " " + toCurrency;
            System.out.println("Converted amount: " + convertedCurrency);
            conversionHistory.add(record);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Displays the history of all conversions
    public void showConversionHistory() {
        if (conversionHistory.isEmpty()) {
            System.out.println("No conversions have been made yet.");
        } else {
            System.out.println("Conversion History:");
            for (String record : conversionHistory) {
                System.out.println(record);
            }
        }
    }
}
