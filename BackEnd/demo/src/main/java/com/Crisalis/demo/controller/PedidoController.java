package com.Crisalis.demo.controller;

import com.Crisalis.demo.service.PedidoService;
import com.Crisalis.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "pedido")
public class PedidoController {

    private final PedidoService pedidoService;
    @Autowired
    public PedidoController(PedidoService pedidoService)
    {
        this.pedidoService = pedidoService;
    }
}
