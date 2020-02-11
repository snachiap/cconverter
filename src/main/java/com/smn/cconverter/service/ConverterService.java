package com.smn.cconverter.service;

import com.smn.cconverter.dto.ConvertRequest;
import com.smn.cconverter.dto.ConvertResponse;
import com.smn.cconverter.exception.ExchangeRatesConversionException;

public interface ConverterService {

    ConvertResponse convert(final ConvertRequest request) throws ExchangeRatesConversionException;
}
