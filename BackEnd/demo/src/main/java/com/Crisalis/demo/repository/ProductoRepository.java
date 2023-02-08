package com.Crisalis.demo.repository;

import com.Crisalis.demo.model.Bien;
import com.Crisalis.demo.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
