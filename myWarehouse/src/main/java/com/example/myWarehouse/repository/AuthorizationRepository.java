package com.example.myWarehouse.repository;

import com.example.myWarehouse.entity.AuthorizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorizationRepository extends JpaRepository<AuthorizationEntity, Long> {
    Optional<AuthorizationEntity> findByLogin(String login);
}

