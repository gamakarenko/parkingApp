package com.example.parking_project.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "parking_space")
@Data
public class ParkingSpace {

    @Id
    @Column(name = "parking_space_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ParkingSpaceId;

    @Column(name = "square")
    private int square;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;
}