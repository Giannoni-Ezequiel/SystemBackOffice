package com.Crisalis.demo.controller;


import com.Crisalis.demo.model.Cliente;
import com.Crisalis.demo.model.DTO.ClienteDTO;
import com.Crisalis.demo.model.Empresa;
import com.Crisalis.demo.model.Person;
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
    @GetMapping("/person")
    public List<Person>listarPersona()
    {
        return this.clienteService.listarPersona();
    }
    @GetMapping("/empresa")
    public List<Empresa>listarEmpresa()
    {
        return this.clienteService.listarEmpresa();
    }
    @GetMapping(path = {"/{id}"})
    public Cliente listarId(@PathVariable("id")Integer id)
    {
        return clienteService.listarId(id);
    }
    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cliente add(@RequestBody ClienteDTO cliente)
    {
      return this.clienteService.add(cliente);
    }
    @PutMapping(value = {"{id}"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editar(@RequestBody ClienteDTO cliente,@PathVariable("id")Integer id){
        cliente.setId(id);
         this.clienteService.edit(cliente);
    }
    @DeleteMapping(path = {"/{id}"})
    public void delete(@PathVariable("id")Integer id)
    {
        this.clienteService.delete(id);
    }

}
