package com.igortauh.crudpoo.services;

import com.igortauh.crudpoo.entities.Veiculo;
import com.igortauh.crudpoo.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    VeiculoRepository veiculoRepository;

    public Veiculo find(Integer id) {
        Optional<Veiculo> obj = veiculoRepository.findById(id);
        return obj.orElse(null);
    }
}
