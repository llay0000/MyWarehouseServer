package com.example.myWarehouse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "medication")
@Getter
@Setter
public class MedicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "dateReceipt")
    private LocalDate dateReceipt;

    @Column(name = "dateManufacture")
    private LocalDate dateManufacture;

    @Column(name = "expirationDate")
    private LocalDate expirationDate;

    @Column(name = "prices")
    private double prices;

    @Column(name = "remains")
    private int remains;

    @Column(name = "recipe")
    private String recipe;

    @ManyToOne
    @JoinColumn(name = "annotation_id")
    private AnnotationEntity annotation;

    @ManyToOne
    @JoinColumn(name = "storageLocation_id")
    private StorageLocationEntity storageLocation;

    @ManyToOne
    @JoinColumn(name = "manufacturerCompany_id")
    private ManufacturerCompanyEntity manufacturerCompany;
}

