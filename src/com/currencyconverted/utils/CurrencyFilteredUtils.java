package com.currencyconverted.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyFilteredUtils {

    // Private constructor to prevent instantiation
    private CurrencyFilteredUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    // Method to filter currency rates based on a predefined list of currencies
    public static Map<String, Double> getFilteredRates(Map<String, Double> rates) {
        // Define the list of currencies we want to filter
        List<String> filteredCurrencies = Arrays.asList("ARS", "BOB", "BRL", "CLP", "COP", "USD");

        // Create a new Map to store only the filtered conversions
        Map<String, Double> filteredRates = new HashMap<>();

        // Filter the exchange rates based on the predefined currency list
        for (String currency : filteredCurrencies) {
            if (rates.containsKey(currency)) {
                filteredRates.put(currency, rates.get(currency));
            }
        }

        return filteredRates;
    }

}
