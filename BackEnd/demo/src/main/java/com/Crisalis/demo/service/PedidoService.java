package com.Crisalis.demo.service;

import com.Crisalis.demo.model.DTO.BienDTO;
import com.Crisalis.demo.model.DTO.ClienteDTO;
import com.Crisalis.demo.model.DTO.PedidoDTO;
import com.Crisalis.demo.model.Pedido;
import com.Crisalis.demo.repository.ClienteRepository;
import com.Crisalis.demo.repository.PedidoDetalleRepository;
import com.Crisalis.demo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoDetalleRepository pedidoDetalleRepository;
    private final ClienteRepository clienteRepository;
    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, PedidoDetalleRepository pedidoDetalleRepository,
                         ClienteRepository clienteRepository)
    {
        this.pedidoRepository = pedidoRepository;
        this.pedidoDetalleRepository = pedidoDetalleRepository;
        this.clienteRepository = clienteRepository;
    }
    //CRUD
    public List<PedidoDTO> findAll()
    {
        return this.pedidoRepository
                .findAll()
                .stream()
                .map(Pedido::toDTO)
                .collect(Collectors.toList());
    }
    /*public List<PedidoDTO> findByClient(String identification)
    {
        List<PedidoDTO> pedidoDTOLista = new ArrayList<>();
        List<Pedido> pedidoLista = this.pedidoRepository.findByClient(this.clienteRepository
                .findByIdenfication(identification).orElseThrow(
                        () -> new RuntimeException("Cliente no encontrado")
                ));
        for(Pedido pedido : pedidoLista)
        {
            pedidoDTOLista.add(pedido.toDTO());
        }
        return pedidoDTOLista;
    }*/

    public Pedido add(PedidoDTO pedido, List<Integer> pedidoDetalleId, Integer clienteId)
    {
        for(Integer iterator : pedidoDetalleId){
            pedido.getPedido_detalle().add(this.pedidoDetalleRepository.findById(iterator).orElseThrow(

                    () -> new RuntimeException("Detalle Orden no encontrado")
            ));
        }
        /*pedido.setCliente(this.clienteRepository.findByIdenficationNumber(clienteId).orElseThrow(
                () -> new RuntimeException("Cliente no encontrado")
        ));*/
        return this.pedidoRepository.save(pedido.toPedidoEntity());
    }
    public void delete(int id)
    {
        this.pedidoRepository.deleteById(id);
    }


    //Logica de Negocio

    public Pedido getHistorialPedidos(ClienteDTO cliente, BienDTO servicio, BienDTO producto, PedidoDTO fecha) {

        return null;
    }

    public Pedido mayorDescuento(){
        return null;
    }

    public Pedido calcularDescTotales(){
        return null;
    }
}
