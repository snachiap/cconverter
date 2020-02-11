package com.smn.cconverter.service.impl;

import com.smn.cconverter.client.ExchangeRateClient;
import com.smn.cconverter.dto.ExchangeRateResponse;
import com.smn.cconverter.exception.ExchangeRatesFetchException;
import com.smn.cconverter.service.CurrencyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.smn.cconverter.config.AppConfig.*;

@Service
@AllArgsConstructor
@Slf4j
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private ExchangeRateClient exchangeRateClient;

    @Cacheable(EXCHANGE_RATES_CACHE)
    public ExchangeRateResponse getExchangeRates(final String baseCurrency) throws ExchangeRatesFetchException {
        try {
            return exchangeRateClient.getExchangeRates(baseCurrency);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ExchangeRatesFetchException("Fetch Exchange Rates failed. Reason: " + e.getMessage());
        }
    }

    @Cacheable(VALID_CURRENCIES_CACHE)
    public Set<String> getAllCurrencies(final String baseCurrency) {
        try {
            ExchangeRateResponse res = exchangeRateClient.getExchangeRates(baseCurrency);
            Set<String> set = new HashSet<>();
            set.addAll(res.getRates().keySet());
            set.add(baseCurrency);
            return set;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ExchangeRatesFetchException("Fetch Exchange Rates failed. Reason: " + e.getMessage());
        }
    }
}
