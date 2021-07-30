package com.igortauh.crudpoo.dto;

import com.igortauh.crudpoo.entities.Veiculo;

import java.io.Serializable;

public class VeiculoNewDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String modelo;

    public VeiculoNewDTO() {

    }

    public VeiculoNewDTO(Veiculo obj) {
        id = obj.getId();
        modelo = obj.getModelo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
