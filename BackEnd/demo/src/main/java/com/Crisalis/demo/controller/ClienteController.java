package com.Crisalis.demo.controller;


import com.Crisalis.demo.model.Cliente;
import com.Crisalis.demo.service.ClienteService;
import com.Crisalis.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteService clienteService;
    @Autowired
    public ClienteController(ClienteService clienteService)
    {
        this.clienteService = clienteService;
    }
    @GetMapping
    public List<Cliente>listar(){
        return clienteService.listar();
    };

    /*@GetMapping(path = {"/{id}"})
    public Cliente listarId(@PathVariable("id")int id){
        return service.listarId(id);
    }*/
    @PostMapping
    public Cliente agregar(@RequestBody Cliente c){
        return clienteService.add(c);
    }

    @PutMapping(path = {"/{id}"})
    public Cliente editar(@RequestBody Cliente c,@PathVariable("id")int id){
        c.setId(id);
        return clienteService.edit(c);
    }
    /*@DeleteMapping(path = {"/{id}"})
    public Cliente delete(@PathVariable("id")int id){
        return service.delete(id);
    }*/
}
