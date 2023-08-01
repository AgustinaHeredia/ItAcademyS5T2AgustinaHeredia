package com.juegoDadosAgustinaHeredia.ItAcademyS5T2AgustinaHeredia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.juegoDadosAgustinaHeredia.ItAcademyS5T2AgustinaHeredia.entity.Player;
import com.juegoDadosAgustinaHeredia.ItAcademyS5T2AgustinaHeredia.service.PlayerService;

import java.util.List;

@Controller
@RequestMapping("/game")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/index")
    public ModelAndView showHomePage() {
        return new ModelAndView("home");
    }

    @PostMapping("/players")
    public ModelAndView createPlayer(@ModelAttribute Player player) {
        playerService.createPlayer(player);
        ModelAndView modelAndView = new ModelAndView("created-successfully");
        modelAndView.addObject("player", player);
        return modelAndView;
    }

    @PutMapping("/players/{id}")
    public ResponseEntity<?> updatePlayer(@PathVariable Long id, @RequestParam String name) {
        playerService.updatePlayerName(id, name);
        return ResponseEntity.ok("Player updated successfully");
    }

    @PostMapping("/players/{id}/games")
    public ResponseEntity<?> playGame(@PathVariable Long id) {
        // Lógica para realizar el tirón de los dados por el jugador con el ID especificado
        return ResponseEntity.ok("Dice rolled successfully");
    }

    @DeleteMapping("/players/{id}/games")
    public ResponseEntity<?> deleteGames(@PathVariable Long id) {
        // Lógica para eliminar las tiradas del jugador con el ID especificado
        return ResponseEntity.ok("Player's games deleted successfully");
    }

    @GetMapping("/players")
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/players/{id}/games")
    public ResponseEntity<?> getPlayerGames(@PathVariable Long id) {
        // Lógica para obtener las jugadas del jugador con el ID especificado
        return ResponseEntity.ok("List of player's games");
    }

    @GetMapping("/players/ranking")
    public ResponseEntity<?> getRanking() {
        // Lógica para obtener el ranking medio de todos los jugadores
        return ResponseEntity.ok("Ranking of all players");
    }

    @GetMapping("/players/ranking/loser")
    public ResponseEntity<?> getLoser() {
        // Lógica para obtener al jugador con peor porcentaje de éxito
        return ResponseEntity.ok("Player with worst success rate");
    }

    @GetMapping("/players/ranking/winner")
    public ResponseEntity<?> getWinner() {
        // Lógica para obtener al jugador con mejor porcentaje de éxito
        return ResponseEntity.ok("Player with best success rate");
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<Player> getPlayer(@PathVariable Long id) {
        Player player = playerService.getPlayer(id);
        return ResponseEntity.ok(player);
    }

    @GetMapping("/create")
    public ModelAndView showCreatePlayerForm() {
        return new ModelAndView("create-player");
    }

    @GetMapping("/update-form/{id}")
    public ModelAndView showUpdatePlayerForm(@PathVariable Long id) {
        Player player = playerService.getPlayer(id);
        ModelAndView modelAndView = new ModelAndView("update-player");
        modelAndView.addObject("player", player);
        return modelAndView;
    }

    @GetMapping("/delete-form/{id}")
    public ModelAndView showDeletePlayerConfirmation(@PathVariable Long id) {
        Player player = playerService.getPlayer(id);
        ModelAndView modelAndView = new ModelAndView("delete-player");
        modelAndView.addObject("player", player);
        return modelAndView;
    }

    @GetMapping("/getOneForm/{id}")
    public ModelAndView showPlayerDetailsForm(@PathVariable Long id) {
        Player player = playerService.getPlayer(id);
        ModelAndView modelAndView = new ModelAndView("get-player");
        modelAndView.addObject("player", player);
        return modelAndView;
    }
}