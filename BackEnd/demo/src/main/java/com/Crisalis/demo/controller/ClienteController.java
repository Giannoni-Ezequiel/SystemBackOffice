package com.Crisalis.demo.controller;

import com.Crisalis.demo.model.Cliente;
import com.Crisalis.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(("/clientes"))
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping
    public List<Cliente>listar(){
        return service.listar();
    };
}
