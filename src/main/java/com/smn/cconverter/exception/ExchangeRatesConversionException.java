package com.smn.cconverter.exception;

public class ExchangeRatesConversionException extends RuntimeException {
    public ExchangeRatesConversionException() {
    }

    public ExchangeRatesConversionException(String message) {
        super(message);
    }
}
