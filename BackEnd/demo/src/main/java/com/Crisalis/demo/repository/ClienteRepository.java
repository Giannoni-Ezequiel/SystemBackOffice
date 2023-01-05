package com.Crisalis.demo.repository;

import com.Crisalis.demo.model.Cliente;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ClienteRepository extends Repository<Cliente, Integer> {
    List<Cliente>findAll();
    Cliente findOne(int id);
    Cliente guardar(Cliente c);
    void borrar(Cliente c);
}
