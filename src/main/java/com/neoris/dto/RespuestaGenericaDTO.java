package com.neoris.dto;

import java.io.Serializable;

public class RespuestaGenericaDTO implements Serializable {
    private Boolean exitoso;
    private Object data;
    private String mensajeError;

    public Boolean getExitoso() {
        return exitoso;
    }

    public void setExitoso(Boolean exitoso) {
        this.exitoso = exitoso;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
