package com.smn.cconverter.dto.validation.impl;

import com.smn.cconverter.config.AppConfig;
import com.smn.cconverter.dto.validation.Currency;
import com.smn.cconverter.service.CurrencyService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static com.smn.cconverter.config.AppConfig.BASE_CURRENCY;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyValidator implements ConstraintValidator<Currency, String> {

    @Autowired
    private CurrencyService currencyService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return currencyService != null && currencyService.getAllCurrencies(BASE_CURRENCY).contains(value);
    }
}

