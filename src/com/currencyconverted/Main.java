package com.currencyconverted;

import com.currencyconverted.api.ExchangeRateClient;
import com.currencyconverted.ui.Menu;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Map<String, Double> rates = ExchangeRateClient.getCurrencyExchange().conversion_rates();

        Menu menu = new Menu(rates);
        menu.start();
    }
}
