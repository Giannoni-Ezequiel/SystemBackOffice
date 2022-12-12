package com.Administracion.Crisalis.repository;

import com.Administracion.Crisalis.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


    Optional<Usuario> findByUsernameAndPassword(String username, String password);
}
