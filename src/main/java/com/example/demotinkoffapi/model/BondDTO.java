package com.example.demotinkoffapi.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BondDTO {
    String country_of_risk_name;
    String ticker;
    String figi;
    Long nominal_price;

    Long current_price;
    String name;
    String currency;
    LocalDate maturity_date;

    @Override
    public String toString() {
        return "BondDTO{" +
                "country_of_risk_name='" + country_of_risk_name + '\'' +
                ", ticker='" + ticker + '\'' +
                ", figi='" + figi + '\'' +
                ", nominal_price=" + nominal_price +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                ", maturity_date=" + maturity_date +
                '}';
    }
}
