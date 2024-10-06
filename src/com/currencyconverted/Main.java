package com.currencyconverted;

import com.currencyconverted.api.ExchangeRateClient;
import com.currencyconverted.utils.CurrencyApi;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
ARS - Peso argentino

BOB - Boliviano boliviano

BRL - Real brasileño

CLP - Peso chileno

COP - Peso colombiano

USD - Dólar estadounidense
*/

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        CurrencyApi currencyApi = ExchangeRateClient
                .getDynamicExchange(
                        "USD",
                        "CRC",
                        5000);
        System.out.println("currencyApi = " + currencyApi);

        Map<String, Double> rates = ExchangeRateClient.getCurrencyExchange().conversion_rates();

        // Definir la lista de monedas que queremos filtrar
        List<String> filteredCurrencies = Arrays.asList("ARS", "BOB", "BRL", "CLP", "COP", "USD");

        // Crear un nuevo Map para almacenar solo las conversiones filtradas
        Map<String, Double> filteredRates = new HashMap<>();

        // Filtrar las tasas de cambio
        for (String currency : filteredCurrencies) {
            if (rates.containsKey(currency)) {
                filteredRates.put(currency, rates.get(currency));
            }
        }

        filteredRates.forEach((currency, rate) -> {
            System.out.println(currency + ": " + rate);
        });

    }
}
