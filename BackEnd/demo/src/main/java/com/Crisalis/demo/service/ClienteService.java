package com.Crisalis.demo.service;

import com.Crisalis.demo.exception.custom.EmptyElementException;
import com.Crisalis.demo.model.Cliente;
import com.Crisalis.demo.model.DTO.ClienteDTO;
import com.Crisalis.demo.model.Empresa;
import com.Crisalis.demo.model.Person;
import com.Crisalis.demo.repository.ClienteRepository;
import com.Crisalis.demo.repository.EmpresaRepository;
import com.Crisalis.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return this.clienteRepository.findAll();
    }
    public List<Person>listarPersona() {
        return this.personRepository.findAll();
    }

    public List<Empresa>listarEmpresa() {
        return this.empresaRepository.findAll();
    }

    public Cliente listarId(int id) {
        Optional<Cliente> cliente = this.clienteRepository.findById(id)
                ;//.orElseThrow(()-> new RuntimeException("No se encontro Cliente"))
        Cliente Retornar = null;
        if(cliente.isPresent()){
            Retornar = cliente.get();
        }
        return Retornar;
    }

    public ClienteDTO add(ClienteDTO c) {
        if(c.getTipo().equals("Persona")){
            Person persona = this.personRepository.save(c.toPersonEntity());
           return (c.personaToDtos(persona));
        } else if(c.getTipo().equals("Empresa")){
            Person person = new Person(c.getNombre(), c.getApellido(), c.getDNI());
            Person newPerson = personRepository.save(person);
            Empresa empresa = this.empresaRepository.save(c.toEmpresaEntity(newPerson));
            return (c.empresaToDto(empresa));
            }
        throw new EmptyElementException("Tipo de cliente incorrecto o no especificado");
        }


    public void edit(ClienteDTO c)
    {
        if(c.getTipo().equals("Persona")){
             this.personRepository.save(c.toPersonEntity());
        } else {
            Person person = new Person(c.getNombre(), c.getApellido(), c.getDNI());
            Person newPerson = personRepository.save(person);
            this.empresaRepository.save(c.toEmpresaEntity(newPerson));
        }
    }
    public void delete(int id)
    {
        this.clienteRepository.deleteById(id);
    }

    /*@Override
    public List<Cliente> findAll() {
        return null;
    }

    @Override
    public Cliente findOne(int id) {
        return null;
    }


    @Override
    public void borrar(Cliente c) {

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
