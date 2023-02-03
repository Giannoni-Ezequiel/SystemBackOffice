package com.Crisalis.demo.controller;

import com.Crisalis.demo.model.DTO.ImpuestoDTO;
import com.Crisalis.demo.model.Impuesto;
import com.Crisalis.demo.service.ImpuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("impuestos")
public class ImpuestoController {

    private final ImpuestoService impuestoService;
    @Autowired
    private ImpuestoController(ImpuestoService impuestoService)
    {
        this.impuestoService = impuestoService;
    }

    @GetMapping("")
    public List<Impuesto> listar(){
        return this.impuestoService.listar();
    }
    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Impuesto add(@RequestBody ImpuestoDTO imp)
    {
        return this.impuestoService.add(imp);
    }
    @PutMapping(value = {"{id}"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editar(@RequestBody ImpuestoDTO imp,@PathVariable("id")Integer id){
        imp.setId(id);
        this.impuestoService.edit(imp);
    }
    @DeleteMapping(path = {"/{id}"})
    public void delete(@PathVariable("id")int id)
    {
         this.impuestoService.delete(id);
    }
    @GetMapping(path = {"/{id}"})
    public Impuesto listarId(@PathVariable("id")int id){
        return this.impuestoService.listarId(id);
    }

    /*
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Impuesto saveImpuesto(@RequestBody ImpuestoDTO impuestoDTO)
    {
        return this.impuestoService.saveImpuesto(ImpuestoDTO);
    }
 */
}
