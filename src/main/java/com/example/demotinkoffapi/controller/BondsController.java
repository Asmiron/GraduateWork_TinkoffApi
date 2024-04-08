package com.example.demotinkoffapi.controller;

import com.example.demotinkoffapi.model.BondDTO;
import com.example.demotinkoffapi.model.UsersData;
import com.example.demotinkoffapi.service.BondService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class BondsController {

    private final BondService bondService;

    @GetMapping("/bonds")
    public List<BondDTO> getBonds() {
        return bondService.getBondsDTO();
    }


    @PostMapping("/usersData")
    public List<BondDTO> userDataCalc(@ModelAttribute("usersData") UsersData usersData, Model model){
        System.out.println(model.getAttribute("usersData"));
        return bondService.getSortedRiskFreeBonds(usersData.getTerminal_date());
    }
}
