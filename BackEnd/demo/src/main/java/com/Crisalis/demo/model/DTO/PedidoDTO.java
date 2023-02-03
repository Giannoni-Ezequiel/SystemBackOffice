package com.Crisalis.demo.model.DTO;

import com.Crisalis.demo.model.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoDTO {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("ord_comprobante")
    private Integer ord_comprobante;
    @JsonProperty("ord_fecha")
    private LocalDate ord_fecha;
    @JsonProperty("ord_totalPedido")
    private BigDecimal ord_TotalPedido;
    @JsonProperty("ord_NomEmpEmisora")
    private String ord_NomEmpEmisora;
    @JsonProperty("ord_DescuentoPorcent")
    private Double ord_DescuentoPorcent;
    @JsonProperty("ord_DescuentoTotal")
    private BigDecimal ord_DescuentoTotal;
    @JsonProperty("estado")
    private Estado estado;
    @JsonProperty("cliente")
    private Cliente cliente;
    @JsonProperty("detalle")
    private Set<Pedido_detalle> pedido_detalle = new HashSet<>();

    /*public Pedido toPedidosEntity(){
        return new Pedido(this.ord_comprobante, this.ord_fecha, this.ord_TotalPedido, this.ord_NomEmpEmisora
        ,this.ord_DescuentoPorcent, this.ord_DescuentoTotal, this.estado, this.cliente);
    }*/

    public Pedido toPedidoEntity(){
        return new Pedido(this.ord_comprobante, this.ord_fecha, this.ord_TotalPedido, this.ord_NomEmpEmisora
                ,this.ord_DescuentoPorcent, this.ord_DescuentoTotal, this.estado, (Set<Pedido_detalle>) this.cliente,
                (Cliente) this.pedido_detalle);
    }
}
