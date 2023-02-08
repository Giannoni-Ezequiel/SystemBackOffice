package com.Crisalis.demo.controller;

import com.Crisalis.demo.model.DTO.BienDTO;
import com.Crisalis.demo.model.DTO.DetalleDTO;
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
    private PedidoDetalleController(PedidoDetalleService pedidoDetalleService)
    {
        this.pedidoDetalleService = pedidoDetalleService;
    }

    @GetMapping("")
    public List<Pedido_detalle> listar(){
        return this.pedidoDetalleService.listar();
    }
    @GetMapping(path = {"/{id}"})
    public Pedido_detalle listarId(@PathVariable("id")int id)
    {
        return this.pedidoDetalleService.listarId(id);
    }
    /*@PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Pedido_detalle add(@RequestBody DetalleDTO detalle)
    {
        return this.pedidoDetalleService.add(detalle);
    }*/
    @PutMapping(value = {"{id}"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editar(@RequestBody DetalleDTO detalle, @RequestParam BienDTO bien, @PathVariable("id")Integer id){
        detalle.setId(id);
        this.pedidoDetalleService.edit(detalle, bien);
    }
    @DeleteMapping(path = {"/{id}"})
    public void delete(@PathVariable("id")int id)
    {
         this.pedidoDetalleService.delete(id);
    }
    /*
    @PutMapping(value = {"{id}/calcular"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Pedido_detalle calcular(@RequestBody DetalleDTO detalle, @RequestParam BienDTO bien,@PathVariable("id")Integer id){
        detalle.setId(id);
        return this.pedidoDetalleService.calcular(detalle, bien);
    }*/

}
