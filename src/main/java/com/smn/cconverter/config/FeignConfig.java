package com.smn.cconverter.config;

import com.smn.cconverter.client.ExchangeRateClient;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FeignConfig {

    @Value("${exchangeRate.baseUrl}")
    private String exchangeRateUrl;

    @Bean
    public ExchangeRateClient createExchangeRateClient() {
        return Feign
                .builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logLevel(Logger.Level.FULL)
                .target(ExchangeRateClient.class, exchangeRateUrl);
    }


}
