package com.juegoDadosAgustinaHeredia.ItAcademyS5T2AgustinaHeredia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juegoDadosAgustinaHeredia.ItAcademyS5T2AgustinaHeredia.entity.Game;


@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}