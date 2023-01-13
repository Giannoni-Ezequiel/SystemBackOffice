package com.Crisalis.demo.controller;

import com.Crisalis.demo.model.DTO.DetalleDTO;
import com.Crisalis.demo.model.DTO.ImpuestoDTO;
import com.Crisalis.demo.model.Impuesto;
import com.Crisalis.demo.model.Pedido_detalle;
import com.Crisalis.demo.service.PedidoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedido_detalle")
public class PedidoDetalleController {

    private final PedidoDetalleService pedidoDetalleService;
    @Autowired
    public PedidoDetalleController(PedidoDetalleService pedidoDetalleService)
    {
        this.pedidoDetalleService = pedidoDetalleService;
    }

    @GetMapping("")
    public List<Pedido_detalle> listar(){
        return this.pedidoDetalleService.listar();
    };
    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody DetalleDTO detalle){
        this.pedidoDetalleService.add(detalle);
    }
    /*@PutMapping(value = {"{id}"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Pedido_detalle editar(@RequestBody DetalleDTO imp,@PathVariable("id")int id){
        detalle.set(id);
        return this.pedidoDetalleService.edit(detalle);
    }*/
    @DeleteMapping(path = {"/{id}"})
    public Pedido_detalle delete(@PathVariable("id")int id){
        return this.pedidoDetalleService.delete(id);
    }
    @GetMapping(path = {"/{id}"})
    public Pedido_detalle listarId(@PathVariable("id")int id){
        return this.pedidoDetalleService.listarId(id);
    }

}
