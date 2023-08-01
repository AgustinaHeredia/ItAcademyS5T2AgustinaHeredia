package com.juegoDadosAgustinaHeredia.ItAcademyS5T2AgustinaHeredia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juegoDadosAgustinaHeredia.ItAcademyS5T2AgustinaHeredia.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}