package com.example.myWarehouse.service;

import com.example.myWarehouse.entity.MedicationEntity;
import com.example.myWarehouse.repository.MedicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicationService {
    private final MedicationRepository repository;

    public List<MedicationEntity> findAllWithRecipe(String recipe) {
        return repository.findByRecipeContaining(recipe);
    }

    public List<MedicationEntity> findAllWithoutRecipe() {
        return repository.findByRecipeIsNull();
    }

    public MedicationEntity save(MedicationEntity data) {
        return repository.save(data);
    }

    public List<MedicationEntity> findAll() {
        return repository.findAll();
    }

    public void update(MedicationEntity data) {
        repository.save(data);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public MedicationEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найдено"));
    }
}




