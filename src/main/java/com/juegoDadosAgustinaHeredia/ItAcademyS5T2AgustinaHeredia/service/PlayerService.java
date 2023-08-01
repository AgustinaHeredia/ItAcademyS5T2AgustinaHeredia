package com.juegoDadosAgustinaHeredia.ItAcademyS5T2AgustinaHeredia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juegoDadosAgustinaHeredia.ItAcademyS5T2AgustinaHeredia.entity.Game;
import com.juegoDadosAgustinaHeredia.ItAcademyS5T2AgustinaHeredia.entity.Player;
import com.juegoDadosAgustinaHeredia.ItAcademyS5T2AgustinaHeredia.repository.GameRepository;
import com.juegoDadosAgustinaHeredia.ItAcademyS5T2AgustinaHeredia.repository.PlayerRepository;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameRepository gameRepository;

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayerName(Long id, String name) {
        Player player = getPlayerById(id);
        player.setName(name);
        return playerRepository.save(player);
    }

    public void deletePlayer(Long id) {
        Player player = getPlayerById(id);
        playerRepository.delete(player);
    }
    
    public Game rollDice(Long playerId) {
        Player player = getPlayerById(playerId);
        int dice1Value = rollDice();
        int dice2Value = rollDice();
        boolean winStatus = calculateWinStatus(dice1Value, dice2Value);
        Game game = new Game(player, dice1Value, dice2Value, winStatus);
        gameRepository.save(game);
        return game;
    }

    public void deletePlayerGames(Long playerId) {
        Player player = getPlayerById(playerId);
        List<Game> games = player.getGames();
        gameRepository.deleteAll(games);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayer(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Player not found with id: " + id));
    }
    
    public List<Game> getPlayerGames(Long playerId) {
        Player player = getPlayerById(playerId);
        return player.getGames();
    }

    public double getPlayersRanking() {
        List<Player> players = playerRepository.findAll();
        double totalGames = players.stream().mapToInt(player -> player.getGames().size()).sum();
        double totalWins = players.stream().flatMap(player -> player.getGames().stream())
                .filter(Game::isWinStatus).count();
        return totalWins / totalGames * 100;
    }

    public Player getLoserPlayer() {
        return playerRepository.findPlayerWithLowestWinPercentage();
    }

    public Player getWinnerPlayer() {
        return playerRepository.findPlayerWithHighestWinPercentage();
    }

    private Player getPlayerById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Player not found with id: " + id));
    }

    private int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }

    private boolean calculateWinStatus(int dice1Value, int dice2Value) {
        return (dice1Value + dice2Value) == 7;
    }
}