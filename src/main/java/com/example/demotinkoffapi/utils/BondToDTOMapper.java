package com.example.demotinkoffapi.utils;

import com.example.demotinkoffapi.model.BondDTO;
import ru.tinkoff.piapi.contract.v1.Bond;

import java.time.Instant;
import java.time.ZoneOffset;

public class BondToDTOMapper {

    public static BondDTO map(Bond bond){
        BondDTO bondDTO = new BondDTO();
        bondDTO.setCountry_of_risk_name(bond.getCountryOfRiskName());
        bondDTO.setName(bond.getName());
        bondDTO.setFigi(bond.getFigi());
        bondDTO.setTicker(bond.getTicker());
        bondDTO.setCurrency(bond.getCurrency());
        bondDTO.setNominal_price(bond.getNominal().getUnits());
        bondDTO.setMaturity_date(Instant.ofEpochSecond(bond.getMaturityDate().getSeconds(), bond.getMaturityDate().getNanos())
                .atOffset(ZoneOffset.UTC).toLocalDate());
        return bondDTO;
    }
}
