package com.igortauh.crudpoo.services;

import com.igortauh.crudpoo.entities.Veiculo;
import com.igortauh.crudpoo.repositories.VeiculoRepository;
import com.igortauh.crudpoo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    VeiculoRepository veiculoRepository;

    public Veiculo find(Long id) {
        Optional<Veiculo> obj = veiculoRepository.findById(id);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id
                + ", Tipo: " + Veiculo.class.getName())
        );
    }

    public Veiculo insert(Veiculo obj) {
        obj.setId(null);
        return veiculoRepository.save(obj);
    }

    public Veiculo update(Veiculo obj) {
        find(obj.getId());
        return veiculoRepository.save(obj);
    }

    public void delete(Long id) {
        find(id);
        veiculoRepository.deleteById(id);
    }
}
