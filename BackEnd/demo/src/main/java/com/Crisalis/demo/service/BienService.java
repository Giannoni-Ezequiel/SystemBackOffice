package com.Crisalis.demo.service;

import com.Crisalis.demo.model.Bien;
import com.Crisalis.demo.model.DTO.BienDTO;
import com.Crisalis.demo.repository.IBienRepository;
import com.Crisalis.demo.repository.ProductoRepository;
import com.Crisalis.demo.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Bien>listar() {
        return this.bienRepository.findAll();
    }

    public Bien listarId(int id) {
        Optional<Bien> bien = this.bienRepository.findById(id);
        Bien Retornar = null;
        if(bien.isPresent()){
            Retornar = bien.get();
        }
        return Retornar;
    }

    public void add(BienDTO bien) {
        if(bien.getTipo().equals("Producto")){
            this.productoRepository.save(bien.toProductoEntity());
        }if(bien.getTipo().equals("Servicio")){
            this.servicioRepository.save(bien.toServicioEntity());
        } else {
            this.servicioRepository.save(null);
        }
    }
    public Bien edit(BienDTO bien) {
        if(bien.getTipo().equals("Producto")){
           return  this.productoRepository.save(bien.toProductoEntity());
        }if(bien.getTipo().equals("Servicio")){
            return this.servicioRepository.save(bien.toServicioEntity());
        } else {
            return this.servicioRepository.save(null);
        }
    }
    public Bien delete(int id) {
        this.bienRepository.deleteById(id);
        return null;
    }
}
