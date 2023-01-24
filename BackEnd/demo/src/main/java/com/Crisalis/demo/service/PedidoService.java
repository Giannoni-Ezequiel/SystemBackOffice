package com.Crisalis.demo.service;

import com.Crisalis.demo.model.DTO.BienDTO;
import com.Crisalis.demo.model.DTO.ClienteDTO;
import com.Crisalis.demo.model.DTO.PedidoDTO;
import com.Crisalis.demo.model.Pedido;
import com.Crisalis.demo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    @Autowired
    public PedidoService(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }


    //CRUD
    public List<Pedido> listar() {
        return this.pedidoRepository.findAll();
    }
    public Pedido listarId(int id) {
        Optional<Pedido> pedido =  this.pedidoRepository.findById(id);
        Pedido Retornar = null;
        if(pedido.isPresent()){
            Retornar = pedido.get();
        }
        return Retornar;
    }
    public void add(PedidoDTO pedido) {
        this.pedidoRepository.save(pedido.toPedidoEntity());
    }
    public Pedido edit(PedidoDTO pedido) {
        return this.pedidoRepository.save(pedido.toPedidoEntity());
    }
    public Pedido delete(int id) {
        this.pedidoRepository.deleteById(id);
        return null;
    }

    //Logica de Negocio

    public Pedido getHistorialPedidos(ClienteDTO cliente, BienDTO servicio, BienDTO producto, PedidoDTO fecha) {
        Pedido Pedidos[] = listar().toArray(new Pedido[0]);
        return null;
    }

    public Pedido mayorDescuento(){
        return null;
    }

    public Pedido calcularDescTotales(){
        return null;
    }
}
