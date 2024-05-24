package com.example.myWarehouse.service;

import com.example.myWarehouse.entity.AnnotationEntity;
import com.example.myWarehouse.repository.AnnotationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class AnnotationService {

    private final AnnotationRepository repository;

    public AnnotationEntity save(AnnotationEntity data) {
        return repository.save(data);
    }

    public List<AnnotationEntity> findAll(){
        return repository.findAll();
    }

    public void update (AnnotationEntity data){
        repository.save(data);
    }

    public void delete (Long id){
        repository.deleteById(id);
    }

    public AnnotationEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найдено"));
    }
}
