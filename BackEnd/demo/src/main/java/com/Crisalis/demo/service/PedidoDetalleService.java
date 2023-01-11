package com.Crisalis.demo.service;

import com.Crisalis.demo.repository.PedidoDetalleRepository;
import com.Crisalis.demo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoDetalleService {

    private final PedidoDetalleRepository pedidoDetalleRepository;
    @Autowired
    public PedidoDetalleService(PedidoDetalleRepository pedidoDetalleRepository){
        this.pedidoDetalleRepository = pedidoDetalleRepository;
    }
}
