package com.example.demotinkoffapi.service;

import com.example.demotinkoffapi.model.BondDTO;
import com.example.demotinkoffapi.utils.BondToDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tinkoff.piapi.contract.v1.InstrumentStatus;
import ru.tinkoff.piapi.core.InvestApi;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class BondService {

    private final InvestApi investApi;

    public List<BondDTO> getBondsDTO(){
        try {
            var bonds = investApi.getInstrumentsService().getBonds(InstrumentStatus.INSTRUMENT_STATUS_BASE).get().stream()
                    .filter(bond -> !bond.getFloatingCouponFlag() && bond.getBuyAvailableFlag())
                    .map(BondToDTOMapper::map)
                    .filter(bond -> bond.getMaturity_date().isAfter(LocalDate.now()))
                    .toList();
            getBondsCurrentPrice(bonds);
            return bonds.stream().filter(bond -> bond.getCurrent_price() != 0).toList();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

    public List<BondDTO> getSortedRiskFreeBonds(LocalDate terminal)  {
        return getBondsDTO().stream()
                .filter(bond -> bond.getMaturity_date().isBefore(terminal))
                .sorted((Comparator.comparing(BondDTO::getMaturity_date)))
                .toList();
    }

    public void getBondsCurrentPrice(List<BondDTO> bonds){
        try {
            var figis = bonds.stream().map(BondDTO::getFigi).toList();
            var lastPrices = investApi.getMarketDataService().getLastPrices(figis).get();
            for (int i = 0; i < lastPrices.size(); i++){
                var lastPrice = lastPrices.get(i).getPrice();
                bonds.get(i).setCurrent_price(lastPrice.getUnits()*10 + lastPrice.getNano()/100000000);
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }


}
