package com.Crisalis.demo.model.DTO;

import com.Crisalis.demo.model.Impuesto;
import com.Crisalis.demo.model.Producto;
import com.Crisalis.demo.model.Servicio;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class BienDTO {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("tipo")
    public String tipo;
    @JsonProperty("nombre")
    public String bien_Nombre;
    @JsonProperty("costo")
    public BigDecimal bien_Costo;

    @JsonProperty("porcentajeGarantia")
    public BigDecimal prod_PorcentajeGarantia;
    @JsonProperty("impuesto")
    public List<Impuesto> impuestoList;

    public Producto toProductEntity(){
        return new Producto(this.bien_Nombre, this.bien_Costo,
               this.prod_PorcentajeGarantia, this.impuestoList);
    }
    public static BienDTO productToDto(Producto producto){
        return BienDTO.builder()
                .id(producto.getBien_ID())
                .bien_Nombre(producto.getBien_Nombre())
                .bien_Costo(producto.getBien_Costo())
                .prod_PorcentajeGarantia(producto.getProd_PorcentajeGarantia())
                .tipo("Producto")
                .impuestoList(producto.getImpuestoList())
                .build();
    }
    /*public Producto productDtoToEntity(BienDTO bien){
        return Producto.builder()
                .
                .prod_PorcentajeGarantia(bien.getProd_PorcentajeGarantia())
                .impuestoList(bien.getImpuestoList())
                .build();
    }*/

    @JsonProperty("cargoSoporte")
    private BigDecimal serv_CargoSoporte;
    @JsonProperty("servicioEspecial")
    private Boolean serv_ServicioEspecial;

    public Servicio toServiceEntity(){
        return new Servicio(this.bien_Nombre, this.bien_Costo, this.serv_CargoSoporte,
                 this.serv_ServicioEspecial);
    }
    public static BienDTO servicioToDto(Servicio servicio){
        return BienDTO.builder()
                .id(servicio.getBien_ID())
                .bien_Nombre(servicio.getBien_Nombre())
                .bien_Costo(servicio.getBien_Costo())
                .serv_ServicioEspecial(servicio.getServ_ServicioEspecial())
                .serv_CargoSoporte(servicio.getServ_CargoSoporte())
                .tipo("Servicio")
                .impuestoList(servicio.getImpuestoList())
                .build();
    }

    public BienDTO toDto (){
        return BienDTO.builder()
                .id(this.id)
                .bien_Nombre(this.bien_Nombre)
                .bien_Costo(this.bien_Costo)
                .prod_PorcentajeGarantia(this.prod_PorcentajeGarantia)
                .tipo(this.tipo)
                .impuestoList(this.impuestoList)
                .build();
    }
}
