package com.Crisalis.demo.model.DTO;

import com.Crisalis.demo.model.Person;
import com.Crisalis.demo.model.Producto;
import com.Crisalis.demo.model.Servicio;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class BienDTO {

    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("nombre")
    private String bien_Nombre;
    @JsonProperty("costo")
    private BigDecimal bien_Costo;
    @JsonProperty("cargoSoporte")
    private Double bien_CargoSoporte;
    @JsonProperty("porcentajeDeCargo")
    private BigDecimal bien_PorcentajCarg;

    @JsonProperty("impuesto")
    private BigDecimal prod_Impuesto;
    @JsonProperty("precioBase")
    private BigDecimal prod_PrecioBase;
    @JsonProperty("porcentajeGarantia")
    private Double prod_PorcentajeGarantia;

    public Producto toProductoEntity(){
        return new Producto(this.bien_Nombre, this.bien_Costo, this.bien_CargoSoporte, this.bien_PorcentajCarg,
                this.prod_Impuesto, this.prod_PrecioBase, this.prod_PorcentajeGarantia);
    }

    @JsonProperty("tipoDeServicio")
    private String serv_TipoDeServicio;
    @JsonProperty("servicioEspecial")
    private Boolean serv_ServicioEspecial;

    public Servicio toServicioEntity(){
        return new Servicio(this.bien_Nombre, this.bien_Costo, this.bien_CargoSoporte, this.bien_PorcentajCarg,
                this.serv_TipoDeServicio, this.serv_ServicioEspecial);
    }
}
