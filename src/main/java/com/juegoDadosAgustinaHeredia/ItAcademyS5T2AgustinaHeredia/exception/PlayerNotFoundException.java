package com.juegoDadosAgustinaHeredia.ItAcademyS5T2AgustinaHeredia.exception;

public class PlayerNotFoundException extends RuntimeException {
    private static final long serialVerisionUID = 1;

    public PlayerNotFoundException(String message) {
        super(message);
    }
}