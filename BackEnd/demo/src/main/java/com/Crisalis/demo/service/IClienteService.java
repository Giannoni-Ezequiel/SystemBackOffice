package com.Crisalis.demo.service;

import com.Crisalis.demo.model.Cliente;

import java.util.List;

public interface IClienteService {

    List<Cliente>listar();
    Cliente listarId(int id);
    Cliente crear(Cliente c);
    Cliente editar(Cliente c);
    Cliente delete(int id);
}
