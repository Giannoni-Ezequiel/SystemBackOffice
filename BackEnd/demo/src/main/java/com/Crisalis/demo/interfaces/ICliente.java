package com.Crisalis.demo.interfaces;

import com.Crisalis.demo.model.Cliente;

import java.util.List;


public interface ICliente {
    public List<Cliente> listar();
    /*public Cliente listarId(int id);*/
    public Cliente add(Cliente c);
    public Cliente edit(Cliente c);
    /*public Cliente delete(int id);*/

}
