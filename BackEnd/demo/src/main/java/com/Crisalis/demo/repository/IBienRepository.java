package com.Crisalis.demo.repository;

import com.Crisalis.demo.model.Bien;
import com.Crisalis.demo.model.Cliente;
import com.Crisalis.demo.model.DTO.BienDTO;
import com.Crisalis.demo.model.Impuesto;
import com.Crisalis.demo.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBienRepository extends JpaRepository<Servicio, Integer> {

    Bien save(Bien bien);
    void delete(Bien bien);
    /*void edit();
    void edita(BienDTO Producto);
    void editar(BienDTO Servicio);*/
    void deleteById(int id);
}
