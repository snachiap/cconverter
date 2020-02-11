package com.smn.cconverter.exception;

public class ExchangeRatesFetchException extends RuntimeException {
    public ExchangeRatesFetchException() {
    }

    public ExchangeRatesFetchException(String message) {
        super(message);
    }
}
