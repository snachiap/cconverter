package com.smn.cconverter.resource;

import com.smn.cconverter.dto.ConvertRequest;
import com.smn.cconverter.dto.ConvertResponse;
import com.smn.cconverter.service.ConverterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
class CurrencyControllerTest {

    @InjectMocks
    private CurrencyController currencyController;

    @Mock
    private ConverterService converterService;

    @Test
    void get() {
        ConvertRequest req = new ConvertRequest("EUR", "USD", 2.0f);

        when(converterService.convert(req)).thenReturn(new ConvertResponse(2.1f));
        ResponseEntity<ConvertResponse> res = currencyController.convert(req);


        assertEquals(200, res.getStatusCode().value());
        assertEquals(2.1f, Optional.ofNullable(res.getBody()).map(ConvertResponse::getValue).orElseGet(() -> 0f) );
    }
}