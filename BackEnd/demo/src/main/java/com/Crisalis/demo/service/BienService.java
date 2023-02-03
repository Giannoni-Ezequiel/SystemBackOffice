package com.Crisalis.demo.service;

import com.Crisalis.demo.model.Bien;
import com.Crisalis.demo.model.DTO.BienDTO;
import com.Crisalis.demo.model.Servicio;
import com.Crisalis.demo.repository.IBienRepository;
import com.Crisalis.demo.repository.ProductoRepository;
import com.Crisalis.demo.repository.ServicioRepository;
import com.sun.istack.NotNull;
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
    public List<Servicio>listar() {
        return this.bienRepository.findAll();
    }

    /*public Bien listarId(int id) {
        Optional<Bien> bien = this.bienRepository.findById(id);
        Bien Retornar = null;
        if(bien.isPresent()){
            Retornar = bien.get();
        }
        return Retornar;
    }*/

    public BienDTO findById(int id)
    {
        return this.bienRepository.findById(id);/*
                .orElseThrow(
                        () -> new UnauthorizedException("No existe.")
                ).toDTO();*/
    }

    public Bien add(BienDTO bien) {
        if(bien.getTipo().equals("Producto")){
            return this.productoRepository.save(bien.toProductEntity());
        }else if(bien.getTipo().equals("Servicio")){
            return this.servicioRepository.save(bien.toServiceEntity());
        }
        return null;
    }
    /*@NotNull
    public void edit(BienDTO bien) {
        if(bien.getTipo().equals("Producto")){
           this.productoRepository.edit(bien.toProductEntity());
        } else if (bien.getTipo().equals("Servicio")) {
            this.servicioRepository.edit(bien.toServiceEntity());
        }
    }*/
    public void delete(int id) {
        this.bienRepository.deleteById(id);
    }
}
