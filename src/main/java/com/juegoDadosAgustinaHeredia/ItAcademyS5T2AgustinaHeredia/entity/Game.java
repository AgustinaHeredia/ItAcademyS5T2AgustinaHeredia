package com.juegoDadosAgustinaHeredia.ItAcademyS5T2AgustinaHeredia.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    private int dice1Value;
    private int dice2Value;
    private boolean winStatus;

    // Constructor vacío requerido por JPA
    public Game() {
    }

    // Constructor principal
    public Game(Player player, int dice1Value, int dice2Value, boolean winStatus) {
        this.player = player;
        this.dice1Value = dice1Value;
        this.dice2Value = dice2Value;
        this.winStatus = winStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getDice1Value() {
        return dice1Value;
    }

    public void setDice1Value(int dice1Value) {
        this.dice1Value = dice1Value;
    }

    public int getDice2Value() {
        return dice2Value;
    }

    public void setDice2Value(int dice2Value) {
        this.dice2Value = dice2Value;
    }

    public boolean isWinStatus() {
        return winStatus;
    }

    public void setWinStatus(boolean winStatus) {
        this.winStatus = winStatus;
    }
}