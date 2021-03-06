package com.igortauh.crudpoo.controllers;

import com.igortauh.crudpoo.dto.ClienteDTO;
import com.igortauh.crudpoo.dto.ClienteNewDTO;
import com.igortauh.crudpoo.entities.Cliente;
import com.igortauh.crudpoo.services.ClienteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @ApiOperation(value = "Busca por ID")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> find(@PathVariable Long id) {
        Cliente obj = clienteService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value = "Retorna todos os clientes")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ClienteNewDTO>> findAll() {
        List<Cliente> list = clienteService.findAll();
        List<ClienteNewDTO> listDto = list.stream().map(obj -> new ClienteNewDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @ApiOperation(value = "Insere um cliente")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody ClienteDTO objDto) {
        Cliente obj = clienteService.insert(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @ApiOperation(value = "Atualiza um cliente")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody ClienteDTO objDto) {
        Cliente obj = clienteService.update(objDto, id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Deleta um cliente")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
