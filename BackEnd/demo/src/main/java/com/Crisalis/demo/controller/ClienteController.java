package com.Crisalis.demo.controller;


import com.Crisalis.demo.model.Cliente;
import com.Crisalis.demo.model.DTO.ClienteDTO;
import com.Crisalis.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    @GetMapping("")
    public List<Cliente>listar(){
        return this.clienteService.listar();
    };
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody ClienteDTO cliente){
        this.clienteService.add(cliente);
    }
    @PutMapping(value = {"{id}"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cliente editar(@RequestBody ClienteDTO cliente,@PathVariable("id")Integer id){
        cliente.setId(id);
        return this.clienteService.edit(cliente);
    }
    @DeleteMapping(path = {"/{id}"})
    public Cliente delete(@PathVariable("id")Integer id){
        return this.clienteService.delete(id);
    }
    @GetMapping(path = {"/{id}"})
        public Cliente listarId(@PathVariable("id")Integer id){
            return clienteService.listarId(id);
        }
}
