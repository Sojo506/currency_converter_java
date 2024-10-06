package com.currencyconverted;

import com.currencyconverted.api.ExchangeRateClient;
import com.currencyconverted.ui.Menu;
import com.currencyconverted.utils.CurrencyApi;
import com.currencyconverted.utils.CurrencyFilteredUtils;

import java.io.IOException;
import java.util.Map;

/*
ARS - Peso argentino

BOB - Boliviano boliviano

BRL - Real brasileño

CLP - Peso chileno

COP - Peso colombiano

USD - Dólar estadounidense

Dolar =>> Peso Argentino
Peso Argentino =>> Dolar
Dolar =>> Real Brasileño
Real Brasileño ==> Dolar
Dolar =>> Peso Colombiano
Peso Colombiano =>> Dolar
*/

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        /*CurrencyApi currencyApi = ExchangeRateClient
                .getDynamicExchange(
                        "USD",
                        "CRC",
                        5000);
        System.out.println("currencyApi = " + currencyApi);*/

        Map<String, Double> rates = ExchangeRateClient.getCurrencyExchange().conversion_rates();

        Map<String, Double> filteredRates = CurrencyFilteredUtils.getFilteredRates(rates);
        System.out.println("filteredRates = " + filteredRates);

        Menu.start(filteredRates);

    }
}
