package com.Crisalis.demo.controller;

import com.Crisalis.demo.model.Bien;
import com.Crisalis.demo.model.DTO.BienDTO;
import com.Crisalis.demo.service.BienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bien")
public class BienController {

    private final BienService bienService;
    @Autowired
    public BienController(BienService bienService)
    {
        this.bienService = bienService;
    }

    @GetMapping("")
    public List<Bien> listar(){
        return this.bienService.listar();
    };
    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody BienDTO bien){
        this.bienService.add(bien);
    }
    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Bien editar(@RequestBody BienDTO bien,@PathVariable("id")Integer id){
        bien.setId(id);
        return this.bienService.edit(bien);
    }
    @DeleteMapping(path = {"/{id}"})
    public Bien delete(@PathVariable("id")Integer id){
        return this.bienService.delete(id);
    }
    @GetMapping(path = {"/{id}"})
    public Bien listarId(@PathVariable("id")Integer id){
        return this.bienService.listarId(id);
    }
}
