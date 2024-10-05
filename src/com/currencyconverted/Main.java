package com.currencyconverted;

import com.currencyconverted.api.ExchangeRateClient;
import com.currencyconverted.utils.CurrencyApi;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        CurrencyApi currencyApi = ExchangeRateClient
                .getConvertedAmount(
                        "CRC",
                        "USD",
                        5000);

        System.out.println("currencyApi = " + currencyApi);
    }
}
