package com.example.myWarehouse.service;

import com.example.myWarehouse.entity.AnnotationEntity;
import com.example.myWarehouse.entity.ManufacturerCompanyEntity;
import com.example.myWarehouse.repository.AnnotationRepository;
import com.example.myWarehouse.repository.ManufacturerCompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ManufacturerCompanyService {

    private final ManufacturerCompanyRepository repository;

    public ManufacturerCompanyEntity save(ManufacturerCompanyEntity data) {
        return repository.save(data);
    }

    public List<ManufacturerCompanyEntity> findAll(){
        return repository.findAll();
    }

    public void update (ManufacturerCompanyEntity data){
        repository.save(data);
    }

    public void delete (Long id){
        repository.deleteById(id);
    }

    public ManufacturerCompanyEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найдено"));
    }
}
