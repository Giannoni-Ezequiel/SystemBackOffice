package com.Crisalis.demo.repository;

import com.Crisalis.demo.model.Cliente;
import com.Crisalis.demo.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    void deleteById(int id);
    Pedido save(Pedido pedido);
    /*void edit(Pedido pedido);*/
    void delete(Pedido pedido);
    Optional<Pedido> findById(Integer integer);
    List<Pedido> findAll();

    List<Pedido> findByCliente(Cliente nombre);
}
