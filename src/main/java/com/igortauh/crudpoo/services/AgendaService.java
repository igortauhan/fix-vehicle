package com.igortauh.crudpoo.services;

import com.igortauh.crudpoo.dto.AgendaDTO;
import com.igortauh.crudpoo.entities.Agenda;
import com.igortauh.crudpoo.entities.Cliente;
import com.igortauh.crudpoo.repositories.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgendaService {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private AgendaRepository agendaRepository;

    public Agenda find(Long id) {
        Optional<Agenda> obj = agendaRepository.findById(id);
        return obj.orElse(null);
    }

    public Agenda insert(AgendaDTO objDto) {

        // instancia um objeto cliente atraves do metodo find do cliente service
        Cliente cliente = clienteService.find(objDto.getClienteId());
        // instancia um objeto do tipo agenda com os objetos: objDto e o cliente
        Agenda obj = new Agenda(null, objDto.getDataDeAgendamento(), cliente);

        obj = agendaRepository.save(obj);
        return obj;
    }
}
