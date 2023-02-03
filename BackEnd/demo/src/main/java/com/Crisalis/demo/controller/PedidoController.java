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

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PedidoDTO> listar()
    {
        return this.pedidoService.findAll();
    }
    /*@GetMapping(value = "get_by_id", produces = MediaType.APPLICATION_JSON_VALUE)
    public PedidoDTO findByCliente(@RequestParam String identification)
    {
        return (PedidoDTO) this.pedidoService.findByCliente(identification);
    }*/
    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Pedido add(@RequestBody PedidoDTO pedido, @RequestParam List<Integer> pedidoDetalleId, Integer clienteId)
    {
        return this.pedidoService.add(pedido, pedidoDetalleId, clienteId);
    }

    @DeleteMapping(path = {"/{id}"})
    public void delete(@PathVariable("id")int id)
    {
        this.pedidoService.delete(id);
    }


}
