package com.Crisalis.demo.repository;

import com.Crisalis.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente>findAll();
    public void deleteById(int id);

    Cliente save(Cliente c);
    void delete(Cliente c);
}
