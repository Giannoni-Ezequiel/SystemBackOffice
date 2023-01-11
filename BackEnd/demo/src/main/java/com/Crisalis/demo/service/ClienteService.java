package com.Crisalis.demo.service;

import com.Crisalis.demo.model.Cliente;
import com.Crisalis.demo.repository.ClienteRepository;
import com.Crisalis.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    @Autowired
    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente>listar() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    /*public Cliente listarId(int id) {
        return data.find(id);
    }*/

    public Cliente add(Cliente c) {
        return clienteRepository.save(c);
    }

    public Cliente edit(Cliente c) {
        return clienteRepository.save(c);
    }


    /*public void delete(int id) {
        Cliente.deleteById(id);
    }*/

    /*
    @Override
    public List<Cliente> findAll() {
        return null;
    }

    @Override
    public Cliente findOne(int id) {
        return null;
    }

    @Override
    public Cliente crear(Cliente c) {
        return null;
    }

    @Override
    public void borrar(Cliente c) {

    }
    /*@Override
    public List<Cliente> listar() {
        return repo.findAll();
    }

    @Override
    public Cliente listarId(int id) {
        return repo.findOne(id);
    }

    @Override
    public Cliente crear(Cliente c) {
        return repo.crear(c);
    }

    @Override
    public Cliente editar(Cliente c) {
        return repo.crear(c);
    }

    @Override
    public Cliente delete(int id) {
        Cliente c=repo.findOne(id);
        if(c!=null){
            repo.borrar(c);
        }
        return c;
    }*/
}
