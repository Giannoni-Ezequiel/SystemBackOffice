package com.Crisalis.demo.repository;

import com.Crisalis.demo.model.Pedido_detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoDetalleRepository extends JpaRepository<Pedido_detalle, Long> {
}
