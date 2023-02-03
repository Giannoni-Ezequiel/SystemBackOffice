package com.Crisalis.demo.repository;

import com.Crisalis.demo.model.Bien;
import com.Crisalis.demo.model.DTO.BienDTO;
import com.Crisalis.demo.model.Impuesto;
import com.Crisalis.demo.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBienRepository extends CrudRepository<Servicio, Integer> {

    List<Servicio> findAll();
    Servicio save(BienDTO bien);
    BienDTO findById(int id);
    /*void edit();
    void edita(BienDTO Producto);
    void editar(BienDTO Servicio);*/
    int deleteById(int id);
}
