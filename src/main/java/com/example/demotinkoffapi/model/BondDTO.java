package com.example.demotinkoffapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Value;

import java.sql.Timestamp;

@RequiredArgsConstructor
@Value
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BondDTO {
    String ticker;
    String figi;
    String nominal;
    String name;
    String currency;
    Timestamp maturity_date;

    @Override
    public String toString() {
        return "BondDTO{" +
                "ticker='" + ticker + '\'' +
                ", figi='" + figi + '\'' +
                ", nominal='" + nominal + '\'' +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                ", maturity_date=" + maturity_date +
                '}';
    }
}
