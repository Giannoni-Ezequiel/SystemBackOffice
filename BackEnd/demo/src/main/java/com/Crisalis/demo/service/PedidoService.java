package com.Crisalis.demo.service;

import com.Crisalis.demo.model.DTO.PedidoDTO;
import com.Crisalis.demo.model.Pedido;
import com.Crisalis.demo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    @Autowired
    public PedidoService(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> listar() {
        return this.pedidoRepository.findAll();
    }
    public Pedido listarId(int id) {
        return this.pedidoRepository.findById(id).get();
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
}
