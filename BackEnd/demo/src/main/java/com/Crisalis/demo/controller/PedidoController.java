package com.Crisalis.demo.controller;

import com.Crisalis.demo.model.DTO.PedidoDTO;
import com.Crisalis.demo.model.Pedido;
import com.Crisalis.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    private final PedidoService pedidoService;
    @Autowired
    private PedidoController(PedidoService pedidoService)
    {
        this.pedidoService = pedidoService;
    }

    @GetMapping("")
    public List<Pedido> listar(){
        return this.pedidoService.listar();
    }
    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody PedidoDTO pedido){
        this.pedidoService.add(pedido);
    }
    @PutMapping(value = {"{id}"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Pedido editar(@RequestBody PedidoDTO pedido,@PathVariable("id")Integer id){
        pedido.setId(id);
        return this.pedidoService.edit(pedido);
    }
    @DeleteMapping(path = {"/{id}"})
    public Pedido delete(@PathVariable("id")int id){
        return this.pedidoService.delete(id);
    }
    @GetMapping(path = {"/{id}"})
    public Pedido listarId(@PathVariable("id")int id){
        return this.pedidoService.listarId(id);
    }

}
