package com.igortauh.crudpoo.controllers;

import com.igortauh.crudpoo.dto.VeiculoNewDTO;
import com.igortauh.crudpoo.entities.Veiculo;
import com.igortauh.crudpoo.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {

    @Autowired
    VeiculoService veiculoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Veiculo> find(@PathVariable Long id) {
        Veiculo obj = veiculoService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<VeiculoNewDTO>> findAll() {
        List<Veiculo> list = veiculoService.findAll();
        List<VeiculoNewDTO> listDto = list.stream().map(obj -> new VeiculoNewDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Veiculo obj) {
        obj = veiculoService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Veiculo obj, @PathVariable Long id) {
        obj.setId(id);
        obj = veiculoService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        veiculoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
