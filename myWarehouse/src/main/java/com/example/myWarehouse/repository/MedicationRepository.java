package com.example.myWarehouse.repository;

import com.example.myWarehouse.entity.MedicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationRepository extends JpaRepository<MedicationEntity, Long> {
    List<MedicationEntity> findByRecipeContaining(String recipe);
    List<MedicationEntity> findByRecipeIsNull();
}

