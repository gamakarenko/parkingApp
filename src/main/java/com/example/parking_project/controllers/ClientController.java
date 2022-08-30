package com.example.parking_project.controllers;

import com.example.parking_project.entities.Client;
import com.example.parking_project.entities.Contract;
import com.example.parking_project.services.ClientService;
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
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService, ContractService contractService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public String findAllClients(Model model){
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "clients/clients-list";
    }

    @GetMapping("/client-create")
    public String createClientForm(Client client){
        return "clients/clients-create";
    }

    @PostMapping("/client-create")
    public String createClient(Client client){
        clientService.saveClient(client);
        return "redirect:/parking/clients";
    }

    @GetMapping("/client-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        return "clients/clients-update";
    }

    @PostMapping("/client-update")
    public String updateUser(Client client){
        clientService.saveClient(client);
        return "redirect:/parking/clients";
    }

    @GetMapping("/client-delete/{clientId}")
    public String deleteClient(@PathVariable("clientId") Long id){
        clientService.deleteClient(id);
        return "redirect:/parking/clients";
    }
}
