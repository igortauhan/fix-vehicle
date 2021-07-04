package com.igortauh.crudpoo.controllers;

import com.igortauh.crudpoo.dto.AgendaDTO;
import com.igortauh.crudpoo.entities.Agenda;
import com.igortauh.crudpoo.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody AgendaDTO objDto) {
        Agenda obj = agendaService.insert(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody AgendaDTO objDto, @PathVariable Long id) {
        Agenda obj = agendaService.update(objDto, id);
        return ResponseEntity.noContent().build();
    }
}
