package com.Crisalis.demo.repository;

import com.Crisalis.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente>findAll();
    Cliente findOne(int id);
    Cliente crear(Cliente c);
    void borrar(Cliente c);
}
