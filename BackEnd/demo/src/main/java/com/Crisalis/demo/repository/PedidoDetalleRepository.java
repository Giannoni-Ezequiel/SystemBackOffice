package com.Crisalis.demo.repository;

import com.Crisalis.demo.model.DTO.DetalleDTO;
import com.Crisalis.demo.model.Impuesto;
import com.Crisalis.demo.model.Pedido_detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoDetalleRepository extends JpaRepository<Pedido_detalle, Integer> {
     void deleteById(int id);
    DetalleDTO save(DetalleDTO detalle);
    void delete(Pedido_detalle detalle);
    /*void edit(Pedido_detalle detalle);*/
    List<Pedido_detalle> findAll();
}
