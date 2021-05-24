package com.igortauh.crudpoo.services;

import com.igortauh.crudpoo.entities.Cliente;
import com.igortauh.crudpoo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente find(Long id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElse(null);
    }

    public Cliente insert(Cliente obj) {
        obj.setId(null);
        obj = clienteRepository.save(obj);
        return obj;
    }

    public Cliente update(Cliente obj) {
        find(obj.getId());
        return clienteRepository.save(obj);
    }

    public void delete(Long id) {
        find(id);
        clienteRepository.deleteById(id);
    }
}
