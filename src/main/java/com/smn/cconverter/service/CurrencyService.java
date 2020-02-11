package com.smn.cconverter.service;

import com.smn.cconverter.dto.ExchangeRateResponse;
import com.smn.cconverter.exception.ExchangeRatesFetchException;

import java.util.Set;

public interface CurrencyService {

    ExchangeRateResponse getExchangeRates(final String baseCurrency) throws ExchangeRatesFetchException;

    Set<String> getAllCurrencies(final String baseCurrency);
}
