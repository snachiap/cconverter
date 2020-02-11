package com.smn.cconverter.service.impl;

import com.smn.cconverter.dto.ConvertRequest;
import com.smn.cconverter.dto.ConvertResponse;
import com.smn.cconverter.dto.ExchangeRateResponse;
import com.smn.cconverter.exception.ExchangeRatesConversionException;
import com.smn.cconverter.service.ConverterService;
import com.smn.cconverter.service.CurrencyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ConverterServiceImpl implements ConverterService {

    @Autowired
    private CurrencyService service;

    @Override
    public ConvertResponse convert(ConvertRequest request) {
        if (request.getBaseCurrency().equalsIgnoreCase(request.getDestCurrency()))
            return new ConvertResponse(request.getValue());

        ExchangeRateResponse res = service.getExchangeRates(request.getBaseCurrency());

        try {
            Optional<Float> rates = Optional.ofNullable(res.getRates().get(request.getDestCurrency()));

            Float conversionRate = rates
                    .orElseThrow(() -> new Exception("No Conversion rate available for the destination currency"));


            return new ConvertResponse(request.getValue() * conversionRate);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ExchangeRatesConversionException("Conversion failed. Reason: " + e.getMessage());
        }
    }
}
