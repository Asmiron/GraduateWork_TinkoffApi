package com.example.demotinkoffapi.controller;

import com.example.demotinkoffapi.model.BondDTO;
import com.example.demotinkoffapi.service.BondService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
public class BondsController {

    private final BondService bondService;

    @GetMapping("/bonds")
    public List<BondDTO> getBonds() throws ExecutionException, InterruptedException {
        return bondService.getBondsDTO();
    }
}
