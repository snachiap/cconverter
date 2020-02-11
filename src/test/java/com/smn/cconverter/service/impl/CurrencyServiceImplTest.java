package com.smn.cconverter.service.impl;

import com.smn.cconverter.client.ExchangeRateClient;
import com.smn.cconverter.dto.ExchangeRateResponse;
import com.smn.cconverter.exception.ExchangeRatesFetchException;
import com.smn.cconverter.service.CurrencyService;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CurrencyServiceImplTest {

    private ExchangeRateClient client = Mockito.mock(ExchangeRateClient.class);

    private CurrencyService currencyService = new CurrencyServiceImpl(client);

    @Test
    void getExchangeRates() {
        ExchangeRateResponse res = new ExchangeRateResponse(new HashMap<>(), "EUR", new Date());

        when(client.getExchangeRates("EUR")).thenReturn(res);

        assertEquals(res, currencyService.getExchangeRates("EUR"));
    }


    @Test
    void getExchangeRates_Exception() {
        when(client.getExchangeRates("EUR")).thenThrow(new RuntimeException());

        assertThrows(ExchangeRatesFetchException.class, () -> currencyService.getExchangeRates("EUR"));
    }


    @Test
    void getAllCurrencies() {
        ExchangeRateResponse res = new ExchangeRateResponse(new HashMap<>(), "EUR", new Date());

        when(client.getExchangeRates("EUR")).thenReturn(res);

        Set<String> set = new HashSet<>();
        set.add("EUR");

        assertEquals(set, currencyService.getAllCurrencies("EUR"));
    }


    @Test
    void getAllCurrencies_Exception() {
        when(client.getExchangeRates("EUR")).thenThrow(new RuntimeException());

        assertThrows(ExchangeRatesFetchException.class, () -> currencyService.getAllCurrencies("EUR"));
    }

}