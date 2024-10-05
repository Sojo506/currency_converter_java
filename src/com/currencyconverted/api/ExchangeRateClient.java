package com.currencyconverted.api;

import com.currencyconverted.utils.CurrencyApi;
import com.currencyconverted.utils.GsonUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateClient {

    private ExchangeRateClient() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static CurrencyApi getConvertedAmount(String fromCurrency, String toCurrency, double amount)
            throws IOException, InterruptedException {
        Gson gson = GsonUtils.getGson();
        String apiKey = "91a5c353dae5ed7aaef0e248";

        // validations
        validateData(fromCurrency, toCurrency, amount);

        String url = buildUrl(apiKey, fromCurrency, toCurrency, amount);

        HttpClient client = java.net.http.HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        CurrencyApi currencyApi = gson.fromJson(json, CurrencyApi.class);
        return currencyApi;
    }

    private static String buildUrl(String apiKey, String fromCurrency, String toCurrency, double amount) {
        return String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%.2f",
                apiKey, fromCurrency, toCurrency, amount);
    }

    private static void validateData(String fromCurrency, String toCurrency, double amount) {
        if (fromCurrency == null ||
                fromCurrency.isEmpty()
                || toCurrency == null
                || toCurrency.isEmpty()) {
            throw new IllegalArgumentException("Currency data cannot be null or empty");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }


}
