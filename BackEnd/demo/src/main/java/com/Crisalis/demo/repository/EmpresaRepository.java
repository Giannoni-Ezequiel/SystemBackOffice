package com.Crisalis.demo.repository;

import com.Crisalis.demo.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

    void deleteEmpresaByCUIT(Integer CUIT);
    Optional<Empresa> findByCUITAndrazonSocial(Integer CUIT, String razonSocial);

}
