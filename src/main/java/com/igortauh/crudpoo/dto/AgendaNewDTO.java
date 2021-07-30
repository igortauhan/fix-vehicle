package com.igortauh.crudpoo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.igortauh.crudpoo.entities.Agenda;

import java.io.Serializable;
import java.util.Date;

public class AgendaNewDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataDeAgendamento;
    private String nomeDoCliente;

    public AgendaNewDTO() {

    }

    public AgendaNewDTO(Agenda obj) {
        id = obj.getId();
        dataDeAgendamento = obj.getDataDeAgendamento();
        nomeDoCliente = obj.getCliente().getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataDeAgendamento() {
        return dataDeAgendamento;
    }

    public void setDataDeAgendamento(Date dataDeAgendamento) {
        this.dataDeAgendamento = dataDeAgendamento;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }
}
