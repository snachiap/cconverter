package com.smn.cconverter.resource;

import com.smn.cconverter.config.AppConfig;
import com.smn.cconverter.dto.ConvertRequest;
import com.smn.cconverter.dto.ConvertResponse;
import com.smn.cconverter.service.ConverterService;
import com.smn.cconverter.service.CurrencyService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

import static com.smn.cconverter.config.AppConfig.BASE_CURRENCY;

@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@RestController
@RequestMapping("currency")
public class CurrencyController {

    @Autowired
    private ConverterService converterService;

    @Autowired
    private CurrencyService currencyService;

    @PostMapping(path = "convert")
    public ResponseEntity<ConvertResponse> convert(@Valid @RequestBody ConvertRequest request) {
        return ResponseEntity.ok(converterService.convert(request));
    }

    @GetMapping
    public ResponseEntity<Set<String>> getAll() {
        return ResponseEntity.ok(currencyService.getAllCurrencies(BASE_CURRENCY));
    }
}
