package com.Crisalis.demo.controller;

import com.Crisalis.demo.model.DTO.PedidoDTO;
import com.Crisalis.demo.model.Impuesto;
import com.Crisalis.demo.model.Pedido;
import com.Crisalis.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

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
    public ResponseEntity<?> listar()
    {
        List<Pedido> pedidoDetalleDtoList = pedidoService.listar();
        if(pedidoDetalleDtoList.isEmpty()){
            return status(HttpStatus.NOT_FOUND)
                    .body("Pedido no encontrado");
        }
        return status(HttpStatus.OK).body(pedidoDetalleDtoList);
    }
    @GetMapping("")
    public List<Pedido> listar2(){
        return this.pedidoService.listar();
    }
    /*@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PedidoDTO> listar1()
    {
        return this.pedidoService.allPedidos();
    }
    @GetMapping(value = "get_by_id", produces = MediaType.APPLICATION_JSON_VALUE)
    public PedidoDTO findByCliente(@RequestParam String identification)
    {
        return (PedidoDTO) this.pedidoService.findByCliente(identification);
    }*/
    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PedidoDTO add(@RequestBody PedidoDTO pedido)
    {
        return this.pedidoService.add(pedido);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> anularPedido(@PathVariable(value = "id")Integer id)
    {
        this.pedidoService.anular(id);
        return ResponseEntity.status(HttpStatus.OK).body("Pedido con id: "+id+" . ¡Fue anulado con Exito!");
    }


}
