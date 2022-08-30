package com.example.parking_project.repositories;

import com.example.parking_project.entities.Contract;
import com.example.parking_project.entities.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
