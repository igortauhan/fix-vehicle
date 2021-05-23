package com.igortauh.crudpoo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {

    @RequestMapping(method = RequestMethod.GET)
    public String find() {
        return "O rest está funcionando!";
    }
}
