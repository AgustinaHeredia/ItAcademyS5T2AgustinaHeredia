package com.juegoDadosAgustinaHeredia.ItAcademyS5T2AgustinaHeredia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.juegoDadosAgustinaHeredia.ItAcademyS5T2AgustinaHeredia.entity.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT p FROM Player p ORDER BY p.winPercentage ASC NULLS FIRST")
    Player findPlayerWithLowestWinPercentage();

    @Query("SELECT p FROM Player p ORDER BY p.winPercentage DESC NULLS LAST")
    Player findPlayerWithHighestWinPercentage();
}