package com.Crisalis.demo.service;

import com.Crisalis.demo.model.Cliente;
import com.Crisalis.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteService implements IClienteService {
    @Autowired
    private ClienteRepository repo;
    @Override
    public List<Cliente> listar() {
        return repo.findAll();
    }

    @Override
    public Cliente listarId(int id) {
        return null;
    }

    @Override
    public Cliente crear(Cliente c) {
        return null;
    }

    @Override
    public Cliente editar(Cliente c) {
        return null;
    }

    @Override
    public Cliente delete(int id) {
        return null;
    }
}
