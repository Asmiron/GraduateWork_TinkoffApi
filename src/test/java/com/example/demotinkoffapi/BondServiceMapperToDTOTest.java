package com.example.demotinkoffapi;

import com.example.demotinkoffapi.service.BondService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import ru.tinkoff.piapi.core.InvestApi;

import java.util.concurrent.ExecutionException;

@ExtendWith(MockitoExtension.class)
public class BondServiceMapperToDTOTest {

    @Spy
    InvestApi invApi = InvestApi.create(System.getenv("ssoToken"));

    @Spy
    ModelMapper modelMapper = new ModelMapper();
    @InjectMocks
    BondService bondService;


    @Test
    void BondServiceTest() throws ExecutionException, InterruptedException {
        System.out.println(bondService.getBondsDTO());

    }
}
