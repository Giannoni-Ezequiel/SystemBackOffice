package com.Crisalis.demo.repository;

import com.Crisalis.demo.model.Pedido;
import com.Crisalis.demo.model.Pedido_detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    public void deleteById(int id);
    Pedido save(Pedido pedido);
    void delete(Pedido pedido);

    public List<Pedido> findAll();
}
