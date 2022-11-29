package com.neoris.exception;

public class NegocioException extends Exception {
    public static final String ERROR_GENERAL = "Se presento un error ejecutando la operación";
    public NegocioException(String message) {
        super(message);
    }
}
