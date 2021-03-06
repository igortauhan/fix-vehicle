package com.igortauh.crudpoo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class AgendaDTO {

    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Forneça uma data de agendamento")
    private Date dataDeAgendamento;

    @NotNull(message = "O Id do cliente não pode estar vazio")
    private Long clienteId;

    public AgendaDTO() {

    }

    public AgendaDTO(Long id, Date dataDeAgendamento, Long clienteId) {
        this.id = id;
        this.dataDeAgendamento = dataDeAgendamento;
        this.clienteId = clienteId;
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

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
