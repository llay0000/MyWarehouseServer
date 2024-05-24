package com.example.myWarehouse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "manufacturerCompany")
@Getter
@Setter
public class ManufacturerCompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "manufacturerCompany")
    private String manufacturerCompany;
}