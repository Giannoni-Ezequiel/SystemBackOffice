package com.Crisalis.demo.service;

import com.Crisalis.demo.model.DTO.DetalleDTO;
import com.Crisalis.demo.model.Pedido_detalle;
import com.Crisalis.demo.repository.PedidoDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoDetalleService {

    private final PedidoDetalleRepository pedidoDetalleRepository;
    @Autowired
    public PedidoDetalleService(PedidoDetalleRepository pedidoDetalleRepository){
        this.pedidoDetalleRepository = pedidoDetalleRepository;
    }
    public List<Pedido_detalle> listar() {
        return (List<Pedido_detalle>) this.pedidoDetalleRepository.findAll();
    }
    public Pedido_detalle listarId(int id) {
        return this.pedidoDetalleRepository.findById(id).get();
    }
    public void add(DetalleDTO detalle) {
        this.pedidoDetalleRepository.save(detalle.toDetalleEntity());
    }
    public Pedido_detalle edit(DetalleDTO detalle) {
        return this.pedidoDetalleRepository.save(detalle.toDetalleEntity());
    }
    public Pedido_detalle delete(int id) {
        this.pedidoDetalleRepository.deleteById(id);
        return null;
    }
}
