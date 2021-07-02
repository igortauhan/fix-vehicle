package com.igortauh.crudpoo.services;

import com.igortauh.crudpoo.entities.Agenda;
import com.igortauh.crudpoo.repositories.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    public Agenda find(Long id) {
        Optional<Agenda> obj = agendaRepository.findById(id);
        return obj.orElse(null);
    }
}
