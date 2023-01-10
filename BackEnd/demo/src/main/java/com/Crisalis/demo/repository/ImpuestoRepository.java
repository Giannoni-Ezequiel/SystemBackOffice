package com.Crisalis.demo.repository;

import com.Crisalis.demo.model.Impuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpuestoRepository extends JpaRepository<Impuesto, Integer> {
}
