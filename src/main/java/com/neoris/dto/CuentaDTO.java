package com.neoris.dto;

public class CuentaDTO {
    private Long cuentaId;
    private Long numeroCuenta;
    private String tipoCuenta;
    private Long saldoInicial;
    private String estado;
    private ClienteDTO cliente;
    private Long saldoActual;

    public Long getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Long cuentaId) {
        this.cuentaId = cuentaId;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Long getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Long saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ClienteDTO getClienteDTO() {
        return cliente;
    }

    public void setClienteDTO(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public Long getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(Long saldoActual) {
        this.saldoActual = saldoActual;
    }
}
