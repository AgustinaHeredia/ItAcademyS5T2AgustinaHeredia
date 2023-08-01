package com.juegoDadosAgustinaHeredia.ItAcademyS5T2AgustinaHeredia.exception;

public class ReviewNotFoundException extends RuntimeException {
    private static final long serialVerisionUID = 2;
    public ReviewNotFoundException(String message) {
        super(message);
    }
}