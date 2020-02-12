package com.smn.cconverter.resource;

import com.smn.cconverter.dto.ConvertRequest;
import com.smn.cconverter.dto.ConvertResponse;
import com.smn.cconverter.service.ConverterService;
import com.smn.cconverter.service.CurrencyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
class CurrencyControllerTest {

    @InjectMocks
    private CurrencyController currencyController;

    @Mock
    private ConverterService converterService;

    @Mock
    private CurrencyService currencyService;

    @Test
    void convert() {
        ConvertRequest req = new ConvertRequest("EUR", "USD", 2.0f);

        when(converterService.convert(req)).thenReturn(new ConvertResponse(2.1f));
        ResponseEntity<ConvertResponse> res = currencyController.convert(req);


        assertEquals(200, res.getStatusCode().value());
        assertEquals(2.1f, Optional.ofNullable(res.getBody()).map(ConvertResponse::getValue).orElseGet(() -> 0f));
    }

    @Test
    void get() {
        Set<String> currencies = new HashSet<>();
        currencies.add("USD");
        currencies.add("EUR");

        when(currencyService.getAllCurrencies("EUR")).thenReturn(currencies);
        ResponseEntity<Set<String>> res = currencyController.getAll();

        assertEquals(2, Optional.ofNullable(res.getBody()).map(Set::size).orElse(0));
        assertEquals(currencies, Optional.ofNullable(res.getBody()).orElseGet(null));
    }
}