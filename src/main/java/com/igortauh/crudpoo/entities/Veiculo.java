package com.igortauh.crudpoo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantidade;
    private String modelo;
    private Integer ano;
    private String cor;
    private Float kilometragem;
    private Float valor;
    private String placa;

    public Veiculo() {

    }

    public Veiculo(Long id, Integer quantidade, String modelo, Integer ano, String cor, Float kilometragem, Float valor, String placa) {
        this.id = id;
        this.quantidade = quantidade;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.kilometragem = kilometragem;
        this.valor = valor;
        this.placa = placa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Float getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(Float kilometragem) {
        this.kilometragem = kilometragem;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
