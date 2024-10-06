package com.currencyconverted.api;

import com.currencyconverted.utils.ConversionRates;
import com.currencyconverted.utils.CurrencyApi;
import com.currencyconverted.utils.GsonUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateClient {

    // Gson instance for JSON deserialization
    static Gson gson = GsonUtils.getGson();

    // API key for ExchangeRate-API
    static String apiKey = "91a5c353dae5ed7aaef0e248";

    // Private constructor to prevent instantiation of utility class
    private ExchangeRateClient() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    // Retrieves dynamic exchange rate data for a specific amount between two currencies
    public static CurrencyApi getDynamicExchange(String fromCurrency, String toCurrency, double amount) {

        // Validates input data
        validateDynamicData(fromCurrency, toCurrency, amount);

        // Builds URL to call the API with dynamic parameters
        String url = buildDynamicUrl(apiKey, fromCurrency, toCurrency, amount);

        // Fetches the data from the API
        String json = fetchData(url);

        // Deserializes the JSON response into CurrencyApi object
        CurrencyApi currencyApi = gson.fromJson(json, CurrencyApi.class);

        return currencyApi;
    }

    // Retrieves static exchange rate data for all currencies relative to USD
    public static ConversionRates getCurrencyExchange()
            throws IOException, InterruptedException {

        // Builds the URL to get latest exchange rates for USD
        String url = buildStaticUrl(apiKey);

        // Fetches the data from the API
        String json = fetchData(url);

        // Deserializes the JSON response into ConversionRates object
        ConversionRates conversionRates = gson.fromJson(json, ConversionRates.class);

        return conversionRates;
    }

    // Builds a URL for the static exchange rate request (USD as base currency)
    private static String buildStaticUrl(String apiKey) {
        return String.format("https://v6.exchangerate-api.com/v6/%s/latest/USD", apiKey);
    }

    // Builds a dynamic URL for pair conversion request between two currencies and a specified amount
    private static String buildDynamicUrl(String apiKey, String fromCurrency, String toCurrency, double amount) {
        return String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%.2f",
                apiKey, fromCurrency, toCurrency, amount);
    }

    // Validates the input data for dynamic exchange rate requests
    private static void validateDynamicData(String fromCurrency, String toCurrency, double amount) {
        // Check if the currency codes are not null or empty
        if (fromCurrency == null || fromCurrency.isEmpty() || toCurrency == null || toCurrency.isEmpty()) {
            throw new IllegalArgumentException("Currency data cannot be null or empty");
        }

        // Check if the amount is greater than zero
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }

    // Sends the HTTP request to the given URL and returns the response body as a string
    private static String fetchData(String url) {
        try {
            // Create a new HttpClient instance
            HttpClient client = java.net.http.HttpClient.newHttpClient();

            // Create a GET request with the given URL
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            // Send the request and retrieve the response body
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (IOException | InterruptedException e) {
            // If an error occurs, throw a runtime exception
            throw new RuntimeException(e);
        }
    }
}

