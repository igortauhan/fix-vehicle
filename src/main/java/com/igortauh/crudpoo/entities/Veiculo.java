package com.igortauh.crudpoo.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "tb_veiculos")
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Campo obrigatório")
    @Length(max = 50, message = "O nome do modelo não deve ter mais de 50 caracteres")
    private String modelo;

    @NotNull(message = "O ano não pode ser nulo")
    private Integer ano;

    @NotEmpty(message = "Campo obrigatório")
    private String cor;

    private Double kilometragem;

    @NotNull(message = "O valor não pode ser nulo")
    private Double valor;

    private String placa;

    public Veiculo() {

    }

    public Veiculo(Long id, String modelo, Integer ano, String cor, Double kilometragem, Double valor, String placa) {
        this.id = id;
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

    public Double getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(Double kilometragem) {
        this.kilometragem = kilometragem;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
