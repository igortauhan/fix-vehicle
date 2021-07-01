package com.igortauh.crudpoo.services;

import com.igortauh.crudpoo.dto.ClienteDTO;
import com.igortauh.crudpoo.entities.Cliente;
import com.igortauh.crudpoo.entities.Veiculo;
import com.igortauh.crudpoo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VeiculoService veiculoService;

    public Cliente find(Long id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElse(null);
    }

    public Cliente insert(ClienteDTO objDto) {
        //Obj veiculo
        Veiculo veiculo = veiculoService.find(objDto.getIdCarro());
        Cliente obj = new Cliente(null, objDto.getNome(), objDto.getDataDeNascimento(), objDto.getCpfOuCnpj(), objDto.getEmail(), objDto.getContato(), objDto.getEndereco(), veiculo);
        obj = clienteRepository.save(obj);
        return obj;
    }

    public Cliente update(ClienteDTO objDto) {
        Veiculo veiculo = veiculoService.find(objDto.getIdCarro());
        System.out.println(veiculo.getModelo() + "Chegou aqui");
        Cliente obj = new Cliente(objDto.getId(), objDto.getNome(), objDto.getDataDeNascimento(), objDto.getCpfOuCnpj(), objDto.getEmail(), objDto.getContato(), objDto.getEndereco(), veiculo);
        obj = clienteRepository.save(obj);
        return obj;
    }

    public void delete(Long id) {
        find(id);
        clienteRepository.deleteById(id);
    }
}
