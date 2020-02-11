package com.smn.cconverter.client;

import com.smn.cconverter.dto.ExchangeRateResponse;
import feign.Param;
import feign.RequestLine;

public interface ExchangeRateClient {

    @RequestLine("GET /?base={baseCurrency}")
    ExchangeRateResponse getExchangeRates(@Param("baseCurrency") String baseCurrency);
}
