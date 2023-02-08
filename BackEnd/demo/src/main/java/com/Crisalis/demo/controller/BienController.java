package com.Crisalis.demo.controller;

import com.Crisalis.demo.model.*;
import com.Crisalis.demo.model.DTO.BienDTO;
import com.Crisalis.demo.service.BienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public List<BienDTO> listar(){
        return this.bienService.listar();
    }/*
    @GetMapping(value = "get_by_id", produces = MediaType.APPLICATION_JSON_VALUE)
    public BienDTO findById(@RequestParam int id)
    {
        return this.bienService.findById(id);
    }*/
    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BienDTO add(@RequestBody BienDTO bien, @RequestParam List<Integer> imp_ID)/*, */
    {
        return this.bienService.add(bien, imp_ID);
    }
    @GetMapping("/producto")
    public List<Producto>listarProducto()
    {
        return this.bienService.listarProducto();
    }
    @GetMapping("/servicio")
    public List<Servicio>listarServicio()
    {
        return this.bienService.listarServicio();
    }
    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editar(@RequestBody BienDTO bien,@PathVariable("id")Integer id){
        bien.setId(id);
        this.bienService.edit(bien);
    }
    /*@PutMapping
    public ResponseEntity<BienDTO> editar(int id, BienDTO bien){
        BienDTO editar = bienService.findById(id);
                //.orElseThrow(() -> new EmptyElementException("No encontrado" + id));
        editar.setBien_Costo(bien.getBien_Costo());
        editar.setBien_Nombre(bien.getBien_Nombre());
        bienService.add(editar);
        return ResponseEntity.ok(editar);
    }*/
    @DeleteMapping(path = {"/{id}"})
    public void delete(@PathVariable("id")Integer id){
        this.bienService.delete(id);
    }

}
