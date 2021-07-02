package com.igortauh.crudpoo.controllers;

import com.igortauh.crudpoo.entities.Agenda;
import com.igortauh.crudpoo.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
