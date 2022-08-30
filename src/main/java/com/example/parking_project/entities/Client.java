package com.example.parking_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "client")
@Data
public class Client {

    @Id
    @Column(name = "client_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(name = "client_name", nullable = false)
    private String clientName;

    @Column(name = "car_state_number")
    private String carNumber;

    @Column(name = "car_mark")
    private String carMark;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clientId", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Contract> client_contracts;

}
