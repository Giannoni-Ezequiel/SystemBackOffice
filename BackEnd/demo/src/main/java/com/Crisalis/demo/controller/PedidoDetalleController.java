package com.Crisalis.demo.controller;

import com.Crisalis.demo.service.PedidoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "pedido_detalle")
public class PedidoDetalleController {

    private final PedidoDetalleService pedidoDetalleService;
    @Autowired
    public PedidoDetalleController(PedidoDetalleService pedidoDetalleService)
    {
        this.pedidoDetalleService = pedidoDetalleService;
    }
}
