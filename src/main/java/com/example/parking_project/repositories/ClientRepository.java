package com.example.parking_project.repositories;

import com.example.parking_project.entities.Client;
import com.example.parking_project.entities.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
