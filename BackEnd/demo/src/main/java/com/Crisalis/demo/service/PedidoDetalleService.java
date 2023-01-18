package com.Crisalis.demo.service;

import com.Crisalis.demo.model.DTO.DetalleDTO;
import com.Crisalis.demo.model.Pedido_detalle;
import com.Crisalis.demo.repository.PedidoDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoDetalleService {

    private final PedidoDetalleRepository pedidoDetalleRepository;
    @Autowired
    public PedidoDetalleService(PedidoDetalleRepository pedidoDetalleRepository){
        this.pedidoDetalleRepository = pedidoDetalleRepository;
    }
    public List<Pedido_detalle> listar() {
        return this.pedidoDetalleRepository.findAll();
    }
    public Pedido_detalle listarId(int id) {
        Optional<Pedido_detalle> Cualquiera = this.pedidoDetalleRepository.findById(id);
        Pedido_detalle Retornar = null;
        if(Cualquiera.isPresent()){
        Retornar = Cualquiera.get();}
        return Retornar;
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
