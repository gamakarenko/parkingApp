package com.example.parking_project.controllers;

import com.example.parking_project.entities.Contract;
import com.example.parking_project.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/parking")
public class ContractController {

    private final ContractService contractService;

    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/contracts")
    public String findAll(Model model) {
        List<Contract> contracts = contractService.findAll();
        model.addAttribute("contracts", contracts);
        return "contracts/contracts-list";
    }

    @GetMapping("/contract-create")
    public String createClientForm(Contract contract){
        return "contracts/contracts-create";
    }

    @PostMapping("/contract-create")
    public String createClient(Contract contract){
        contractService.saveContract(contract);
        return "redirect:/parking/clients";
    }

    @GetMapping("/contract-delete/{contractId}")
    public String deleteContract(@PathVariable("contractId") Long id){
        contractService.deleteContract(id);
        return "redirect:/parking/clients";
    }
}
