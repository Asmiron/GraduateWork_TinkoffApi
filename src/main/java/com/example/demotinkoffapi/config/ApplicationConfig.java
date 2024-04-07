package com.example.demotinkoffapi.config;

import org.springframework.context.annotation.Configuration;
import ru.tinkoff.piapi.contract.v1.Bond;
import ru.tinkoff.piapi.contract.v1.InstrumentStatus;
import ru.tinkoff.piapi.core.InvestApi;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Configuration
public class ApplicationConfig {
    public List<Bond> getBonds() throws ExecutionException, InterruptedException {
        String token = System.getenv("ssoToken");
        var api = InvestApi.create(token);
        return api.getInstrumentsService().getBonds(InstrumentStatus.INSTRUMENT_STATUS_BASE).get();
    }
}
