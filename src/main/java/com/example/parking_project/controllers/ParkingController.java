package com.example.parking_project.controllers;

import com.example.parking_project.entities.Contract;
import com.example.parking_project.entities.ParkingSpace;
import com.example.parking_project.services.ParkingSpaceService;
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
public class ParkingController {

    private final ParkingSpaceService parkingSpaceService;

    public ParkingController(ParkingSpaceService parkingSpaceService) {
        this.parkingSpaceService = parkingSpaceService;
    }

    @GetMapping("/spaces")
    public String allParkingSpaces(Model model){
        List<ParkingSpace> spaceList = parkingSpaceService.findAll();
        model.addAttribute("spaces", spaceList);
        return "parking/parking_spaces";
    }

    @GetMapping("/space-create")
    public String createSpace(ParkingSpace parkingSpace){
        return "parking/space-create";
    }

    @PostMapping("/space-create")
    public String createParkingSpace(ParkingSpace parkingSpace){
        parkingSpaceService.saveParking(parkingSpace);
        return "redirect:/parking/spaces";
    }

    @GetMapping("/space-delete/{ParkingSpaceId}")
    public String deleteParkingSpace(@PathVariable("ParkingSpaceId") Long id){
        parkingSpaceService.deleteParking(id);
        return "redirect:/parking/clients";
    }
}
