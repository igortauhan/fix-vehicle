package com.igortauh.crudpoo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class ClienteDTO {

    private Long id;

    @NotEmpty
    @Length(max = 150, message = "O nome completo não pode ter mais de 200 caracteres")
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataDeNascimento;

    @NotEmpty(message = "Campo obrigatório")
    private String cpfOuCnpj;

    @NotEmpty(message = "Campo obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotEmpty(message = "Campo obrigatório")
    private String contato;

    @NotEmpty(message = "Campo obrigatório")
    private String endereco;

    @NotNull(message = "Campo obrigatório")
    private Long idCarro;

    public ClienteDTO() {

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

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Long getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Long idCarro) {
        this.idCarro = idCarro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
