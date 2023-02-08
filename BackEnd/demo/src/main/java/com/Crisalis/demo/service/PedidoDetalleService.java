package com.Crisalis.demo.service;

import com.Crisalis.demo.model.DTO.BienDTO;
import com.Crisalis.demo.model.DTO.DetalleDTO;
import com.Crisalis.demo.model.Pedido_detalle;
import com.Crisalis.demo.repository.PedidoDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoDetalleService {

    private final PedidoDetalleRepository pedidoDetalleRepository;
    @Autowired
    public PedidoDetalleService(PedidoDetalleRepository pedidoDetalleRepository){
        this.pedidoDetalleRepository = pedidoDetalleRepository;
    }
    public List<Pedido_detalle> listar() {
        return this.pedidoDetalleRepository.findAll();
    }
    public Pedido_detalle listarId(int id) {
        Optional<Pedido_detalle> Cualquiera = this.pedidoDetalleRepository.findById(id);
        Pedido_detalle Retornar = null;
        if(Cualquiera.isPresent()){
        Retornar = Cualquiera.get();}
        return Retornar;
    }
    /*public Pedido_detalle add(DetalleDTO detalle, BienDTO bien)
    {

        return this.pedidoDetalleRepository.save(detalle.toDetalleEntity(bien));
    }*/
    public void edit(DetalleDTO detalle, BienDTO bien) {
        this.pedidoDetalleRepository.save(detalle.toDetalleEntity(bien));
    }
    public void delete(int id) {
        this.pedidoDetalleRepository.deleteById(id);
    }
    //Calculos en DTO para que no guarde en base de datos. Para que cuando se cancele por x razon, no persista.
    public Pedido_detalle calcularSubTotal(){
        DetalleDTO PDetalle = new DetalleDTO();
        BigDecimal cantidad = PDetalle.getItem_cant();
        BigDecimal costo = PDetalle.getItem_PrecioUnitario();
        BigDecimal subTotal = cantidad.multiply(costo);
        if(PDetalle.getItem_CargoSoporte() != null){
            subTotal = subTotal.add(PDetalle.getItem_CargoSoporte());
        }
        return null;
    }

    public Pedido_detalle calcularGarantia(){
        return null;
    }
    public Pedido_detalle calcularImpuesto(){
        return null;
    }
    public Pedido_detalle calcularDescuento(){
        return null;
    }
    public Pedido_detalle calcularImporte(){
        return null;
    }
    /*public Pedido_detalle calcular(DetalleDTO detalle, BienDTO bien) {
        calcularSubTotal();
        calcularGarantia();
        calcularImpuesto();
        calcularDescuento();
        calcularImporte();
        return this.pedidoDetalleRepository.save(detalle.toDetalleEntity(bien));
    }*/
}
