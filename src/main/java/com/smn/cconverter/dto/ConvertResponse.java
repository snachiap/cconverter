package com.smn.cconverter.dto;

import lombok.*;
import lombok.experimental.Tolerate;

import java.util.Currency;
import java.util.Locale;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ConvertResponse {
    private float value;
}
