package com.Crisalis.demo.repository;

import com.Crisalis.demo.model.Bien;
import com.Crisalis.demo.model.Cliente;
import com.Crisalis.demo.model.Impuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImpuestoRepository extends JpaRepository<Impuesto, Integer> {

    public void deleteById(int id);
    Impuesto save(Impuesto imp);
    void delete(Impuesto imp);

    public List<Impuesto> findAll();
}
