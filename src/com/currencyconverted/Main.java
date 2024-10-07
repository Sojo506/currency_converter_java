package com.currencyconverted;

import com.currencyconverted.api.ExchangeRateClient;
import com.currencyconverted.ui.Menu;

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
        Map<String, Double> rates = ExchangeRateClient.getCurrencyExchange().conversion_rates();

//        just in case I want to have some of them
//        Map<String, Double> filteredRates = CurrencyFilteredUtils.getFilteredRates(rates);

        Menu menu = new Menu(rates);
        menu.start();

    }
}
