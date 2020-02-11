package com.smn.cconverter.service.impl;

import com.smn.cconverter.dto.ConvertRequest;
import com.smn.cconverter.dto.ConvertResponse;
import com.smn.cconverter.dto.ExchangeRateResponse;
import com.smn.cconverter.exception.ExchangeRatesConversionException;
import com.smn.cconverter.service.ConverterService;
import com.smn.cconverter.service.CurrencyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

class ConverterServiceImplTest {

    private CurrencyService currencyService = Mockito.mock(CurrencyServiceImpl.class);

    private ConverterService converterService = new ConverterServiceImpl(currencyService);

    @Test
    void convert() {
        ConvertRequest req = new ConvertRequest("EUR", "USD", 2.0f);

        Map<String, Float> map = new HashMap<>();
        map.put("USD", 1.5f);
        ExchangeRateResponse response = new ExchangeRateResponse(map, "EUR", new Date());


        when(currencyService.getExchangeRates("EUR")).thenReturn(response);

        ConvertResponse res = converterService.convert(req);

        assertEquals(3.0f, res.getValue());
    }


    @Test
    void convert_test2() {
        ConvertRequest req = new ConvertRequest("EUR", "EUR", 20);
        ConvertResponse res = converterService.convert(req);

        assertEquals(20.0, res.getValue());
    }


    @Test
    void convert_InvalidDestinationCurrency() {
        ConvertRequest req = new ConvertRequest("EUR", "INR", 2.0f);

        Map<String, Float> map = new HashMap<>();
        map.put("USD", 1.5f);
        ExchangeRateResponse response = new ExchangeRateResponse(map, "EUR", new Date());


        when(currencyService.getExchangeRates("EUR")).thenReturn(response);

        assertThrows(ExchangeRatesConversionException.class, () -> {
            converterService.convert(req);
        });
    }

}