package com.smn.cconverter.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ExchangeRateResponse implements Serializable {

    private Map<String, Float> rates;
    private String base;
    private Date date;

}
