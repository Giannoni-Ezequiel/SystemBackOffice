package com.Crisalis.demo.repository;

import com.Crisalis.demo.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    /*void edit(Servicio toServicioEntity);*/
}
