package com.currencyconverted.utils;

import java.util.Map;

public class ExchangeConverter {

    // Private constructor to prevent instantiation of utility class
    private ExchangeConverter() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static double convertCurrency(Map<String, Double> rates, String fromCurrency, String toCurrency, double amount) {
        // Check if both currencies exist in the rates map
        if (!rates.containsKey(fromCurrency) || !rates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Currency not supported");
        }

        double fromRate = rates.get(fromCurrency);
        double toRate = rates.get(toCurrency);

        // Convert the amount to USD first (assuming rates are relative to USD) and then to the target currency
        double amountInUsd = amount / fromRate;  // Convert from source currency to USD
        double convertedAmount = (amountInUsd * toRate);  // Convert from USD to target currency

        System.out.println(String.format("The value of %.2f [%s] corresponds to the final value of =>> %.2f [%s]\n",
                amount, fromCurrency, convertedAmount, toCurrency));

        return convertedAmount;
    }
}
