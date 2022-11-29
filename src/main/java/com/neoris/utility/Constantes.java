package com.neoris.utility;

public enum Constantes {
    TIPO_DEPOSITO("DEPOSITO"),
    TIPO_RETIRO("RETIRO");

    private String value;

    Constantes(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
