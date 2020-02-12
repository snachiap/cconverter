package com.smn.cconverter.config;

import io.github.sercasti.tracing.config.TracingConfig;
import io.github.sercasti.tracing.core.Tracing;
import io.github.sercasti.tracing.filter.TracingFilter;
import io.github.sercasti.tracing.interceptor.TracingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    public final static String EXCHANGE_RATES_CACHE = "ratesCache";
    public final static String VALID_CURRENCIES_CACHE = "currencies";
    public final static String BASE_CURRENCY = "EUR";

    @Bean
    protected Tracing tracing() {
        return TracingConfig.createTracing();
    }

    @Bean
    protected TracingFilter tracingFilter() {
        return new TracingFilter();
    }

    @Bean
    protected TracingInterceptor tracingInterceptor() {
        return new TracingInterceptor(tracing());
    }

}
