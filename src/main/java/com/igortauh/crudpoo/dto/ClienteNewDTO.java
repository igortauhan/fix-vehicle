package com.igortauh.crudpoo.dto;

import com.igortauh.crudpoo.entities.Cliente;

import java.io.Serializable;

public class ClienteNewDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;

    public ClienteNewDTO() {

    }

    public ClienteNewDTO(Cliente obj) {
        id = obj.getId();
        nome = obj.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
