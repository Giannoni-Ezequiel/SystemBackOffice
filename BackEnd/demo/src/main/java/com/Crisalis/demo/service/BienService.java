package com.Crisalis.demo.service;

import com.Crisalis.demo.exception.custom.EmptyElementException;
import com.Crisalis.demo.model.*;
import com.Crisalis.demo.model.DTO.BienDTO;
import com.Crisalis.demo.repository.IBienRepository;
import com.Crisalis.demo.repository.ImpuestoRepository;
import com.Crisalis.demo.repository.ProductoRepository;
import com.Crisalis.demo.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BienService {

    private final IBienRepository bienRepository;
    private final ProductoRepository productoRepository;
    private final ServicioRepository servicioRepository;
    private final ImpuestoRepository impuestoRepository;
    @Autowired
    public BienService(IBienRepository bienRepository,
                       ProductoRepository productoRepository,
                       ServicioRepository servicioRepository,
                       ImpuestoRepository impuestoRepository
                       ){
        this.bienRepository = bienRepository;
        this.productoRepository = productoRepository;
        this.servicioRepository = servicioRepository;
        this.impuestoRepository = impuestoRepository;
    }
     public List<BienDTO>listar() {
        List<BienDTO> allProductos = productoRepository.findAll()
                .stream()
                .map(BienDTO::productToDto)
                .collect(Collectors.toList());
        List<BienDTO> allServicios = servicioRepository.findAll()
                .stream()
                .map(BienDTO::servicioToDto)
                .collect(Collectors.toList());
        List<BienDTO> allBienes = new ArrayList<>();
        allBienes.addAll(allProductos);
         allBienes.addAll(allServicios);
        return allBienes;
     }/*

   /*public Bien listarId(int id) {
         Optional<Bien> bien = this.bienRepository.findById(id);
         Bien Retornar = null;
         if(bien.isPresent()){
             Retornar = bien.get();
         }
         return Retornar;
     }*/
    public List<Producto>listarProducto() {
        return this.productoRepository.findAll();
    }

    public List<Servicio>listarServicio() {
        return this.servicioRepository.findAll();
    }
    /*public BienDTO findById(int id)
    {
        return this.bienRepository.findById(id);
                .orElseThrow(
                        () -> new UnauthorizedException("No existe.")
                ).toDTO();
    }*/

    public BienDTO add(BienDTO bien, List<Integer> impuestoID) {
        //String bientipo = bien.getTipo().toLowerCase();
        if(bien.getTipo().equals("Producto")){
            for(Integer integer : impuestoID){
                bien.getImpuestoList().add(this.impuestoRepository.findById(integer)
                        .orElseThrow(() -> {
                            throw new RuntimeException("Impuesto no encontrado");
                        }));
            }
            Producto producto = this.productoRepository.save(bien.toProductEntity());
            return (bien.productToDto(producto));
        }else if(bien.getTipo().equals("Servicio")){
            for(Integer integer : impuestoID){
                bien.getImpuestoList().add(this.impuestoRepository.findById(integer)
                        .orElseThrow(() -> {
                            throw new RuntimeException("Impuesto no encontrado");
                        }));
            }
            Servicio servicio = this.servicioRepository.save(bien.toServiceEntity());
            return (bien.servicioToDto(servicio));
        }
        throw new EmptyElementException("Tipo de Bien no especificado");
    }

    public void edit(BienDTO bien) {
        if(bien.getTipo().equals("Producto")){
           this.productoRepository.save(bien.toProductEntity());
        } else if (bien.getTipo().equals("Servicio")) {
            this.servicioRepository.save(bien.toServiceEntity());
        }
    }
    public void delete(int id) {
        this.bienRepository.deleteById(id);
    }
}
