package com.example.myWarehouse.service;

import com.example.myWarehouse.entity.StorageLocationEntity;
import com.example.myWarehouse.repository.StorageLocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StorageLocationService {

    private final StorageLocationRepository repository;

    public StorageLocationEntity save(StorageLocationEntity data) {
        return repository.save(data);
    }

    public List<StorageLocationEntity> findAll(){
        return repository.findAll();
    }

    public void update (StorageLocationEntity data){
        repository.save(data);
    }

    public void delete (Long id){
        repository.deleteById(id);
    }

    public StorageLocationEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найдено"));
    }
}
