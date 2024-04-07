package com.example.demotinkoffapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.tinkoff.piapi.contract.v1.InstrumentStatus;
import ru.tinkoff.piapi.core.InvestApi;

import java.lang.String;

import java.util.concurrent.ExecutionException;

public class TinkoffApiConnectionAndGettingBondsTest {

    @Test
    void BondsListIsEmpty() throws ExecutionException, InterruptedException {
        String token = System.getenv("ssoToken");
        var api = InvestApi.create(token);
        var order = api.getInstrumentsService().getBonds(InstrumentStatus.INSTRUMENT_STATUS_BASE);
        Assertions.assertFalse(order.get().isEmpty());
        System.out.println(order.get().get(1));
    }
}
