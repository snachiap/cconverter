package com.smn.cconverter.dto;

import com.smn.cconverter.dto.validation.Currency;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ConvertRequest {

    @NonNull
    @Currency(message = "Invalid Source Currency")
    private String baseCurrency;

    @NonNull
    @Currency(message = "Invalid Destination Currency")
    private String destCurrency;

    @Valid
    @DecimalMin(value = "0.01", message = "Amount should be greater than 0")
    private float value;

}
