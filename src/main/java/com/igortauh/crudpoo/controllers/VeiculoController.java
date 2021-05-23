package com.igortauh.crudpoo.controllers;

import com.igortauh.crudpoo.entities.Veiculo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Veiculo> find() {
        Veiculo veiculo1 = new Veiculo(null, 2, "Corolla", 2016, "Preto", 0.0, 70.000, "ABC-1234");
        Veiculo veiculo2 = new Veiculo(null, 3, "Civic", 2016, "Prata", 0.0, 100.000, "ABC-1233");

        List<Veiculo> list = new ArrayList<>();
        list.addAll(Arrays.asList(veiculo1, veiculo2));
        return list;
    }
}
