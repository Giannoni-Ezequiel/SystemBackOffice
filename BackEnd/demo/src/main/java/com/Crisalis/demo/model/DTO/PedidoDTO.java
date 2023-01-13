package com.Crisalis.demo.model.DTO;

import com.Crisalis.demo.model.Cliente;
import com.Crisalis.demo.model.Estado;
import com.Crisalis.demo.model.Pedido;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class PedidoDTO {

    @JsonProperty()
    private Integer ord_comprobante;
    @JsonProperty()
    private String ord_fecha;
    @JsonProperty()
    private BigDecimal ord_TotalPedido;
    @JsonProperty()
    private String ord_NomEmpEmisora;
    @JsonProperty()
    private Double ord_DescuentoPorcent;
    @JsonProperty()
    private BigDecimal ord_DescuentoTotal;
    @JsonProperty()
    private Estado estado;
    @JsonProperty()
    private Cliente cliente;

    public Pedido toPedidosEntity(){
        return new Pedido(this.ord_comprobante, this.ord_fecha, this.ord_TotalPedido, this.ord_NomEmpEmisora
        ,this.ord_DescuentoPorcent, this.ord_DescuentoTotal, this.estado, this.cliente);
    }

    public Pedido toPedidoEntity(){
        return new Pedido(this.ord_comprobante, this.ord_fecha, this.ord_TotalPedido, this.ord_NomEmpEmisora
                ,this.ord_DescuentoPorcent, this.ord_DescuentoTotal, this.estado, null);
    }
}
