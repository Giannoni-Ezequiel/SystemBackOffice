package com.Crisalis.demo.model.DTO;

import com.Crisalis.demo.model.Producto;
import com.Crisalis.demo.model.Servicio;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BienDTO {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("nombre")
    private String bien_Nombre;
    @JsonProperty("costo")
    private BigDecimal bien_Costo;
    @JsonProperty("impuesto")
    private BigDecimal prod_Impuesto;
    @JsonProperty("porcentajeGarantia")
    private Double prod_PorcentajeGarantia;

    public Producto toProductoEntity(){
        return new Producto(this.bien_Nombre, this.bien_Costo,
                this.prod_Impuesto, this.prod_PorcentajeGarantia);
    }
    @JsonProperty("cargoSoporte")
    private BigDecimal serv_CargoSoporte;
    @JsonProperty("servicioEspecial")
    private Boolean serv_ServicioEspecial;

    public Servicio toServicioEntity(){
        return new Servicio(this.bien_Nombre, this.bien_Costo, this.serv_CargoSoporte,
                 this.serv_ServicioEspecial);
    }
}
