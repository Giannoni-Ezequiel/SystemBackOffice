package com.Crisalis.demo.model.DTO;

import com.Crisalis.demo.model.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private BigDecimal item_PorcGarantia;
    @JsonProperty("cargoSoporte")
    private BigDecimal item_CargoSoporte;
    /*@JsonProperty("bien")
    private Bien bien;*/
    @JsonProperty("producto")
    private Producto producto;
    @JsonProperty("servicio")
    private Servicio servicio;
    @JsonProperty("pedido")
    private List<Pedido_detalle> pedidoDetalleList = new ArrayList();


    /*@JsonProperty("pedido")
    private Pedido pedido;
    public Pedido_detalle toDetalleEntity(BienDTO bien){
        if(bien.getTipo().equals("Producto")){
            Bien bien1 = bien.toServiceEntity();
        }else if(bien.getTipo().equals("Servicio")){
            Bien bien1 = bien.toServiceEntity();
        }
        return new Pedido_detalle(this.id, this.item_cant, this.item_PrecioUnitario, this.item_PrecioTotal, this.item_Descuento
        , this.item_Garantia, this.item_PorcGarantia, this.item_CargoSoporte, this.bien1,
                this.pedido_impuesto);
    }

    public DetalleDTO pedidoDetalleToDto(Pedido pedido, List<Pedido_detalle> pedidoDetalleList){
        return DetalleDTO.builder()
                .id(pedido.getId())
                .empresa(pedido.getEmpresa() != null)
                .build();
    }*/

}