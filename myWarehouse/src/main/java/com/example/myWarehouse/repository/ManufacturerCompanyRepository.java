package com.example.myWarehouse.repository;

import com.example.myWarehouse.entity.ManufacturerCompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerCompanyRepository extends JpaRepository<ManufacturerCompanyEntity, Long> {
}
