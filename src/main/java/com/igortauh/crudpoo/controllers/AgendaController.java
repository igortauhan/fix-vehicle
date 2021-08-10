package com.igortauh.crudpoo.controllers;

import com.igortauh.crudpoo.dto.AgendaDTO;
import com.igortauh.crudpoo.dto.AgendaNewDTO;
import com.igortauh.crudpoo.entities.Agenda;
import com.igortauh.crudpoo.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Agenda> find(@PathVariable Long id) {
       Agenda obj = agendaService.find(id) ;
       return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<AgendaNewDTO>> findAll() {
        List<Agenda> list = agendaService.findAll();
        List<AgendaNewDTO> listDto = list.stream().map(obj -> new AgendaNewDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody AgendaDTO objDto) {
        Agenda obj = agendaService.insert(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody AgendaDTO objDto, @PathVariable Long id) {
        Agenda obj = agendaService.update(objDto, id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        agendaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
