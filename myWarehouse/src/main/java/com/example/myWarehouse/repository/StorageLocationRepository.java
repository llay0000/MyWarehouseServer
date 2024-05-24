package com.example.myWarehouse.repository;

import com.example.myWarehouse.entity.StorageLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageLocationRepository extends JpaRepository<StorageLocationEntity, Long> {
}
