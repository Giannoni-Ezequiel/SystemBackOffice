package com.Crisalis.demo.model.DTO;

import com.Crisalis.demo.model.Producto;
import com.Crisalis.demo.model.Servicio;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BienDTO {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("tipo")
    public String tipo;
    @JsonProperty("nombre")
    public String bien_Nombre;
    @JsonProperty("costo")
    public BigDecimal bien_Costo;
    @JsonProperty("impuesto")
    public BigDecimal prod_Impuesto;
    @JsonProperty("porcentajeGarantia")
    public BigDecimal prod_PorcentajeGarantia;

    public Producto toProductEntity(){
        return new Producto(this.bien_Nombre, this.bien_Costo,
                this.prod_Impuesto, this.prod_PorcentajeGarantia);
    }
    @JsonProperty("cargoSoporte")
    private BigDecimal serv_CargoSoporte;
    @JsonProperty("servicioEspecial")
    private Boolean serv_ServicioEspecial;

    public Servicio toServiceEntity(){
        return new Servicio(this.bien_Nombre, this.bien_Costo, this.serv_CargoSoporte,
                 this.serv_ServicioEspecial);
    }
}
