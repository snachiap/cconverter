package com.smn.cconverter.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    public final static String EXCHANGE_RATES_CACHE = "ratesCache";
    public final static String VALID_CURRENCIES_CACHE = "currencies";
    public final static String BASE_CURRENCY = "EUR";

}
