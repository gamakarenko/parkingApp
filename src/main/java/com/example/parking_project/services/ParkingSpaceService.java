package com.example.parking_project.services;

import com.example.parking_project.entities.ParkingSpace;
import com.example.parking_project.repositories.ParkingSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpaceService {
    private final ParkingSpaceRepository parkingSpaceRepository;

    @Autowired
    public ParkingSpaceService(ParkingSpaceRepository parkingSpaceRepository) {
        this.parkingSpaceRepository = parkingSpaceRepository;
    }

    public ParkingSpace findById(Long id){
        return parkingSpaceRepository.findById(id).get();
    }

    public List<ParkingSpace> findAll(){
        return parkingSpaceRepository.findAll();
    }

    public ParkingSpace saveParking(ParkingSpace parkingSpace){
        return parkingSpaceRepository.save(parkingSpace);
    }

    public void deleteParking(Long id){
        parkingSpaceRepository.deleteById(id);
    }
}
