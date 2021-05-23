package com.igortauh.crudpoo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {

    @RequestMapping
    public String find() {
        return "O rest está funcionando!";
    }
}
