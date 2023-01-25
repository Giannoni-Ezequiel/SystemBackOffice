package com.Crisalis.demo.model.DTO;

import com.Crisalis.demo.model.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleDTO {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("cantidad")
    private BigDecimal item_cant;
    @JsonProperty("precioUnitario")
    private BigDecimal item_PrecioUnitario;
    @JsonProperty("precioTotal")
    private BigDecimal item_PrecioTotal;
    @JsonProperty("descuento")
    private BigDecimal item_Descuento;
    @JsonProperty("garantia")
    private Integer item_Garantia;
    @JsonProperty("porcentajeDeGarantia")
    private Double item_PorcGarantia;
    @JsonProperty("cargoSoporte")
    private BigDecimal item_CargoSoporte;
    @JsonProperty("bien")
    private Bien bien;
    @JsonProperty("pedido_impuesto")
    private Pedido_impuesto pedido_impuesto;
    /*@JsonProperty("pedido")
    private Pedido pedido;*/
    public Pedido_detalle toDetalleEntity(){
        return new Pedido_detalle(this.id, this.item_cant, this.item_PrecioUnitario, this.item_PrecioTotal, this.item_Descuento
        , this.item_Garantia, this.item_PorcGarantia, this.item_CargoSoporte, this.bien,
                this.pedido_impuesto);
    }

}