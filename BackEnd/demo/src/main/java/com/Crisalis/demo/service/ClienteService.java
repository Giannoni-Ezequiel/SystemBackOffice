package com.Crisalis.demo.service;

import com.Crisalis.demo.model.Cliente;
import com.Crisalis.demo.model.DTO.ClienteDTO;
import com.Crisalis.demo.repository.ClienteRepository;
import com.Crisalis.demo.repository.EmpresaRepository;
import com.Crisalis.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final PersonRepository personRepository;
    private final EmpresaRepository empresaRepository;
    @Autowired
    public ClienteService(ClienteRepository clienteRepository,
                          PersonRepository personRepository,
                          EmpresaRepository empresaRepository){
        this.clienteRepository = clienteRepository;
        this.personRepository = personRepository;
        this.empresaRepository = empresaRepository;
    }

    public List<Cliente>listar() {
        return (List<Cliente>) this.clienteRepository.findAll();
    }

    public Cliente listarId(int id) {
        return this.clienteRepository.findById(id).get();
    }

     public void add(ClienteDTO c) {
        if(c.getTipo().equals("Persona")){
            this.personRepository.save(c.toPersonEntity());
        } /*else {
            if(c.getTipo().equals("Empresa")){
            this.empresaRepository.save(c.toEmpresaEntity());}
        }*/
        //return this.clienteRepository.save(c);

    }
    public Cliente edit(ClienteDTO c) {
        return this.clienteRepository.save(c.toPersonEntity());
    }
    public Cliente delete(int id) {
        this.clienteRepository.deleteById(id);
        return null;
    }

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
