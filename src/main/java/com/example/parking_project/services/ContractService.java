package com.example.parking_project.services;

import com.example.parking_project.entities.Contract;
import com.example.parking_project.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    private final ContractRepository contractRepository;

    @Autowired
    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public Contract findById(Long id){
        return contractRepository.findById(id).get();
    }

    public List<Contract> findAll(){
        return contractRepository.findAll();
    }

    public Contract saveContract(Contract contract){
        return contractRepository.save(contract);
    }

    public void deleteContract(Long id){
        contractRepository.deleteById(id);
    }
}
