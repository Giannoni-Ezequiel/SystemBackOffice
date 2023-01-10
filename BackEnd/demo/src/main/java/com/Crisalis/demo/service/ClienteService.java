package com.Crisalis.demo.service;

import com.Crisalis.demo.interfaces.ICliente;
import com.Crisalis.demo.model.Cliente;
import com.Crisalis.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements ICliente {

    @Autowired
    private ClienteRepository data;

    @Override
    public List<Cliente>listar() {
        return (List<Cliente>) data.findAll();
    }

    /*@Override
    public Cliente listarId(int id) {
        return data.findOne(id);
    }*/

    @Override
    public Cliente add(Cliente c) {
        return data.save(c);
    }

    @Override
    public Cliente edit(Cliente c) {
        return data.save(c);
    }

    /*@Override
    public Cliente delete(int id) {
        Cliente c=data.findOne(id);
        if(c!=null){
            data.delete(c);
        }
        return c;
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
