package com.Crisalis.demo.service;

import com.Crisalis.demo.model.Bien;
import com.Crisalis.demo.model.Cliente;
import com.Crisalis.demo.model.DTO.BienDTO;
import com.Crisalis.demo.model.DTO.ClienteDTO;
import com.Crisalis.demo.repository.IBienRepository;
import com.Crisalis.demo.repository.PedidoRepository;
import com.Crisalis.demo.repository.ProductoRepository;
import com.Crisalis.demo.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BienService {

    private final IBienRepository bienRepository;
    private final ProductoRepository productoRepository;
    private final ServicioRepository servicioRepository;
    @Autowired
    public BienService(IBienRepository bienRepository,
                       ProductoRepository productoRepository,
                       ServicioRepository servicioRepository
                       ){
        this.bienRepository = bienRepository;
        this.productoRepository = productoRepository;
        this.servicioRepository = servicioRepository;
    }
   /* public List<Bien> findAll() {
        return null;
    }
    public Bien save(Bien bien) {
        return bien;
    }
    public int update(Bien bien) {
        return 0;
    }
    public int deleteById(int id) {
        return 0;
    }*/

    public List<Bien>listar() {
        return (List<Bien>) this.bienRepository.findAll();
    }

    public Bien listarId(int id) {
        return this.bienRepository.findById(id).get();
    }

    public void add(BienDTO bien) {
        if(bien.getTipo().equals("Producto")){
            this.bienRepository.save(bien.toProductoEntity());
        }}
    public Bien edit(BienDTO c) {
        return this.bienRepository.save(c.toProductoEntity());
    }
    public Bien delete(int id) {
        this.bienRepository.deleteById(id);
        return null;
    }
}
