package com.juegoDadosAgustinaHeredia.ItAcademyS5T2AgustinaHeredia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juegoDadosAgustinaHeredia.ItAcademyS5T2AgustinaHeredia.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}