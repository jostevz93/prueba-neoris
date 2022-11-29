package com.neoris.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente extends Persona implements Serializable {

    @Id
    @Column(name = "cliente_id",updatable = false,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    @Column(name = "contrasena",nullable = false)
    private String conCliente;

    @Column(name = "estado",nullable = false)
    private Boolean estado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    private List<Cuenta> cuentaList = new ArrayList<>();

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getConCliente() {
        return conCliente;
    }

    public void setConCliente(String conCliente) {
        this.conCliente = conCliente;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }
}
